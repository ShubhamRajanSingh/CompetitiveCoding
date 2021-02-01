package com.java.test.Array;

class EquilibriumPoint {

	int equilibrium(int arr[], int n) {
		int sum = 0;
		int leftsum = 0;

		for (int i = 0; i < n; ++i)
			sum += arr[i];

		for (int i = 0; i < n; ++i) {
			sum -= arr[i];

			if (leftsum == sum)
				return i;

			leftsum += arr[i];
		}

		return -1;
	}

	public static void main(String[] args) {
		EquilibriumPoint equi = new EquilibriumPoint();
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		int arr_size = arr.length;
		System.out.println("First equilibrium index is " + equi.equilibrium(arr, arr_size));
	}
}
