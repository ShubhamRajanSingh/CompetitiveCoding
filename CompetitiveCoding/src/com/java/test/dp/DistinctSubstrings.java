package com.java.test.dp;

import java.io.*;
import java.util.ArrayList;


//Given a string str, the task is to find the number of distinct substrings 
//that are placed consecutively in the given string.


class DistinctSubstrings {

	static int distinctSimilarSubstrings(String str) {

		int n = str.length();

		if (n <= 1)
			return 0;

		long dp[][] = new long[n + 1][n + 1];

		ArrayList<String> list = new ArrayList<String>();

		for (int j = n - 1; j >= 0; j--) {

			for (int i = j - 1; i >= 0; i--) {

				if (str.charAt(i) == str.charAt(j)) {

					dp[i][j] = dp[i + 1][j + 1] + 1;
				}

				else {
					dp[i][j] = 0;
				}

				if (dp[i][j] >= j - i) {
					list.add(str.substring(j - i, i));
				}
			}
		}

		return list.size();
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";

		System.out.println(distinctSimilarSubstrings(str));
	}
}
