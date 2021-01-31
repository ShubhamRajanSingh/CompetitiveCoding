package com.java.test;

import java.util.Scanner;

public class CoinDistribution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=0,x,y,five=0,one=0,two=0;
		n=sc.nextInt();
		if(n%5==0)
		{
			one=1;
			two=2;
			five=(n/5)-1;
			System.out.println((five+3)+" "+five+" "+two+" "+one);
		}
		else {
			x=((n/5)-1)*5;
			y=n-x;
			five=x/5;
			if(y%2==0) {
				two=((y/2)-1);
				one=2;
			}
			else {
				two=y/2;
				one=1;
			}
			System.out.println((five+two+one)+" "+five+" "+two+" "+one);
		}
		
		
		

	}

}
//Solution by them
/*
import java.util.Scanner;
class Main{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int five,two,one;
		int n = in.nextInt();
		five=(n-4)/5;
		n=n-(five*5);
		if(n%2==0)
			one=2;
		else
			one=1;
		two= (n-one)/2;
		System.out.print(five+two+one + " "+five+" "+two+" "+one);
	}
}
*/
