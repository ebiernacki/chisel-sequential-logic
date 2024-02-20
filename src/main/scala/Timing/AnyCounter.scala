package Timing

import chisel3._
import chisel3.util._

class AnyCounter(ticks : Int) extends Module{
    val io = IO(new Bundle {
        val flag = Output(Bool())
    })

    val flagVal = RegInit(false.B)

    // val CNT_MAX = (100000000 - 1).U //for basys3
    val CNT_MAX = (ticks - 1).U 
    val cntReg = RegInit(0.U(32.W))


    cntReg := cntReg + 1.U

    when(cntReg === CNT_MAX) {
        flagVal := true.B
        cntReg := 0.U
    }.otherwise {
        flagVal := false.B
    }

    io.flag := flagVal
    
}