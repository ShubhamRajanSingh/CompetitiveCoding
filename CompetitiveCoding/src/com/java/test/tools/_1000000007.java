package com.java.test.tools;

public class _1000000007 {

	public static void main(String[] args) {
		
		long mod=1000000007;
		long ans=1;
		//add and multiply
		for(int i=1;i<10000;i++) {
			
			ans=((ans%mod)*(i%mod))%mod;
		}

		
		//Subtract
		ans=((100000000-1000000000)%mod +mod)%mod;
		
		
		
		
		
	}
	//Division
	//Euler's Theorem
//	long divide(int a,int b) {
//		
//		return a*Math.pow(b,p-2)%p; p is prime mod like 1000000007
//	}

}
