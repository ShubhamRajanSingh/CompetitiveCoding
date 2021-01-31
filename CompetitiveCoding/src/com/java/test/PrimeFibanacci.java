package com.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFibanacci {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x, y,count=0,j=0;
		x=sc.nextInt();
		y=sc.nextInt();
		for ( int i = x; i <= y; i++)         
	       { 		  	  
	          int counter=0; 	  
	          for( int num =i; num>=1; num--)
		  {
	             if(i%num==0)
		     {
	 		counter = counter + 1;
		     }
		  }
		  if (counter ==2)
		  {
		     //Appended the Prime number to the String
		    count++;
		  }	
	       }	
		int primeArray1[]=new int[count];
		for ( int i = x; i <= y; i++)         
	       { 		  	  
	          int counter=0; 	  
	          for( int num =i; num>=1; num--)
		  {
	             if(i%num==0)
		     {
	 		counter = counter + 1;
		     }
		  }
		  if (counter ==2)
		  {  
			  primeArray1[j]=i;
			  j++;
		  }	
	       }	
	
		List<Long> list1=new ArrayList<Long>();
		String s,z,m;
		for(int k=0;k<count;k++) {
			for(int i=0;i<count;i++) {
				if(k!=i) {
					s=primeArray1[k]+"";
					z=primeArray1[i]+"";
					m=s.concat(z);
					list1.add(Long.parseLong(m));
				}
			}
		}

			
		List<Long> list2=new ArrayList<Long>();
		
		for ( int i = 0; i <list1.size(); i++){ 		  	  
	          int counter=0; 	  
	          for( long num =list1.get(list1.size()-1); num>=1; num--)
		  {
	             if(list1.get(i)%num==0)
		     {
	 		counter = counter + 1;
		     }
		  }
		  if (counter ==2)
		  {  
			 list2.add(list1.get(i));
			  
		  }	
	    }
		
		long small,large;
		small=list2.get(0);
		large=list2.get(0);
		
		for(int i=0;i<list2.size();i++) {
			if(small>list2.get(i)) {
				small=list2.get(i);
			}
			if(large<list2.get(i)) {
				large=list2.get(i);
			}
		} 
	    long list3[]=new long[list2.size()];
	   list3[0]=small;
	    list3[1]=large;
	    long diff;
	     for(int i=2;i<list2.size();i++) {
	    	 diff=list3[i-1]+list3[i-2];
	    	 list3[i]=diff;
	     }
	  
	
	     System.out.println(list3[list3.length-1]);

	}

}
