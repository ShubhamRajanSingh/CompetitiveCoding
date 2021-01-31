package com.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// find the minimum number whose sum of the digit is equal to the given number
/* ------------ Theorems and Lemmas ------------ */

//Fermat's Little Theorem
//(1) ((a ** p) - a) % p = 0; if 'p' is prime
//(2) Further, if 'a % p != 0', then ((a ** (p - 1)) - 1) % p = 0

/* -------------- End of theorems -------------- */

public class MinimumSumNumber {

	public static void main(String[] args) {
		
		
		FastScanner reader = new FastScanner();
		int t = reader.nextInt();
		while (t-- > 0) {
			int x = reader.nextInt();
			if (x > 45)
				System.out.println(-1);
			else {
				StringBuilder sb = new StringBuilder("");
				int num = 9;
				while (x > 0) {
					sb.append(Math.min(num, x));
					x -= Math.min(num--, x);
				}
				System.out.println(sb.reverse());
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
