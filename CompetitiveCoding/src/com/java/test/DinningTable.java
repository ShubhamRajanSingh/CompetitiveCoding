package com.java.test;

import java.util.Scanner;

public class DinningTable {

	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int R,N,NumberOfSeq=1;
	    int T,D;
	 
	    R=sc.nextInt();
	    N=sc.nextInt();
	    
	    if(R!=0) {
	    T=N%R;
	    D=(N-T)/R;
	    
	    for(int i=1;i<=R;i++) {
	    	
	    	
	    	System.out.println(NumberOfSeq+" "+D+" "+T+" "+ N);
	    	if(T!=0){
	    		D++;
	    		T--;
	    	}
	    	
	    	NumberOfSeq=NumberOfSeq*(factorial(N))/(factorial(D)*factorial(N-D));
	    	N=N-D;
	    	
	    	if(T!=0) {
	    	D--;
	    	}
	    	
	    	
	    }
	    }
	    else {
	    	NumberOfSeq=0;
	    }
	    
	    System.out.println(NumberOfSeq);
	    	
	    	
	 

	}
	
	 static int factorial(int n){    
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n * factorial(n-1));    
		 }    

}

//class DinningTable
//{
//	
//public static void main(String[] args)
//{
//Scanner sc = new Scanner(System.in);
//int t = sc.nextInt();
//int p = sc.nextInt();
//int[] arrange = new int[t];
//int q = p/t;
//int r = p%t; for(int i=0;i<r;i++)
//{
//arrange[i]++;
//}
//for(int i=0;i<t;i++)
//{
//arrange[i] = arrange[i]+q; } long comb = 1;int temp = p;
//for(int i=0;i<t;i++)
//{ comb = comb * ncr(temp,arrange[i]); temp = temp-arrange[i];
//}
//System.out.println(comb);
//}
//public static long ncr(int n,int r)
//{
//if(n==r || r==0)
//return 1;
//else if(r==1)
//return n;
//else
//{
//long res = fact(n)/fact(r);
//res = res / fact(n-r);
//return res;
//}
//}
//public static long fact(int f)
//{
//long[] fact = new long[]{1l,1l,2l,6l,24l,120l,720l,5040l,40320l,362880l,3628800l,
//39916800l,479001600l,6227020800l,87178291200l,
//1307674368000l,20922789888000l,355687428096000l,
//6402373705728000l,121645100408832000l,2432902008176640000l}; return fact[f];
//}
//}