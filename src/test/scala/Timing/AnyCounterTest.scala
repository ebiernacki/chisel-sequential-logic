package Timing

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class AnyCounterTest extends AnyFlatSpec with ChiselScalatestTester {

    "Counter Test" should s"work" in {
        test(new AnyCounter(10)){ dut => 
            dut.io.flag.expect(false.B)

            dut.clock.step(10)
            // Flag should be asserted after 1 second
            dut.io.flag.expect(true.B)

            //test the counter resets back to 0
            dut.clock.step(10)
            dut.io.flag.expect(true.B)

            dut.clock.step(2) 
            dut.io.flag.expect(false.B)

        }
        test(new AnyCounter(100)).withAnnotations(Seq(WriteVcdAnnotation)){ dut => 
            dut.io.flag.expect(false.B)

            dut.clock.step(100)
            dut.io.flag.expect(true.B)

            // Reset flag
            dut.clock.step(2)
            dut.io.flag.expect(false.B)

            //wiggle reset
            dut.clock.step(50)
            dut.reset.poke(true.B)
            dut.clock.step(1)
            dut.reset.poke(false.B)

            dut.clock.step(20)
            dut.io.flag.expect(false.B)

        }
    }
}
