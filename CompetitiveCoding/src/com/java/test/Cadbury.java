package com.java.test;

import java.util.Scanner;

public class Cadbury {

	public static void main(String[] args) {
		int minLength = 0, minBreadth = 0, maxLength = 0, maxBreadth = 0,x,y,count=0;
		Scanner sc = new Scanner(System.in);
		minLength = sc.nextInt();
		maxLength = sc.nextInt();
		minBreadth = sc.nextInt();
		maxBreadth = sc.nextInt();
		
		for (int i = minLength; i <= maxLength; i++) {
			for (int j = minBreadth; j <= maxBreadth; j++) {
                x=i;
                y=j;
                while(x>0 &&y>0) {
                if(x>y) {
                	count++;
                	x=x-y; 	
                }
                if(y>x) {
                	count++;
                	y=y-x;
                	}
                if(x==y) {
                	count++	;
                	x=0;
                	y=0;
                }
                if(x==1 || y==1) {
                	if(x>1) {
                		count=count+x;
                		x=0;
                		y=0;
                	}
                	if(y>1) {
                		
                		count=count+y;
                		x=0;
                		y=0;
                	}
                }
              
			}
			}
		}		
		System.out.println(count);
	
	}//end of main

}//end of class
