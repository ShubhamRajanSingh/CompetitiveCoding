package com.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberOfDigitsFrom1ToN {
	public static void main(String args[])  {
	 
	  FastScanner fs=new FastScanner();
      
	  
	  int t=fs.nextInt();
	  BigInteger n;
	  int len;
	  BigInteger numd,ten=BigInteger.valueOf(10),count=BigInteger.valueOf(0);

	  while(t-->0) {
		  count=BigInteger.valueOf(0);
		  n=fs.nextBigInteger();
		  if(n.compareTo(BigInteger.valueOf(9))==1) {
		  while(n.compareTo(BigInteger.valueOf(9))!=0) {
			  len=n.toString().length();
			  numd=n.subtract(((BigInteger.valueOf(10)).pow(len-1))).add(BigInteger.valueOf(1));
			  count=count.add(numd.multiply(BigInteger.valueOf(len)));
			  n=n.subtract(numd);
		  }
		  System.out.println(count.add(BigInteger.valueOf(9)));
		  }else {
			  System.out.println(n);
		  }
		  
		  
		  
	  }
	  
	  
	 
  }
	
	

	public static class FastScanner {
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

		int nextInt() {
			return Integer.parseInt(next());
		}

		BigInteger nextBigInteger() {
			return new BigInteger(next());
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}