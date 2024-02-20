package Timing

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import firrtl2.Utils

class SimpleCounterTest extends AnyFlatSpec with ChiselScalatestTester {
    it should s"Test SimpleCounter" in {
        test(new SimpleCounter4).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
            dut.io.countMax.poke(15.U)
            
            for(i <- 0 until 30){
                println(dut.io.currentCount.peek().litValue)
                dut.clock.step(1)
            }

        }
    }
    it should s"Test SimpleCounter with reset" in {
        test(new SimpleCounter4).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
            dut.io.countMax.poke(15.U)

            for(i <- 0 until 25){
                println(dut.io.currentCount.peek().litValue)
                dut.clock.step(1)

                if(i == 18){
                    println("Setting Reset")
                    dut.reset.poke(true.B)
                }
                if(i == 19){
                    println("Unsetting Reset")
                    dut.reset.poke(false.B)
                }
            }
        }
    }
}