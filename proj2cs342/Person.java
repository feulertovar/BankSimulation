/**
 * 
 */
package proj2cs342;
//---------------------------------------------------------------------------
//
//Person Model for Queue Simulation (Queue)
//Queue used in the simulation of a small Bank
//
//Author: Feuler Tovar
//Date: 04/04/19
//Class: MET CS342, Project 2
//Issues: None known
//
//Description:
//Data Model of a Person to be used for the queue that will help with the operations of a small bank.
//
//Assumptions:
//
//
public class Person {

	/**
	 * 
	 */
	
	public int servtime;			// Time to service person

	public int qtime;			// Time person was enqueued
	public boolean serveCompleted = false;
	public int teller;
	public int completionTime;
	public int id;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(int completionTime) {
		this.completionTime = completionTime;
	}

	
	public boolean isServeCompleted() {
		return serveCompleted;
	}

	public void setServeCompleted(boolean serveCompleted) {
		this.serveCompleted = serveCompleted;
	}

	public int getTeller() {
		return teller;
	}

	public void setTeller(int teller) {
		this.teller = teller;
	}

	
	public int getServtime() {
		return servtime;
	}

	public void setServtime(int servtime) {
		this.servtime = servtime;
	}

	public int getQtime() {
		return qtime;
	}

	public void setQtime(int qtime) {
		this.qtime = qtime;
	}


}
