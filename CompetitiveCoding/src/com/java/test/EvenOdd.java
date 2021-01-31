package com.java.test;

import java.util.Scanner;

import java.lang.Math; 
public class EvenOdd {
	
   

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
	    int noOdd=1,noEven=1,no1,no2,k;
	    int x,fe=0,fo=0;
	    int totalCom=0;
	    int NOODD=0;
	    int noddo=2;
	    no1=sc.nextInt();
	    no2=sc.nextInt();
	    k=sc.nextInt();
	    
	    if((no1%2!=0 &&no2%2==0)||(no1%2==0 &&no2%2!=0)) {
	    	x=(no2-no1)+1;
	    	noOdd=x/2;
	    	noEven=x/2;
	    	
	    }
	    else if(no1%2==0 &&no2%2==0) {
	    	x=(no2-no1)+1;
	    	noOdd=x/2;
	    	noEven=x/2+1;
	    }
	    else if(no1%2!=0 &&no2%2!=0) {
	    	x=(no2-no1)+1;
	    	noOdd=x/2+1;
	    	noEven=x/2;
	    }
	    
	    
	    
	    
	    if(k%2==0) {
	    	
              while(NOODD<=k) {
            	
            	  totalCom=totalCom+((int)Math.pow(noEven,(k-NOODD))*((int)Math.pow(noOdd, NOODD)));
            	  NOODD=NOODD+2;
              }
	    }
	    else {
	    	totalCom=(int)Math.pow(noEven,(k));
	    	 while(noddo<=k) {
	    		 System.out.println(noddo);
           	  totalCom=totalCom+((int)Math.pow(noEven,(k-noddo))*((int)Math.pow(noOdd, noddo)));
           	  
           	  
           	  
           	 noddo=noddo+2;
             }
	    	
	    	
	    	
	    }
	    System.out.println(totalCom);
	    
		

	}

}
