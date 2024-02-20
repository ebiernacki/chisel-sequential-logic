package Timing

import chisel3._
import chisel3.util._


//A counter that counts for n ticks and then sets io.flag high for one clock tick
//width is the bit-width of ticks so you can properly set your register

class AnyCounter(ticks : Int, width : Int) extends Module{
    val io = IO(new Bundle {
        val flag = Output(Bool())
    })
    




}