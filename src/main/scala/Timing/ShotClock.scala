package Timing

//Count down from 24, if using reset signal as "shot", or could use external signal and reset manually

import chisel3._
import chisel3.util._

class ShotClock extends Module{
    val io = IO(new Bundle {
        val timeleft = Output(UInt(5.W))
        val shotClockViolation = Output(Bool())
    })
    
    val shotClock = RegInit(24.U(5.W)) // Initialize shot clock to 24
    val scVio = RegInit(false.B)

    
    val counter = Module(new AnyCounter(10))

    // Connect the counter's flag output to the output of the shot clock module
    when(counter.io.flag === true.B){
        shotClock := shotClock - 1.U
    }

    when(shotClock === 0.U && counter.io.flag === true.B){
        scVio := true.B
        // counter.reset := true.B
        shotClock := 24.U
    }.otherwise {
        scVio := false.B
    }


    io.timeleft := shotClock
    io.shotClockViolation := scVio
    
    
}