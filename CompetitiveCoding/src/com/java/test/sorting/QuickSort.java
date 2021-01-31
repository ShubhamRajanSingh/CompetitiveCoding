package com.java.test.sorting;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort q=new QuickSort();
		int[] array = { 2, 1, 5, 10, 7, 6, 9, 3, 4, 8 };
		int low = 0, high = array.length - 1;
		array=q.quickSort(array,low,high);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);

	}

	public int[] quickSort(int[] array, int low, int high) {
        int i=-1,j=0,pivot=high,temp;
        
        if(low==high) {
        	int[] unaryArray= {array[low]};
        	return unaryArray;       	
        }
		if(low<high) {
			while(j<pivot) {
				if(array[j]<array[pivot]) {
					i++;
					temp=array[j];
					array[j]=array[i];
					array[i]=temp;
					
				}
				j++;
			}
			temp=array[pivot];
			array[pivot]=array[i+1];
			array[i+1]=temp;
			quickSort(array,low,i);
			quickSort(array,i+2,high);
			return array;
		
		}
		
		return null;
	}

}
