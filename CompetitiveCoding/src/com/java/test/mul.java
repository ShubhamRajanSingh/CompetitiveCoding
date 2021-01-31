package com.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class mul {
	public static void main(String args[]) {
		String letters[] ={"an","better","and","Sky","my","lauagj"};
		List<String> list=new ArrayList<String>();
        Map<Integer,List<String>> map=new HashMap<Integer,List<String>>();
        
        int count= 2;
        while(count<7) {
		for (int i = 0; i < 6; i++) {
			   if(letters[i].length()==count) {
				   list.add(letters[i]);
//				   System.out.println(i);
			   }
			}
		map.put(count, list);
		count++;
		list.clear();
        }
        System.out.println(map);
	}

}
