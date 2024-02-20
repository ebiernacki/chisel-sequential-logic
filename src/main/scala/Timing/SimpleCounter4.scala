package Timing


import chisel3._
import chisel3.util._

//4 bit wide counter that counts up

class SimpleCounter4 extends Module{
    val io = IO(new Bundle {
        val countMax = Input(UInt(4.W))
        val currentCount = Output(UInt(4.W))
    })

    //set the max value we count up to
    val CNT_MAX = io.countMax

    //create a reg so it updates on every rising edge
    val cntReg = RegInit(0.U(4.W))

    //this increments the reg every rising edge
    cntReg := cntReg + 1.U


    //check when to reset our value
    when(cntReg === CNT_MAX) {
        cntReg := 0.U
    }

    //finally connect to our io
    io.currentCount := cntReg
}