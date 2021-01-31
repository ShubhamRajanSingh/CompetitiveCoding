package com.java.test;

import java.io.*;
class Chackra
    {
        public static void main(String args[])throws IOException
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int no=Integer.parseInt(br.readLine());
 
            int A[][]=new int[no][no];
            int x[]=new int[no];
            int y[]=new int[no];
            int k=1,a=1,col1=0, col2=no-1, row1=0, row2=no-1;
 
            while(k<=no*no)
                {
                    
                    for(int i=col1;i<=col2;i++)
                    {
                        A[row1][i]=k++;
                        if(A[row1][i]%11==0)
                            {
                                x[a]=row1;
                                y[a]=i;
                                a++;
                            }
                    }
 
                    for(int j=row1+1;j<=row2;j++)
                    {
                        A[j][col2]=k++;
                        if(A[j][col2]%11==0)
                            {
                                x[a]=j;
                                y[a]=col2;
                                a++;
                            }
                    }
 
                    for(int i=col2-1;i>=col1;i--)
                    {
                        A[row2][i]=k++;
                        if(A[row2][i]%11==0)
                            {
                                x[a]=row2;
                                y[a]=i;
                                a++;
                            }
                    }
 
                    for(int j=row2-1;j>=row1+1;j--)
                    {
                        A[j][col1]=k++;
                        if(A[j][col1]%11==0)
                            {
                                x[a]=j;
                                y[a]=col1;
                                a++;
                            }
                    }
 
                 col1++;
                 col2--;
                 row1++;
                 row2--;
                }
            for(int i=0;i<no;i++)
                {
                    for(int j=0;j<no;j++)
                        {
                        System.out.print(A[i][j]+" ");
                        }
                 System.out.print("\n");
                }
               System.out.print("Total Power points : "+a+"\n(0,0) \n");
               for(int i=1;i<a;i++)
               {
                   System.out.print("("+x[i]+","+y[i]+") \n");
               }
               }
        }