/**
 * 
 */
package proj2cs342;

import java.util.Random;
//---------------------------------------------------------------------------
//
//Bank Simulation (Queue Based)
//Simulates the 8 hr operations of a small bank of two tellers..
//
//Author: Feuler Tovar
//Date: 04/04/19
//Class: MET CS342, Project 2
//Issues: None known
//
//Description:
//This program is a queue based simulation of a small bank.
//The line at the bank will be a queue. 
//The bank will be minute based. 
//Each customer will be added to the queue at a random interval from 1 to 4 minutes. 
//Simulation will run for 480 minutes. 
//
//Assumptions:
//First customer's arrival is scheduled and then they are serviced immediately.
//

public class QueDrive {

	// Init Queues for arriving customers
	LQueue line = new LQueue();
	private static int maxCustomer = 0;
	private static int maxWaittime = 0;
	private static final int min = 1;
	private static final int max = 3;
	// Init number of Tellers = 2
	Teller[] tellers = new Teller[2];
	Person removee; // item being removed from queue

	public QueDrive() {
		// TODO Auto-generated constructor stub
	}

	///////////////////////////////////////////////////////////////////
	/// main program entry point ///
	/// Input : arguments. (these are ignored for this program) ///
	/// Output: None ///
	/// Returns nothing ///
	/// ///
	///////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueDrive qd = new QueDrive();
		qd.sim();

	}

	///////////////////////////////////////////////////////////////////
	/// sim (Worker method called from main) ///
	/// Input : None ///
	/// Output: None ///
	/// Returns Nothing ///
	/// ///
	///////////////////////////////////////////////////////////////////
	public void sim() {

		// Init number of customers
		int numCus = 0;
		// init system time
		int curTime = 0;
		// init next Arrival time
		int arrTime = 0;
		// init next Arrival time
		int servTime = 0;
		// init simulation time in minutes
		int simTime = 480;

		// Initialize Tellers
		for (int i = 0; i < tellers.length; i++) {
			tellers[i] = new Teller();
		}

		// first customer
		if (line.isEmpty()) {

			// calculate arrival time
			arrTime = getRandom(min, max);

			// Announce arrival
			System.out.println("Customer arrived at min " + arrTime);

			// calulate service time
			servTime = getRandom(min, max);

			// add to line
			Person p = new Person();
			p.setServtime(servTime);
			line.add(p);

			// customer arrives
			curTime = arrTime;

			// Service Customer
			serve(curTime);

			// schedule next arrival of next customer
			arrTime = curTime + getRandom(min, max);

		}

		//
		// Run the simulation
		//
		for (curTime = 0; curTime < simTime; curTime++) {

			// if the next customer arrives
			if (newCustomer(curTime, arrTime)) {
				System.out.println("Customer arrived at min " + curTime);

				// Enqueue the customer
				if (line.isFull()) {
					return;
				} else {
					numCus++;
					Person per = new Person(curTime);
					per.setQtime(arrTime);
					per.setServtime(getRandom(min, max));
					line.add(per);
				}

				// Schedule the arrival of the next customer
				arrTime = curTime + getRandom(min, max);
			}

			// Service customers if a Teller is free
			if (!line.isEmpty()) {
				// DeQueue && Serve
				Person customer = new Person();
				customer = serve(curTime);

				// if service was completed for the last customer
				if (customer.isServeCompleted()) {
					customer.setCompletionTime(curTime + getRandom(min, max));
					System.out.println("Teller " + customer.getTeller() + " finished customer at min "
							+ customer.getCompletionTime());

					// keep track of Max wait time
					int timeInQ = curTime - customer.getQtime();
					if (timeInQ > maxWaittime)
						maxWaittime = timeInQ;

				}
			}
		}

		// Print out some Statistics
		System.out.println();
		System.out.println("Maxium number of customers in queue at any point = " + maxCustomer);
		System.out.println("longest wait experienced by customer = " + maxWaittime + " min");
		System.out.println();

	}

	///////////////////////////////////////////////////////////////////
	/// server (Worker method called from sim()) ///
	/// Input : int ( curTime ) ///
	/// Output: Person ///
	/// Returns customer ///
	/// ///
	///////////////////////////////////////////////////////////////////
	public Person serve(int curTime) {
		// Loop through tellers to see who is free
		Person customer = new Person();

		if (line.peek() != null) {
			for (int i = 0; i < tellers.length; i++) // Check for an open Teller.
				if (tellers[i].active == false && line.size() != 0) {
					// deQueue
					customer = line.remove();
					tellers[i].active = true;
					tellers[i].setTimer(customer.getServtime());
					customer.setTeller(i);
					customer.setServeCompleted(true);
				}
		}

		for (int i = 0; i < tellers.length; i++) { // Check for an open Teller.
			if (tellers[i].active == true) {
				tellers[i].timer--;
			}
			if (tellers[i].timer == 0 && tellers[i].active == true) {
				tellers[i].active = false;
			}
		}

		if (!customer.isServeCompleted()) {

			customer.setQtime(customer.getQtime() + 1);

		}

		// keep track of Queue size.
		if (line.size() > maxCustomer)
			maxCustomer = line.size();

		return customer;
	}

	///////////////////////////////////////////////////////////////////
	/// newCustomer (Worker method called from sim()) ///
	/// Input : curTime, arTime ///
	/// Output: boolean ///
	/// Returns true if curTime == arTime ///
	/// ///
	///////////////////////////////////////////////////////////////////
	private static boolean newCustomer(int curTime, int arTime) {
		return (curTime == arTime);
	}

	///////////////////////////////////////////////////////////////////
	/// getRandom (Worker method called from sim()) ///
	/// Input : min, max ///
	/// Output: int ///
	/// Returns Randomly generated number from min - max ///
	/// ///
	///////////////////////////////////////////////////////////////////
	private static int getRandom(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		// Random rand = new Random(31415926535L);
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

}
