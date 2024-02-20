package demo

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

//test reset (gives combo loop error)



class srLatchTest extends AnyFlatSpec with ChiselScalatestTester {
    "Latch Test" should s"work" in {
        test(new srLatch){ dut => 

           
            dut.io.r.poke(1.U)
            dut.io.s.poke(0.U)

            dut.io.q.expect(0.U)
            dut.io.nq.expect(1.U)
        }
    }
}
