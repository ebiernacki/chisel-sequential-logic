package Timing

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class ShotClockTest extends AnyFlatSpec with ChiselScalatestTester {

    "ShotClock Test" should s"work" in {
        //test for count down and shot clock violation
        test(new ShotClock){ dut => 
            for (_ <- 0 until 25){
                dut.clock.step(10)
                println(dut.io.timeLeft.peek())
            }
            dut.clock.step(1)
            dut.io.shotClockViolation.expect(true.B)
            println(dut.io.shotClockViolation.peek())
            dut.clock.step(10)
        }

        //test simulated shot with io.shot
        test(new ShotClock).withAnnotations(Seq(WriteVcdAnnotation)){ dut => 
            
            for (_ <- 0 until 10){
                dut.clock.step(10)
                println(dut.io.timeLeft.peek())
            }

            //wiggle io.shot
            dut.io.shot.poke(true.B)
            dut.clock.step(1)
            dut.io.shot.poke(false.B)
            //expect shotclock reset
            dut.io.timeLeft.expect(24.U)
            println(dut.io.timeLeft.peek())

            //should continue to count down
            dut.clock.step(11)
            dut.io.timeLeft.expect(23.U)
            println(dut.io.timeLeft.peek())
            
            for (_ <- 0 until 10){
                dut.clock.step(10)
                println(dut.io.timeLeft.peek())
            }
        }
    }
}
