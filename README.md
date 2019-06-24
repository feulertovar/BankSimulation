# BankSimulation
Bank Simulation (Queue Based). Simulates the 8 hr operations of a small bank of two tellers..
Used a LinkedList based Queue in the Data Model to hold Teller and Customer information.

The bank will be minute based. Each customer will be added to the queue at a random interval from 1 to 4 minutes. Run the simulation for 480 minutes. Use the following Algorithm:
1) Choose a random integer between 1 and 4 to determine the arrival of the first customer.
2) At the first customer arrival
a. Determine customers service time (random 1 to 4 minutes)
b. Begin servicing the customer
c. Schedule arrival time of next customer (random 1 to 4 added to current time)
3) For each minute of the day
a. If the next customer arrives:
i. Say so (Print out a message)
ii. Enqueue the customer
iii. Schedule the arrival of the next customer
b. If service was completed for the last customer
i. Say so (Print out a message)
ii. Dequeue next customer to be serviced
iii. Determine customer’s completion time (random 1 to 4 added to current time)
4) Now run the simulation for 480 minutes, and answer the following (programmatically):
a. What is the maximum number of customers in queue at any point in time?
b. What is the longest wait any one customer experiences?
c. What happens if the arrival time (Not the service time) is changed from 1 to 4, to 1 to
3?

