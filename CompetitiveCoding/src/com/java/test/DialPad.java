package com.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class DialPad {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		String s=fs.nextLine();
		HashMap<String,String> equiNumber=new HashMap<String,String>();
		equiNumber.put("a","2");
		equiNumber.put("b","2");
		equiNumber.put("c","2");
		equiNumber.put("d","3");
		equiNumber.put("e","3");
		equiNumber.put("f","3");
		equiNumber.put("g","4");
		equiNumber.put("h","4");
		equiNumber.put("i","4");
		equiNumber.put("j","5");
		equiNumber.put("k","5");
		equiNumber.put("l","5");
		equiNumber.put("m","6");
		equiNumber.put("n","6");
		equiNumber.put("o","6");
		equiNumber.put("p","7");
		equiNumber.put("q","7");
		equiNumber.put("r","7");
		equiNumber.put("s","7");
		equiNumber.put("t","8");
		equiNumber.put("u","8");
		equiNumber.put("v","8");
		equiNumber.put("w","9");
		equiNumber.put("x","9");
		equiNumber.put("y","9");
		equiNumber.put("z","9");
		String currentName = "";
		String currentNumber = "";
		int index=0;
		
		ArrayList<String> subString=new ArrayList<String>();
		ArrayList<String> largestSubString=new ArrayList<String>();
		ArrayList<String> numberString=new ArrayList<String>();
		while((s.charAt(index))!=(" ").charAt(0)) {
			currentName=currentName+s.charAt(index);
			index++;
		}
		index++;
		currentName=currentName.toLowerCase();
		subString.add(currentName);
	
		for(int i=0;i<currentName.length();i++) {
			currentNumber=currentNumber+equiNumber.get(currentName.charAt(i)+"");
		}
		numberString.add(currentNumber);
		
		
		while(index<=s.length()-1) {
			currentName="";
			currentNumber="";
			while( index<s.length() && ((s.charAt(index))!=(" ").charAt(0)) ) {
				currentName=currentName+s.charAt(index);
				index++;
			}
			index++;
			currentName=currentName.toLowerCase();
			subString.add(currentName);
			
			for(int i=0;i<currentName.length();i++) {
				currentNumber=currentNumber+equiNumber.get(currentName.charAt(i)+"");
			}
			numberString.add(currentNumber);
			for(int i=numberString.get(numberString.size()-2).length();i>=0;i-- ) {
				int initialIndex=0;
				int finalIndex=i;
				while(initialIndex+finalIndex<=numberString.get(numberString.size()-2).length()) {
					if(isSubstring(numberString.get(numberString.size()-2).substring(initialIndex,initialIndex + finalIndex-1),currentNumber)!=-1){
						largestSubString.add(numberString.get(numberString.size()-2).substring(initialIndex,initialIndex + finalIndex-1));
					       }
					initialIndex++;
				}
			}
		
			
		}
		
		

	}
	static int isSubstring(
	        String s1, String s2)
	    {
	        int M = s1.length();
	        int N = s2.length();
	 
	       
	        for (int i = 0; i <= N - M; i++) {
	            int j;
	 
	         
	            for (j = 0; j < M; j++)
	                if (s2.charAt(i + j)
	                    != s1.charAt(j))
	                    break;
	 
	            if (j == M)
	                return i;
	        }
	 
	        return -1;
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
	        String nextLine() 
	        { 
	            String str = ""; 
	            try
	            { 
	                str = br.readLine(); 
	            } 
	            catch (IOException e) 
	            { 
	                e.printStackTrace(); 
	            } 
	            return str; 
	        } 
	        double nextDouble() 
	        { 
	            return Double.parseDouble(next()); 
	        } 
	    }
}
