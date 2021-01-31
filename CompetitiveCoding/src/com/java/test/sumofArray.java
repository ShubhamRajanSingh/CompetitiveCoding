package com.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sumofArray {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		int n,k;
		while(t-->0) {
			n=fs.nextInt();
			k=fs.nextInt();
			int flag=0;
			
			for(int i=1;i<=k;i++) {
				for(int j=(int) n;j>=0;j--) {
					if(i==1) {
						int sum=n*i;
						if((sum%k==0) && sum>=k ) {
							flag=1;
							
						}
						break;
						
					}
					if(i>1) {
					int sum=((j*i)+((n-j)*(i-1)));
					if((sum%k==0) && sum>=k ) {
						flag=1;
						break;
					}
					}
					
				}
				if(flag==1) {
					System.out.println(i);
					break;
				}
				
			}
			
			
		}
		
		

	}
	
	 static class FastScanner {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer("");
	 
	        String next() {
	            while (!st.hasMoreTokens())
	                try {
	                    st = new StringTokenizer(br.readLine());
	                } catch (IOException e) {
	                }
	            return st.nextToken();
	        }
	        BigInteger nextBigInteger() {
	            return new BigInteger(next());
	        }
	 
	        int nextInt() {
	            return Integer.parseInt(next());
	        }
	 
	        int[] readArray(int n) {
	            int[] arr = new int[n];
	            for (int i = 0; i < n; i++) {
	                arr[i] = nextInt();
	            }
	            return arr;
	        }
	 
	        List<Integer> readList(int n) {
	            List<Integer> list = new ArrayList<>();
	            for (int i = 0; i < n; i++) {
	                list.add(nextInt());
	            }
	            return list;
	        }
	 
	        long nextLong() {
	            return Long.parseLong(next());
	        }
	        String nextLine() 
	        { 
	            String str = ""; 
	            try
	            { 
	                str = br.readLine(); 
	            } 
	            catch (IOException e) 
	            { 
	                e.printStackTrace(); 
	            } 
	            return str; 
	        } 
	        double nextDouble() 
	        { 
	            return Double.parseDouble(next()); 
	        } 
	    }

}
