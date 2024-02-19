package demo

import chisel3._

class usingRegs extends Module {
	val io = IO(new Bundle {
		
	})

	val newRegister = RegInit(8.U(6.W)) //register with a initial value of 8, and a width of 6
	
	newRegister := newRegister + 1.U //only updates the value in newRegister every rising edge


	
	val event = true.B

	when (event){ //while event is true.....
		newRegister := newRegister - 1.U

	}
}
