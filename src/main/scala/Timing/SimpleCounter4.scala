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



    
}