
package pkg260project;

import java.util.*;

public class Main {

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Round Robin Scheduling Algorithm!");
        System.out.println("This program simulates process scheduling using Round Robin.");
        System.out.println("Let's get started!");
        
        //ask the user to enter the number of processes and time quantum.
        System.out.print("Enter the number of processes: ");
        int nProcess = scanner.nextInt();

        System.out.print("Enter the time quantum: ");
        int quantum = scanner.nextInt();

        Queue<Process> readyQueue = new LinkedList<>();
        
        //loop to fill several processes arriving at certain time with burst time, in the queue.
        for (int i = 0; i < nProcess; i++) {
            System.out.println("Enter details for process " + (i + 1) + ":");
            System.out.print("Process Name: ");
            String name = scanner.next();
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();

            readyQueue.add(new Process(name, arrivalTime, burstTime));

        }

        roundRobin(readyQueue, quantum);
    }

    

    //----------------------------------------------------------------------------------
    // Implement the Round-Robin scheduling algorithm
    public static void roundRobin(Queue<Process> readyQueue, int quantum) {

        int currentTime = 0;

        // Continue until all processes are fully executed
        while (!readyQueue.isEmpty()) {
            Process currentProcess = readyQueue.poll();
            if (currentProcess.getRemainingTime() > quantum) {
                // If burst time is greater than quantum, execute for quantum time
                currentProcess.setResponseTime(Math.max(currentTime, currentProcess.getArrivalTime()));
                currentTime += quantum;
                currentProcess.setRemainingTime(currentProcess.getRemainingTime() - quantum);
                readyQueue.add(currentProcess);
            } else {
                // If burst time is less than or equal to quantum, execute fully
                currentProcess.setResponseTime(Math.max(currentTime, currentProcess.getArrivalTime()));
                currentTime += currentProcess.getRemainingTime();
                currentProcess.setRemainingTime(0);
                CalculateTurnaround(currentTime, currentProcess);
                CalculateWaiting(currentProcess);
                printResult(currentProcess);
            }
        }
    }

    //----------------------------------------------------------------------------------
    //  Method to calculate turnaround time of a process
    public static void CalculateTurnaround(int completionTime, Process currentProcess) {
        int turnaround = completionTime - currentProcess.getArrivalTime();
        currentProcess.setTurnaroundTime(turnaround);
    }

    //----------------------------------------------------------------------------------
    //  Method to calculate waiting time of a process
    public static void CalculateWaiting(Process currentProcess) {
        int waiting = currentProcess.getTurnaroundTime() - currentProcess.getBurstTime() - currentProcess.getArrivalTime();
        currentProcess.setWaitingTime(waiting);
    }

    //----------------------------------------------------------------------------------
    // Method for printing results
    public static void printResult(Process currentProcess) {
        System.out.println("-----------------------\nProcess: " + currentProcess.getName() + "\n Turnaround time: " + currentProcess.getTurnaroundTime() + "\n Waiting time: " + currentProcess.getWaitingTime() + "\n Response time: " + currentProcess.getResponseTime());
    }
}
