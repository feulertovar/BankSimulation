/**
 * 
 */
package proj2cs342;

//---------------------------------------------------------------------------
//
//Queue Simulation (Queue)
//Queue used in the simulation of a small Bank
//
//Author: Feuler Tovar
//Date: 04/04/19
//Class: MET CS342, Project 2
//Issues: None known
//
//Description:
//This is a queue that will help with the operations of a small bank.
//The bank will service customer using two tellers
//The bank will be opened for 480 mins. 
//
//Assumptions:
//
//
public class LQueue {

	/**
	 * 
	 */
	public LQueue() {
		// TODO Auto-generated constructor stub
	}

	// Head of the list for the stack, and the count of elements.
	private Node head = null;
	private Node tail = null;
	private int count = 0;

	///////////////////////////////////////////////////////////////////
	/// remove (Remove item from queue) 							///
	/// Input : nothing 											///
	/// Output: queue Node, Person Model. 							///
	/// Returns Person if remove is successful, null otherwise 		///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public Person remove() {
		if (isEmpty()) {
			return null;
		} else {
			Person tmp = head.getData();
			if (count == 1) {
				// Now empty
				head = tail = null;
				count = 0;
			} else {
				head = head.getNext();
				count--;
			}
			return tmp;
		}
	}

	///////////////////////////////////////////////////////////////////
	/// push (Add person to queue) 									///
	/// Input : Person object to be added 							///
	/// Output: Always true 										///
	/// Returns true if insert is successful, false otherwise 		///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public boolean add(Person data) {

		Node n = new Node();
		n.setData(data);
		n.setNext(null);

		if (count == 0) {
			head = tail = n;
			count = 1;
		} else {
			tail.setNext(n);
			tail = n;
			count++;
		}

		return true;
	}

	///////////////////////////////////////////////////////////////////
	/// isEmpty (Are there Nodes on the queue?) 					///
	/// Input : None 												///
	/// Output: boolean 											///
	/// Returns true if empty, false otherwise 						///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public boolean isEmpty() {
		return (count == 0);
	}

	///////////////////////////////////////////////////////////////////
	/// isFull (Is the queue full? Never!) 							///
	/// Input : None 												///
	/// Output: boolean 											///
	/// Returns false otherwise										///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public boolean isFull() {
		return false;
	}

	///////////////////////////////////////////////////////////////////
	/// peek (take a look at head of the queue) 					///
	/// Input : None 												///
	/// Output: Node 												///
	/// Returns data node for head of queue, null if queue is empty ///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public Person peek() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getData();
		}
	}

	///////////////////////////////////////////////////////////////////
	/// size (what is the size of the queue) 						///
	/// Input : None 												///
	/// Output: int 												///
	/// Returns queue size as an int 								///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public int size() {
		return count;
	}

	///////////////////////////////////////////////////////////////////
	/// maxSize (what is the Max size of the queue) 				///
	/// Input : None 												///
	/// Output: int 												///
	/// Returns queue size as an int 								///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public int maxSize() {
		return Integer.MAX_VALUE;
	}

	///////////////////////////////////////////////////////////////////
	/// toString (print the queue) 									///
	/// Input : None 												///
	/// Output: String representation of queue 						///
	/// 															///
	///////////////////////////////////////////////////////////////////
	public String toString() {
		String rtn = "head -> ";

		Node tmp = head;
		while (tmp != null) {
			// rtn += tmp.getData().servtime + "\n";
			rtn += "Customer Serve: " + tmp.getData().servtime + " min, " + "Qtime: " + tmp.getData().qtime + " min"
					+ "\n";
			tmp = tmp.getNext();
		}

		return rtn;
	}

}
