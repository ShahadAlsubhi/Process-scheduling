
package pkg260project;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        //ask the user to enter the number of processes and time quantum.
        System.out.print("Enter the number of processes: ");
        int nProcess = scanner.nextInt();
        
        System.out.print("Enter the time quantum: ");
        int quantum = scanner.nextInt();
        
        //queue data structure to represent the Process Control Block (PCB).
        Process[] processes = new Process[nProcess];
        
        //loop to fill several processes arriving at certain time with burst time, in the queue.
        for (int i = 0; i < nProcess; i++) {
            System.out.println("Enter details for process " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();
            processes[i] = new Process(name, arrivalTime, burstTime);
        }
        
        
        
        //call the round robin method and send the process queue, time quantum
        
        //method to display the results or we just do it here in the main 
        
    }
    
}
