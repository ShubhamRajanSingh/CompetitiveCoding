package com.java.test;
import java.io.*; 

class Even { 
      
    static long MOD = 1000000007; 
      
    // Function to count number of ways 
    static long countWays(int N) 
    { 
        long count, odd = N / 2, even; 
          
        if ((N & 1) > 0) 
            odd = N / 2 + 1; 
      
        even = N / 2; 
      
        // Case 1: 2 odds and 1 even 
        count = (((odd * (odd - 1)) / 2) 
                          * even) % MOD; 
      
        // Case 2: 3 evens 
        count = (count + ((even * (even 
                - 1) * (even - 2)) / 6)) 
                                  % MOD; 
      
        return (long)count; 
    } 
      
    // Driver code 
    static public void main (String[] args) 
    { 
        int n = 5; 
          
        System.out.println(countWays(n)); 
    } 
} 