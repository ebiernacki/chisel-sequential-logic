package demo

import chisel3._

class srFlipFlop extends Module { 
    val io = IO(new Bundle{
        val r = Input(Bool())
        val s = Input(Bool())

        val q = Output(Bool())
        val nq = Output(Bool())
    })  

    val qReg = RegInit(false.B)

    // Set the Q output
    when(io.s && !io.r) {
        qReg := true.B
    }
    // Reset the Q output
    .elsewhen(!io.s && io.r) {
        qReg := false.B
    }

    // Output Q and Q'
    io.q := qReg
    io.nq := ~qReg

}