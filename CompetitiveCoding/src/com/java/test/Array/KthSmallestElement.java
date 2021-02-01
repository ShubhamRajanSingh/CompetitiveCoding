package com.java.test.Array;


//In QuickSort, we pick a pivot element, then move the pivot element to its correct position
//and partition the array around it. The idea is, not to do complete quicksort, but stop at 
//the point where pivot itself is k’th smallest element. Also, not to recur for both left and right 
//sides of pivot, but recur for one of them according to the position of pivot. The worst case time 
//complexity of this method is O(n2), but it works in O(n) on average.
//

import java.util.Arrays;
import java.util.Collections;

class KthSmallestElement {

	public static int partition(Integer[] arr, int l, int r) {
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
			}
		}

		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;

		return i;
	}

	public static int kthSmallest(Integer[] arr, int l, int r, int k) {

		if (k > 0 && k <= r - l + 1) {

			int pos = partition(arr, l, r);

			if (pos - l == k - 1)
				return arr[pos];

			if (pos - l > k - 1)
				return kthSmallest(arr, l, pos - 1, k);

			return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 12, 3, 5, 7, 4, 19, 26 };
		int k = 3;
		System.out.print("K'th smallest element is " + kthSmallest(arr, 0, arr.length - 1, k));
	}
}
