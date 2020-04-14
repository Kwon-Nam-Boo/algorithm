package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test4 {
	 
   public static long mod = 998244353;
	
   public static void main(String[] args) throws IOException{
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
	   int TC = Integer.parseInt(br.readLine());
       
       for(int t=1;t<=TC;t++) {
           int n = Integer.parseInt(br.readLine());
           Node[] arr = new Node[n+1];
           for(int i=2;i<=n;i++) {
        	   st = new StringTokenizer(br.readLine());
               int tx = Integer.parseInt(st.nextToken());
               int ax = Integer.parseInt(st.nextToken());
               int bx = Integer.parseInt(st.nextToken());
               Node nNode = new Node(tx,ax,bx);
               arr[i]=nNode;
           }
           
           int m = Integer.parseInt(br.readLine());
           long[] ans = new long[m+1];
           st = new StringTokenizer(br.readLine());
           for(int i=0;i<m;i++) {
               int x = Integer.parseInt(st.nextToken());
               long[] num = new long[n+1];
               num[0]=1; num[1]=x;
               
               for(int j=2;j<=n;j++) {
                   if(arr[j].tx==1) num[j] = num[arr[j].ax]+num[arr[j].bx];
                   else if(arr[j].tx==2) num[j]=arr[j].ax*num[arr[j].bx];
                   else num[j]=num[arr[j].ax]*num[arr[j].bx];
                   num[j]%=mod;
               }
               ans[i]=num[n];
           }
           System.out.print("#"+t+" ");
           for(int j=0;j<m;j++) System.out.print(ans[j]+" ");
           System.out.println();
       }
   	}
   	static class Node {
       int tx,ax,bx;
       Node(int tx,int ax,int bx){
           this.tx= tx;
           this.ax= ax;
           this.bx= bx;
       }

   	}
}
