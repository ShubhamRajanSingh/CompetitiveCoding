package com.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UnlockMatrix {

	public static void main(String[] args) {

		FastScanner fs = new FastScanner();
		int m, n;

		m = fs.nextInt();
		n = fs.nextInt();
		int l = m / 2;
		int array[][] = new int[m][n];
		double rotarray[] = new double[l];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				array[i][j] = fs.nextInt();
			}

		}
		for (int i = 0; i < l; i++) {
			rotarray[i] = fs.nextDouble();
		}

		for (int i = 0; i < l; i++) {
			double rot = rotarray[i];
			int finalm = m - (i * 2), finaln = n - (i * 2);
			int numberOfCells = ((2 * finalm)) + 2 * ((finaln - 2));
			int layerRotation = (int) (rot % numberOfCells);
			int temp[] = new int[numberOfCells];
			int n1 = 0;
			int k=0;
			int j=1;
	        while( k<finalm) {
	        	n1++;
	        	k++;
	        }
            while( j<finaln) {
	        	n1++;
	        	j++;
	        }
            k--;
            while( k>=0) {
	        	k--;
	        	n1++;
	        }
            j--;
            while(j>0) {
            	n1++;
            	j--;
            	
            }
          System.out.println(n1);
		

			if ((i + 1) % 2 != 0) {

			} else {
				// clockwise

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
