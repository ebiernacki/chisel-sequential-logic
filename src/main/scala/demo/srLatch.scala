package demo

import chisel3._

class srLatch extends Module { 
    val io = IO(new Bundle{
        val r = Input(UInt(1.W))
        val s = Input(UInt(1.W))

        val q = Output(UInt(1.W))
        val nq = Output(UInt(1.W))
    })  

    val nor1 = !(io.r | io.nq) 
    val nor2 = !(io.s | io.q) 

    io.q := nor1
    io.nq := nor2

}