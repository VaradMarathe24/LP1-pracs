import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		int bt[],process[],wt[],tat[],arr_time[],ct[],i,j,n,total=0,total_comp=0,pos,temp;
		float wait_avg,tat_avg;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number of processes:");
		n=s.nextInt();
		process=new int[n];
		bt=new int[n];
		wt=new int[n];
		tat=new int[n];
		arr_time=new int[n];
		ct=new int[n];
		//Burst time 
		System.out.println("\nEnter Burst time:");
        for(i=0;i<n;i++)
        {
        System.out.print("\nProcess["+(i+1)+"]: ");
        bt[i] = s.nextInt();;
        process[i]=i+1; //Process Number
        }
        System.out.println("\nEnter arrival time:");
        for(i=0;i<n;i++)
        {
        System.out.print("\nProcess["+(i+1)+"]: ");
        arr_time[i] = s.nextInt();
        process[i]=i+1; //Process Number
        }
        //Sorting
        for(i=0;i<n;i++)
        {
        pos=i;
        for(j=i+1;j<n;j++)
        { if(bt[j]<bt[pos])
        pos=j;
        }
        temp=bt[i];
        bt[i]=bt[pos];
        bt[pos]=temp;
        temp=process[i];
        process[i]=process[pos];
        process[pos]=temp;
        System.out.println("process"+process[i]);
        }
        //completion time new 
        for(i=1;i<n;i++)
        {
        ct[i]=0;
        for(j=0;j<i;j++)
        ct[i]+=bt[j];
        total_comp+=ct[i];
        }
        //First process has 0 waiting time
        wt[0]=0;
        //calculate waiting time
        for(i=1;i<n;i++)
        {
        wt[i]=0;
        for(j=0;j<i;j++)
        wt[i]+=bt[j];
        total+=wt[i];
        }
        //Calculating Average waiting time
        wait_avg=(float)total/n;
        total=0;
        System.out.println("\nPro_number\t Burst Time \tcompletion_time\tWaiting Time\tTurnaround Time");
        for(i=0;i<n;i++) {
        tat[i]=bt[i]+wt[i];

        total+=tat[i];
        System.out.println("\n"+process[i]+"\t\t "+bt[i]+"\t\t"+ct[i]+"\t\t"+wt[i]+"\t\t "+tat[i]);
        }
        //Calculation of Average Turnaround Time
        tat_avg=(float)total/n;
        System.out.println("\n\nAWT: "+wait_avg);
        System.out.println("\nATAT: "+tat_avg);
         }
}
Enter the number of processes:5

Enter Burst time:

Process[1]: 2

Process[2]: 3

Process[3]: 4

Process[4]: 5

Process[5]: 6

Enter arrival time:

Process[1]: 1

Process[2]: 2

Process[3]: 3

Process[4]: 4

Process[5]: 5
process1
process2
process3
process4
process5

Pro_number       Burst Time     completion_time Waiting Time    Turnaround Time

1                2              0               0                2

2                3              2               2                5

3                4              5               5                9

4                5              9               9                14

5                6              14              14               20


AWT: 6.0

ATAT: 10.0
