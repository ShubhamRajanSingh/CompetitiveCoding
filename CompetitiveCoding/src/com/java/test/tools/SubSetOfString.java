package com.java.test.tools;

public class SubSetOfString {

	public static void main(String[] args) {
		String subString="trygub",mainString="trybhbfvgijunknb";
		boolean b=isSubSequence(subString,mainString,subString.length(),mainString.length());
		System.out.println(b);


	}
	  static boolean isSubSequence(String str1, String str2, int m, int n) 
	  { 
	 
	      if (m == 0)  
	          return true; 
	      if (n == 0)  
	          return false; 
	            
	      
	      if (str1.charAt(m-1) == str2.charAt(n-1)) 
	          return isSubSequence(str1, str2, m-1, n-1); 

	     
	      return isSubSequence(str1, str2, m, n-1); 
	  } 
}
