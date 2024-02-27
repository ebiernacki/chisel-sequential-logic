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
    
    val shotClock = RegInit(24.U(5.W)) // Initialize shot clock to 24
    val scVio = RegInit(false.B) // Initialize no shotclock violation

    //create a counter
    val counter = Module(new AnyCounter(10, 4)) 
    val scVioReset = ((shotClock === 0.U) && counter.io.flag) 

    //when the counters flag is high, decrement the shotclock
    // shotClock := Mux(counter.io.flag, shotClock - 1.U, shotClock) 
    //REPLACE WITH MUX CASE
    shotClock := MuxCase(shotClock, Seq(
        (io.shot)      -> 24.U,
        (counter.io.flag) -> (shotClock- 1.U),
        (scVioReset)      -> 24.U))


    //scViolation and scReset logic
    scVio := Mux(scVioReset, true.B, false.B)


    //REPLACED WITH MUXCASE
    // when(scVioReset){
    //     shotClock := 24.U
    // }

    // when(io.shot){
    //     shotClock := 24.U
    // }


    io.timeLeft := shotClock
    io.shotClockViolation := scVio

    
}