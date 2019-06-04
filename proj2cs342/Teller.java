package proj2cs342;
//---------------------------------------------------------------------------
//
//Teller Model for Queue Simulation (Queue)
//Queue used in the simulation of a small Bank
//
//Author: Feuler Tovar
//Date: 04/04/19
//Class: MET CS342, Project 2
//Issues: None known
//
//Description:
//Data Model of a Teller to be used for the queue that will help with the operations of a small bank.
//
//Assumptions:
//
//
public class Teller {

	public Teller() {
		// TODO Auto-generated constructor stub
	}
	
	int timer = 0;
	boolean active = false;
	
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
