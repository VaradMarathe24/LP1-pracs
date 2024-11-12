Program: FCFS 
import java.io.*;
import java.util.Scanner;
public class FCFS {
	public static void main(String[] args) {
		int i,no_p,bt[],TT[],WT[];
		float avg_wt=0,avg_TT=0;
		bt=new int[50];
		TT=new int[50];
		WT=new int[50];
		WT[0]=0;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of processes:");
		no_p=s.nextInt();
		System.out.println("Enter the burst time:");
		for(i=0;i<no_p;i++) {
		    System.out.println("\t P"+(i+1)+": ");
		    bt[i]=s.nextInt();
		}
		for(i=1;i<no_p;i++) {
		     WT[i]=WT[i-1]+bt[i-1];
             		     avg_wt+=WT[i];
		}
        avg_wt/=no_p;
        for(i=0;i<no_p;i++)
        {
        TT[i]=WT[i]+bt[i];
        avg_TT+=TT[i];
        }
        avg_TT/=no_p;
		System.out.println("\n****************************************************************");
        System.out.println("\tProcesses:");
        System.out.println("****************************************************************");
        System.out.println("Process\tBurst Time\tWaiting Time\tTurn Around Time");
        for(i=0;i<no_p;i++)
        {
        System.out.println("\tP"+(i+1)+"\t"+bt[i]+"\t\t  "+WT[i]+"\t\t "+TT[i]);
        }
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("\nAverage waiting time : "+avg_wt);
        System.out.println("\nAverage Turn Around time :"+avg_TT+"\n");
	}
}
Output:
Enter the number of processes:
5
Enter the burst time:
         P1: 
2
         P2: 
3
         P3: 
5
         P4: 
7
         P5: 
11

****************************************************************
        Processes:
****************************************************************
Process Burst Time      Waiting Time    Turn Around Time
        P1      2                 0              2
        P2      3                 2              5
        P3      5                 5              10
        P4      7                 10             17
        P5      11                17             28

----------------------------------------------------------------

Average waiting time : 6.8

Average Turn Around time :12.4

