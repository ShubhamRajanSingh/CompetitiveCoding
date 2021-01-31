package com.java.test;

import java.util.*;

//Problem
//A square of size n×n is called prime if the following three conditions are held simultaneously:
//
//all numbers on the square are non-negative integers not exceeding 105;
//there are no prime numbers in the square;
//sums of integers in each row and each column are prime numbers.                              
public class PrimeSquare{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int a =4;
			while(true){
				if(prime(a)==false && prime(a*(n-1)+1)){
					break;
				}
				a++;
			}
			int p = n-1;
			int i1 =1;
			while(true){
				if(prime(i1)==false && prime(p+i1)){
					break;
				}
				i1++;
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if((i==n-1 || j==n-1) && !(i==n-1 && j==n-1)){
						sb.append(1+" ");
					}
					else if(i==n-1 && j==n-1){
						sb.append(i1+" ");
					}
					else{
					  sb.append(a+" ");	
					}
					
				}
				sb.append("\n");
			}
			System.out.println(sb);
 
		}
	    sc.close();
	}
	static boolean prime(int n)
    {
 
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;
 
        // Check if number is 2
        else if (n == 2)
            return true;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) 
        {
            if (n % i == 0)
                return false;
        }
        return true;
    
    }
 
}