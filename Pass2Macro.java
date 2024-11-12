Program: Pass 2 macro 
import java.io.*;
import java.util.*;
class Macropass2 {
    public static void main(String args[]) {
        pass2();
        System.out.println("Argument List Array(ALA) for pass 2");
        display(Pass1.ala,Pass1.alac,2);
        System.out.println("All tables displayed here whereas the expanded output is stored in the file pass2_output.txt");
    }
    static void pass2() {
        int alap=0,index,mdtp,flag=0,i,j;
        String s,temp;
        try{
            BufferedReader inp=new BufferedReader(new FileReader(new FileReader("pass1_output.txt")));
            File op=new File("pass2_output.txt");
            if(!op.exists()) {
                op.createNewFile();
            }
            BufferedWriter output=new BufferedWriter (new FileWriter(op.getAbsoluteFile()));
            for(;(s=inp.readLine())!=null;flag=0) {
                StringTokenizer st=new StringTokenizer(s);
                String str[]=new String(st.countTokens());
                for(i=0;i<str.length;i++) {
                    str[i]=st.nextToken();
                    for(j=0;j<Pass1.mntc;j++) {
                        if(str[0].equals(Pass1.mnt[j][1])) {
                            mdtp=Integer.parseInt(Pass1.mnt[j][2]);
                            st=new StringTokenizer(str[1],",");
                            String arg[]=new String[st.countTokens()];
                            for(i=0;i<arg.length;i++) {
                                arg[i]=st.nextToken();
                                Pass1.ala[alap++][1]=arg[i];
                            }
                            for(i=mdtp;!(Pass1.mdt[i][0].equalsIgnoreCase("MEND"));i++) {
                                index=Pass1.mdt[i][0].indexOf("#");
                                temp=Pass1.mdt[i][0].substring(0,index);
                                temp+=Pass1.ala[Integer.parseInt(""+Pass1.mdt[i][0].charAt(index+1))][1];
                                output.write(temp);
                                output.newLine();
                            }
                            flag=1;
                        }
                    }
                    if (flag==0) {
                        output.write(s);
                        output.newLine();
                        output.close();
                    }
                }
            }
                    catch(FileNotFoundException ex) {
                        System.out.println("Unable to find file");
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
        }
                static void display(String a[],int n,int m) {
                    int i,j;
                    for(i=0;i<n;i++) {
                        for(j=0;j<m;j++) {
                            System.out.println(a[i][j]+"");
                        }
                    }
                    System.out.println();
                    }
                }
}
Input:
PRG2 START 
USING *,BASE 
INCR1 DATA1,DATA2
INCR2 DATA3,DATA4
FOUR DC F’4’
FIVE DC F’5’
BASE EQU 8
TEMP DS 1F
DROP 8
END 
ST 4,DATA4
FOUR DC F’4’
FIVE DC F’5’
BASE EQU 8
TEMP DS 1F
DROP 8
END

Output:
ALA
0	DATA 1
1	DATA 2
2	DATA 3
3	DATA 4
PRG2 START
USING *,BASE 
A 1, DATA 1
L 2 , DATA 2
L 3, DATA 3
