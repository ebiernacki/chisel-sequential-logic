package Timing

import chisel3._
import chisel3.util._


//this module has a "shot" input that should reset your shot clock back to 24, and an output of timeLeft on the shotclock which should decrement, 
//along with the output boolean if there has been a shot clock violation (the shot clock hit 0)

//You can use your AnyCounter here, and for testing I recommend that you set your tick value around 10 so that your tests run quickly and so that you can see it on the waveform.

class ShotClock extends Module{
    val io = IO(new Bundle {
        val shot = Input(Bool())
        val timeLeft = Output(UInt(5.W))
        val shotClockViolation = Output(Bool())
    })
    
    

    
}