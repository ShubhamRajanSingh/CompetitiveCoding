package com.java.test;

import java.util.Scanner;
import java.lang.Math;

public class CollisionCourse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		n=sc.nextInt();
		double Distance[]=new double[n];
		double x,y,z,dis,temp,finall;
		for(int i=0;i<n;i++) {
			x=sc.nextInt();
			y=sc.nextInt();
			z=sc.nextInt();
			temp=Math.pow(x, 2)+Math.pow(y, 2);
			dis=Math.pow(temp,0.5);
			finall=dis/z;
			Distance[i]=finall;	
		}
		int collide=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
				if(i!=j && Distance[i]==Distance[j]) {
					collide++;
				}
			}
			
		}
		System.out.println(collide/2);
	}

}
