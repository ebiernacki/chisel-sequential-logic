package Timing


import chisel3._
import chisel3.util._

//4 bit wide counter that counts up and resets to 0 when the countMax is hit
//it keeps track of the count in currentCount which increments every clock tick
class SimpleCounter4 extends Module{
    val io = IO(new Bundle {
        val countMax = Input(UInt(4.W))
        val currentCount = Output(UInt(4.W))
    })
    //set the max value we count up to
    val CNT_MAX = io.countMax


    
    //create a reg so it updates on every rising edge
    val cntReg = RegInit(0.U(4.W))


    //Mux to choose increment or set to 0
    cntReg := Mux(cntReg === CNT_MAX, 0.U, cntReg + 1.U)

    //finally connect to our io
    io.currentCount := cntReg

   
}