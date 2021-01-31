package com.java.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GroomSelecting {

	public static void main(String[] args) {

    Queue<Character> BQ = new LinkedList<Character>();
    Queue<Character> GQ = new LinkedList<Character>();
    Scanner sc=new Scanner(System.in);
    int n=0;
    n=sc.nextInt();
    String gs=sc.next();
    String bs=sc.next();
    char G[]=gs.toCharArray();
    char B[]=bs.toCharArray();
    for(char g:G) {
    	GQ.add(g);
    }
    for(char b:B) {
    	BQ.add(b);
    }
    char x;
    int z=n;
    while(!BQ.isEmpty()) {
    	if(BQ.peek()==GQ.peek()) {
    		BQ.remove();
    		GQ.remove();
    		n--;
    		z=n;
    	}
    	else {
    		x=GQ.remove();
    		GQ.add(x);
    		z--;
    		
    	}
    	if(z==0) {
    		break;
    	}
    }
    System.out.println(n);
    
	}

}
