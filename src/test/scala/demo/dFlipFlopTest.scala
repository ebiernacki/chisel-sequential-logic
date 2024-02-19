package demo

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class dFlipFlopTest extends AnyFlatSpec with ChiselScalatestTester {

    "dFF Test" should s"work" in {
        test(new dFlipFlop).withAnnotations(Seq(WriteVcdAnnotation)){ dut => 

            //d=0, q=0
            dut.io.d.poke(0.U)
            dut.clock.step(1)
            dut.io.q.expect(0.U)

            dut.clock.step(2)


            //d=1, q=1
            dut.io.d.poke(1.U)
            dut.clock.step(1)
            dut.io.q.expect(1.U)

            dut.clock.step(2)

            //d=0, then 1 but q=0 for that clock tick
            dut.io.d.poke(0.U)
            dut.clock.step(1)
            dut.io.d.poke(1.U)
            dut.io.q.expect(0.U)

            dut.clock.step(2)


            

            // dut.io.d.poke(0.U)
            // dut.clock.step(1)
            // dut.io.d.poke(1.U)
            // dut.io.q.expect(0.U)


            // dut.clock.step(3)


            // // Test case: Set D to 1
            // dut.io.d.poke(1.U)
            // dut.clock.step(1)
            // dut.io.q.expect(1.U)


            // dut.clock.step(3)


            // dut.io.d.poke(0.U)
            // dut.clock.step(1)
            // dut.io.q.expect(0.U)

        }
    }
}