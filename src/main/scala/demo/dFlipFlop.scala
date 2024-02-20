package demo

import chisel3._
import chisel3.util._

class dFlipFlop extends Module {
	val io = IO(new Bundle {
		val d = Input(Bool())    // Data input
		val q = Output(Bool())   // Output Q
	})

	val reg = RegNext(io.d)   // Register to store the input value

	// Output the stored value on the positive edge of the clock
	io.q := reg
}
