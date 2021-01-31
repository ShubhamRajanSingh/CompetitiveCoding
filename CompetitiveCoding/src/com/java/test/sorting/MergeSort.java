package com.java.test.sorting;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int array[] = { 10,3,4,2,5,9,7,6,8,1};
		int low = 0, high = array.length - 1;
		array = m.mergeSort(array, low, high);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);

	}

	public int[] mergeSort(int array[], int low, int high) {
		int[] left, right, sorted = null;

		if (low == high) {
			int[] unaryArray = { array[low] };
			return unaryArray;
		} else if (low < high) {
			sorted = new int[high - low + 1];
			int mid = (int) Math.floor((low + high) / 2);
			left = mergeSort(array, low, mid);
			right = mergeSort(array, mid + 1, high);
			int leftLength = left.length, rightLenght = right.length;
			int k = 0, j = 0, m = 0;

			while (k < leftLength && j < rightLenght) {
				if (left[k] <= right[j]) {
					sorted[m] = left[k];
					k++;
					m++;

				} else {
					sorted[m] = right[j];
					j++;
					m++;
				}

			}

			if (k < leftLength) {
				while (k < leftLength) {
					sorted[m] = left[k];
					k++;
					m++;

				}

			}
			if (j < rightLenght) {
				while (j < rightLenght) {
					sorted[m] = right[j];
					j++;
					m++;

				}

			}

			return sorted;
		}

		return null;
	}

}
