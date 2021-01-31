package com.java.test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class solution2 {

	public static void main(String[] args) {
		
		
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		BigInteger sum=null;
		int array[]=new int[n];
		for(int i=0;i<n;i++) {
			
			array[i]=sc.nextInt();
		}
		
		Arrays.sort(array);
	
		int j=0;
		while(j<n) {
			sum=BigInteger.valueOf(array[j+1]);
			j=j+4;
			
		}
		System.out.println(sum);
		System.out.println(sum.mod(BigInteger.valueOf(1000000007)));

	}

}
