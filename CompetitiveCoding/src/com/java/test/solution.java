package com.java.test;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		BigInteger n;
		while(t>0) {
			n=sc.nextBigInteger();
			System.out.println(n.toString().length());
			
			t--;
		}
		sc.close();
}
}
