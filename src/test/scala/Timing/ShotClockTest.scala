package Timing

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class ShotClockTest extends AnyFlatSpec with ChiselScalatestTester {

    "ShotClock Test" should s"work" in {
        //test for count down and shot clock violation
        test(new ShotClock){ dut => 
            for (_ <- 0 until 24){
                dut.clock.step(10)
                println(dut.io.timeleft.peek())
            }
            dut.clock.step(11)
            dut.io.shotClockViolation.expect(true.B)
            println(dut.io.shotClockViolation.peek())
            dut.clock.step(10)
        }


        //test simulated shot with reset
        test(new ShotClock).withAnnotations(Seq(WriteVcdAnnotation)){ dut => 
            
            for (_ <- 0 until 10){
                dut.clock.step(10)
                println(dut.io.timeleft.peek())
            }

            dut.reset.poke(true.B)
            dut.clock.step(1)
            dut.reset.poke(false.B)
            dut.io.timeleft.expect(24.U)
            println(dut.io.timeleft.peek())

            dut.clock.step(11)
            dut.io.timeleft.expect(23.U)
            println(dut.io.timeleft.peek())
            
            for (_ <- 0 until 10){
                dut.clock.step(10)
                println(dut.io.timeleft.peek())
            }
        }
    }
}
