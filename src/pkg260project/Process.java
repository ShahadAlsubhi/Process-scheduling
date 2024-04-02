
package pkg260project;

public class Process {
    String name;
    int arrivalTime;
    int burstTime;
    int waitingTime;
    int turnaroundTime;
    int responseTime;
    // int remainingTime;
    
    Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.responseTime = 0;
        //this.remainingTime = 0;
    }
    
    
}
