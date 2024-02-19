package Timing


import chisel3._
import chisel3.util._

class SimpleCounter extends Module{
    val io = IO(new Bundle {
        val countMax = Input(UInt(4.W))
        val currentCount = Output(UInt(4.W))
    })

    val CNT_MAX = io.countMax

    val cntReg = RegInit(0.U(4.W))

    cntReg := cntReg + 1.U

    when(cntReg === CNT_MAX) {
        cntReg := 0.U
    }

    io.currentCount := cntReg
}