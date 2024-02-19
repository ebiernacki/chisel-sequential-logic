package demo

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class srFlipFlopTest extends AnyFlatSpec with ChiselScalatestTester {

    "FF Test" should s"work" in {
        test(new srFlipFlop).withAnnotations(Seq(WriteVcdAnnotation)){ dut => 
            dut.io.r.poke(0.U)
            dut.io.s.poke(1.U)
            dut.clock.step(1)
            dut.io.q.expect(1.U)
            dut.io.nq.expect(0.U)

            dut.clock.step(4)

            dut.io.r.poke(1.U)
            dut.io.s.poke(0.U)
            dut.clock.step(1)
            dut.io.q.expect(0.U)
            dut.io.nq.expect(1.U)
            
            dut.clock.step(4)
        }
    }
}
