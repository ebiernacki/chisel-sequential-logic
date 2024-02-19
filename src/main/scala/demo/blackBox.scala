package demo

import chisel3._
import chisel3.util._
import chisel3.experimental._
import chisel3.experimental.BundleLiterals._
import chisel3.util.HasBlackBoxInline

class dFFIO extends Bundle{
    val d   = Input(UInt(1.W))
    val clk = Input(Clock())
    val rst = Input(Bool())

    val q   = Output(UInt(1.W))

    //val nq  = Output(UInt(1.W))
    
}

class blackBox extends HasBlackBoxInline {
    val io = IO(new dFFIO)
    setInline("InlineBlackBoxDFF.v",
    s"""
    |module InlineBlackBoxDFF(d, clk, rst, q);
    |input d, clk, rst;
    |output reg q;
    |
    |always @(posedge clk or posedge rst) 
    |begin
    |if(rst == 1'b1)
    |q <= 1'b0;
    |else
    |q <= d;
    |end 
    |endmodule 
     """.stripMargin)

}