package Timing

import chisel3._
import chisel3.util._

class ShotClock extends Module{
    val io = IO(new Bundle {
        val shot = Input(Bool())
        val timeLeft = Output(UInt(5.W))
        val shotClockViolation = Output(Bool())
    })
    
    val shotClock = RegInit(24.U(5.W)) // Initialize shot clock to 24
    val scVio = RegInit(false.B) // Initialize no shotclock violation
 
    //create a counter
    val counter = Module(new AnyCounter(10, 25)) 

    //when the counters flag is high, decrement the shotclock
    shotClock := Mux(counter.io.flag, shotClock - 1.U, shotClock) 


    //scViolation and scReset logic
    val scVioReset = (shotClock === 0.U) && counter.io.flag
    scVio := Mux(scVioReset, true.B, false.B)

    when(scVioReset){
        shotClock := 24.U
    }
    when(io.shot){
        shotClock := 24.U
    }


    io.timeLeft := shotClock
    io.shotClockViolation := scVio
}