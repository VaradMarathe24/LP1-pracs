Program: LRU 
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of frames:");
        int nof=sc.nextInt();
        System.out.println("Enter the number of pages:");
        int nop=sc.nextInt();
        System.out.println("Enter the page referenced string:");
        int[] prs=new int[nop];
        for (int i=0;i<nop;i++) {
            prs[i]=sc.nextInt();
        }
        LinkedList<Integer> frames=new LinkedList<>();
        int pagefaults=0;
        for (int page : prs) {
            if(!frames.contains(page)) {
                if(frames.size()>=nof) {
                    frames.removeFirst();
                }
                frames.addLast(page);
                pagefaults++;
            }
            else {
                frames.remove(frames.indexOf(page));
                frames.addLast(page);
            }
            System.out.println("Frames:");
            for(int frame:frames){
                System.out.println(frame+"");
            }
            System.out.println();
        }
        System.out.println("Total Page Faults:"+pagefaults);
        sc.close();
    }
}
Output:
Enter the number of frames:
5
Enter the number of pages:
15
Enter the page referenced string:
7 0 1 2 3 1 0 3 0 4 2 3 0 3 1
Frames:
7

Frames:
7
0

Frames:
7
0
1

Frames:
7
0
1
2

Frames:
7
0
1
2
3

Frames:
7
0
2
3
1

Frames:
7
2
3
1
0

Frames:
7
2
1
0
3

Frames:
7
2
1
3
0

Frames:
2
1
3
0
4

Frames:
1
3
0
4
2

Frames:
1
0
4
2
3

Frames:
1
4
2
3
0

Frames:
1
4
2
0
3

Frames:
4
2
0
3
1

Total Page Faults:6
