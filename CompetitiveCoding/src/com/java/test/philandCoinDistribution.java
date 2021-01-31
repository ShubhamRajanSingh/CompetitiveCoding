package com.java.test;

import java.lang.reflect.Array;
import java.util.Scanner;

public class philandCoinDistribution {
	public static void main(String[] args) {
		System.out.println("Enter number of ways :");
		Scanner sc= new Scanner(System.in);
		int no_of_ways = sc.nextInt();
		int [] allinone = new int[no_of_ways];
		for(int i=0;i<no_of_ways;i++){
		    allinone[i] = sc.nextInt();
		    }
		for(int j=0;j<no_of_ways;j++){
		    int count = 0;
		    int values = (int)Array.get(allinone, j);
		    while(values>=1){
		        values = values / 2;
		        count+=1;
		    }
		    System.out.println(count);
		}
	
	}
}
