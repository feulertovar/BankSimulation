/**
 * 
 */
package proj2cs342;

//---------------------------------------------------------------------------
//
//Node for Queue Simulation (Queue)
//Queue used in the simulation of a small Bank
//
//Author: Feuler Tovar
//Date: 04/04/19
//Class: MET CS342, Project 2
//Issues: None known
//
//Description:
//Node of a Person's data to be used for the queue that will help with the operations of a small bank.

//
//Assumptions:
//
//

public class Node {
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	private Person data;
	private Node next;
	
	
	public Person getData() {
		return data;
	}

	public void setData(Person data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	/**
	 * 
	 */
	public String toString() {
		String rtn = ("Serve: " + data.servtime + "Wait: " + data.qtime +"\n");		
		return rtn;
	}

}
