package demo

import chisel3._
import chisel3.util._


class usingRegs extends Module {
	val io = IO(new Bundle {
		
	})

	val newRegister = RegInit(8.U(6.W)) //register with a initial value of 8, and a width of 6
	
	newRegister := newRegister + 1.U //only updates the value in newRegister every rising edge
	// newRegister := newRegister - 1.U
	// newRegister := newRegister * 1.U


	val event = true.B

	when(event){ //while event is true.....
		newRegister := newRegister - 1.U
	}



	//Muxes
	val myReg = RegInit(8.U(6.W))

	/*Logic I want to implement: 
	
	if(event):
		myReg = myReg + 1.U
	else:
		myReg = myReg - 1.U
	*/

	//Using muxes:
	//Mux(c, x, y) If c, then x; else y max(w(x), w(y))
	
	myReg := Mux(event, myReg + 1.U, myReg - 1.U)



}
