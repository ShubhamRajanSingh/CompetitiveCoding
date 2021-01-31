package com.java.test;

import java.math.BigInteger;
import java.util.Scanner;

public class StrangeDream {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
	    BigInteger n=sc.nextBigInteger(),m=sc.nextBigInteger(),x=sc.nextBigInteger(),y=sc.nextBigInteger();
	    BigInteger	i=BigInteger.valueOf(0),hop=BigInteger.valueOf(1);

	    while(true) {
	    	
	    	i=i.add(BigInteger.valueOf(1));
	    
	    	if(i.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0))==0) {
	    		x=x.subtract(i);
	    		if(x.compareTo(BigInteger.valueOf(1))==-1) {
	    			hop=hop.add(i).subtract(BigInteger.valueOf(1));
	    			break;
	    		}else {
	    			hop=hop.add(i);
	    		}
	    		y=y.add(i);
	    		if(y.compareTo(m)==1) {
	    			hop=hop.add(i).subtract(BigInteger.valueOf(1));
	    			break;
	    		}else {
	    			hop=hop.add(i);
	    		}
	    	}else {
	    		x=x.add(i);
	    		if(x.compareTo(n)==1) {
	    			hop=hop.add(i).subtract(BigInteger.valueOf(1));
	    			break;
	    		}else {
	    			hop=hop.add(i);
	    		}
	    		y=y.subtract(i);
	    		if(y.compareTo(BigInteger.valueOf(1))==-1) {
	    			hop=hop.add(i).subtract(BigInteger.valueOf(1));
	    			break;
	    		}else {
	    			hop=hop.add(i);
	    		}
	    		
	    	}
	    	
	    }
	    
		
	    System.out.println(hop);
		
	}

}
