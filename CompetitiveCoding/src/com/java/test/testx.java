package com.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class testx {

	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		testx obj=new testx();
		int n = fs.nextInt();
		int[] houseArray = new int[n];
		for (int i = 0; i < n; i++) {
			houseArray[i] = fs.nextInt();
		}
		
		System.out.println(obj.maxLottery(houseArray,0));
		

	}
	
	public int maxLottery(int houseArray[],int i) {
		
		if(i>=houseArray.length) {
			return 0;
		}
		
		int sum1=houseArray[i]+maxLottery(houseArray,i+2);
		int sum2=maxLottery(houseArray,i+1);

		return Math.max(sum1, sum2);
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
