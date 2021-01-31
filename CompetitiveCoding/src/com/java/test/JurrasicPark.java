package com.java.test;

import java.util.*;
import java.lang.*;
import java.io.*;
class JurrasicPark
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for(int a = 0 ; a < test ; a++){
                
                int n=scanner.nextInt();
                int m=scanner.nextInt();
                int q=scanner.nextInt();
                int p=scanner.nextInt();
                int r=scanner.nextInt();
                int k=scanner.nextInt();      
                int nn=n,rr=0;
                int arr[]=new int[n];int c=0;
                for(int i=0;i<n;i++)
                {
                    arr[i]=-1;
                }
                int total=0;
                for(int i=0;i<=k;i++)
                {
                    if(rr==r)
                    {
                        if(m>0)
                        {
                            m--;
                            q++;
                        }
                        rr=0;
                    }
                    rr++;
                    for(int j=0;j<nn;j++)
                    {
                        if(arr[j]!=-1)
                        {
                            arr[j]++;
                            if(arr[j]==p)
                            {
                                n++;
                                total++;
                                arr[j]=-1;
                            }
                        }
                    }
                    for(int j=0;j<nn;j++)
                    {
                        if(n>0 && q>0 && arr[j]==-1)
                        {
                            n--;
                            q--;
                            arr[j]=0;
                        }
                    }
                }
                System.out.println(n+" "+total+" "+m+" "+q);
   
        }
    }
}
