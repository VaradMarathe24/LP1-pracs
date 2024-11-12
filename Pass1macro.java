
Program Pass 1 Macro 
import java.util.*;
import java.io.*;
class Pass1 {
    static string mnt[]=new string[5][3];
    static string ala[]=new string[10][2];
    static string mdt[]=new string[20][1];
    static int mntc=0,mdtc=0,alac=0;
    public static void main(String args[]){
        pass1();
        System.out.println("Macro Name Table(MNT)");
        display(mnt,mntc,3);
        System.out.println("ALA for pass1");
        display(ala,alac,2);
        System.out.println("Macro Definition Table(MDT)");
        display(mdt,mdtc,1);
    }
    static void pass1(){
        int index=0,i;
        String s,prev=”'',substring;
        try {
            BufferedReader inp=new BufferedReader(new FileReader('input.txt'));
            while((s=inp.readLine())!=NULL) {
                if (s.equalsIgnoreCase("MACRO")) {
                    prev=s;
                    for(;!(s=inp.readLine()).equalsIgnoreCase("MEND");mdtc++,prev=s){
                        if (prev.equalsIgnoreCase("MACRO")){
                            StringTokenizer st= new StringTokenizer(s);
                            String str[]=new String(st.countTokens());
                            for(i=0;i<str.length;i++) {
                                str[i]=st.nextToken();
                            }
                            mnt[mntc][0]=(mntc+1)+"";
                            mnt[mntc][1]=str[0];
                            mnt[mntc++][2]=(++mdtc)+"";
                            st=new StringTokenizer(str[1,","]);
                            String string[]=new String[st.countTokens()];
                            for (i=0;i<string.length;i++) {
                                string[i]=st.nextToken();
                                ala[alac][0]=alac+"";
                                index=string[i].indexOf("=");
                                if (index!=-1) {
                                    ala[alac++][1]=string[i].substring(0,index);
                                }
                                else{
                                    ala[alac++][1]=string[i];
                                }
                                }
                            }
                            else{
                                index=s.indexOf("&");
                                substring=s.substring(index);
                                for(i=0;i<alac;i++) {
                                    if(ala[i][1].equals(substring)) {
                                        s=s.replaceAll(substring,"#"+ala[i[0]]);
                                        
                                    }
                                }
                            }
                            mdt[mdtc-1][0]=s;
                        }
                        mdt[mdtc-1][0]=s;
                    }
                }
            }
            catch(FileNotFoundException ex) {
                System.out.println("Unable to find file");
            } catch(IOException e) {
                e.printStackTrace();
            }
            
        }
        static void display(String a[][],int n,int m) {
            int i,j;
            for(i=0;i<n;i++) {
                for (j=0;j<m;j++) {
                    System.out.println(a[i][j]+"");
            }
            System.out.println();
        }
    }
}
INPUT from  Input.txt
MACRO
ADDITION &arg1,&arg2,&arg3
MOV ax,&arg1
ADD ax,&arg2
ADD ax,&arg3
MEND
ADDITION 34,45,44
END

Output:
Macro Name Table  
1 ADDITION 1
ALA for Pass 1
0 &arg1
1 &arg2
2 &arg3
MDT
ADDITION &arg1,&arg2,&arg3
MOV ax,#0
ADD ax,#1
ADD ax,#2
MEND
