package com.java.test;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
public class ListImpl {

	public static void main(String args[])
	{
		List list = new LinkedList();
		//add elements to the list.
		list.add("Java");
		list.add(".Net");
		list.add("C");
		list.add("C++");
		
		//iterate over the element
		ListIterator litr = list.listIterator();
		System.out.println("Elements In List In Forward Order:");
		while(litr.hasNext())
		{
			//iterate in forward direction
			System.out.print(litr.next()+",");
		}
		System.out.println("\nElements In List In Backward Order");
		while(litr.hasPrevious())
		{
			System.out.print(litr.previous()+",");
		}
		//insert new element at the specified index
		list.add(3, "Fortran");
		ListIterator litr1 = list.listIterator();
		System.out.println("\nElements In List After adding new element at specified index:");
		while(litr1.hasNext())
		{
			//iterate in forward direction
			System.out.print(litr1.next()+",");
		}
		//replace element at the specified index
		list.set(3, "Pascal");
		
		ListIterator litr2 = list.listIterator();
		System.out.println("\nElements In List After replacing new element at specified index:");
		while(litr2.hasNext())
		{
			//iterate in forward direction
			System.out.print(litr2.next()+",");
		}		
		//check for the availability of elements
		boolean bol = list.contains("Pascal");
		System.out.println("\nWhether The Element 'Pascal' Is Available In List : "+bol);
	}
}