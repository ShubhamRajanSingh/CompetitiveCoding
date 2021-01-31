package com.java.test;

import java.util.Scanner;

//For a given array a consisting of n integers and a given integer m find if it is 
//possible to reorder elements of the array a in such a way that ∑ni=1∑nj=iajj equals m?
//		It is forbidden to delete elements as well as insert new elements. Please note 
//		that no rounding occurs during division, for example, 52=2.5.

//codeforces 678

public class ReOrder {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        while (t--!=0)
	        {
	            int n = sc.nextInt();
	            int s = sc.nextInt();
	            int temp = 0;
	            for(int i = 0; i < n; i++){
	                temp+=sc.nextInt();
	            }
	            if (temp==s){
	                System.out.println("YES");
	            }else{
	                System.out.println("NO");
	            }
	        }
	}

}
