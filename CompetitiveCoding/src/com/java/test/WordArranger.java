package com.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordArranger {
 int letters;
 Scanner sc=new Scanner(System.in);
 List<String> list=new ArrayList<String>();
 Map<Integer,List<String>> map=new HashMap<Integer,List<String>>();
	
 public void WordArranger(CrossNode<Integer> head,int n) {
	 System.out.println("Enter the number of words");
	 letters=sc.nextInt();
	 String words[]=new String[letters];
	 for(int i=0;i<letters;i++) {
		 words[i]=sc.next();	 
	 }
	 
 }
}
