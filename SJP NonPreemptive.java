Program: SJF Non Preemptive 
import java.util.Scanner;
 class SJFNP {
    int pid, burstTime, arrivalTime, waitingTime, turnaroundTime;
    public SJFNProcess(int pid, int burstTime, int arrivalTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }
 }
 public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        SJFNProcess[] processes = new SJFNProcess[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time and burst time for process " + (i + 1) + ": ");
            int at = sc.nextInt();
            int bt = sc.nextInt();
            processes[i] = new SJFNProcess(i + 1, bt, at);
        }
        // Sort processes by arrival time and burst time
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (processes[j].burstTime > processes[j + 1].burstTime) {
                    SJFNProcess temp = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = temp;
                }
            }
        }
        int totalTime = 0, totalWT = 0, totalTAT = 0;
        for (SJFNProcess p : processes) {
            p.waitingTime = totalTime - p.arrivalTime;
            totalTime += p.burstTime;
            p.turnaroundTime = p.waitingTime + p.burstTime;
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }
        // Print Gantt Chart
        System.out.println("Gantt Chart: ");
        for (SJFNProcess p : processes) {
            System.out.print("P" + p.pid + " ");
        }
        System.out.println("\n");
        // Print process details
        System.out.println("Process\tArrival\tBurst\tWaiting\tTurnaround");
        for (SJFNProcess p : processes) {
            System.out.println("P" + p.pid + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime);
        }
        System.out.println("Average Waiting Time: " + (totalWT / (float) n));
        System.out.println("Average Turnaround Time: " + (totalTAT / (float) n));
        sc.close();
    }
 }
Output:
Enter number of processes: 5
Enter arrival time and burst time for process 1: 7 4
Enter arrival time and burst time for process 2: 5 3 
Enter arrival time and burst time for process 3: 2 7
Enter arrival time and burst time for process 4: 3 5
Enter arrival time and burst time for process 5: 2 4
Gantt Chart: 
P2 P1 P5 P4 P3 

Process Arrival Burst   Waiting Turnaround
P2      5       3       -5      -2
P1      7       4       -4      0
P5      2       4       5       9
P4      3       5       8       13
P3      2       7       14      21
Average Waiting Time: 3.6
Average Turnaround Time: 8.2
