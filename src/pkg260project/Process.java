
package pkg260project;

public class Process {
    private String name;
    private int arrivalTime;
    private int burstTime;
    private int waitingTime;
    private int turnaroundTime;
    private int responseTime;
    int remainingTime;


    Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.responseTime = 0;
        this.remainingTime = 0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the arrivalTime
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the burstTime
     */
    public int getBurstTime() {
        return burstTime;
    }

    /**
     * @param burstTime the burstTime to set
     */
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    /**
     * @return the waitingTime
     */
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * @param waitingTime the waitingTime to set
     */
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    /**
     * @return the turnaroundTime
     */
    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    /**
     * @param turnaroundTime the turnaroundTime to set
     */
    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    /**
     * @return the responseTime
     */
    public int getResponseTime() {
        return responseTime;
    }

    /**
     * @param responseTime the responseTime to set
     */
    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }
    
    
}
