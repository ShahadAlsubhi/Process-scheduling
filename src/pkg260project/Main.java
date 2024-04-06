
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
        //Process[] processes = new Process[nProcess];
        Queue <Process> readyQueue = new LinkedList<>();
        
        //loop to fill several processes arriving at certain time with burst time, in the queue.
        for (int i = 0; i < nProcess; i++) {
            System.out.println("Enter details for process " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();
            //processes[i] = new Process(name, arrivalTime, burstTime);
            readyQueue.add(new Process(name, arrivalTime, burstTime));
        }
        
        
        
        //call the round robin method and send the process queue, time quantum
        // Call the roundRobin method to perform scheduling
        roundRobin(readyQueue, quantum);
    }

    // Implement the Round-Robin scheduling algorithm
    public static void roundRobin(Queue<Process> readyQueue, int quantum) {
        Queue<Process> waitingQueue = new LinkedList<>();
        int currentTime = 0;
        int totalTime = 0;

        // Continue until all processes are executed
        while (!readyQueue.isEmpty() || !waitingQueue.isEmpty()) {
            if (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.poll();
                if (currentProcess.getBurstTime() > quantum) {
                    // If burst time is greater than quantum, execute for quantum time
                    currentProcess.setResponseTime(Math.max(currentTime, currentProcess.getArrivalTime()));
                    currentTime += quantum;
                    currentProcess.setBurstTime(currentProcess.getBurstTime() - quantum);
                    while (!readyQueue.isEmpty() && readyQueue.peek().getArrivalTime() <= currentTime) {
                        waitingQueue.add(readyQueue.poll());
                    }
                    waitingQueue.add(currentProcess);
                } else {
                    // If burst time is less than or equal to quantum, execute fully
                    currentProcess.setResponseTime(Math.max(currentTime, currentProcess.getArrivalTime()));
                    currentTime += currentProcess.getBurstTime();
                    currentProcess.setBurstTime(0);
                    currentProcess.setTurnaroundTime(currentTime - currentProcess.getArrivalTime());
                    currentProcess.setWaitingTime(currentProcess.getTurnaroundTime() - currentProcess.getBurstTime());
                    printResult(currentProcess);
                    totalTime += currentProcess.getTurnaroundTime();
                }
            } else {
                // If no process in ready queue, execute from waiting queue
                Process currentProcess = waitingQueue.poll();
                currentTime += currentProcess.getBurstTime();
                currentProcess.setBurstTime(0);
                currentProcess.setTurnaroundTime(currentTime - currentProcess.getArrivalTime());
                currentProcess.setWaitingTime(currentProcess.getTurnaroundTime() - currentProcess.getBurstTime());
                printResult(currentProcess);
                totalTime += currentProcess.getTurnaroundTime();
            }
        }

    }
    //method to display the results or we just do it here in the main
        

    //  Method to calculate turnaround time of a process
    public static int CalculateTurnaround(int completionTime, Process currentProcess){
        int turnaround = completionTime - currentProcess.getArrivalTime();
        currentProcess.setTurnaroundTime(turnaround);
        return turnaround;
    }
   
    //  Method to calculate waiting time of a process
    public static int CalculateWaiting(Process currentProcess){
        int waiting = currentProcess.getTurnaroundTime() - currentProcess.getBurstTime();
        currentProcess.setWaitingTime(waiting);
        return waiting;
    }
    
    // Method for printing results
    public static void printResult(Process currentProcess){
        System.out.println("Process: " + currentProcess.getName() + "\n Waiting time: " + currentProcess.getWaitingTime() + "\n Turnaround time: " + currentProcess.getTurnaroundTime() + "\n Response time: " + currentProcess.getResponseTime());
    }
}
