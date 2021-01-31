package com.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
	
	private static char x[][]=new char[9][20];
	
	static List<Integer> row=new ArrayList<Integer>();
	static List<Integer> col=new ArrayList<Integer>();
	private static int count=0,nes=0,nws=0,ses=0,sws=1;
    static 	 int all=0,lost=0;

	
	private static void CoronaVirus(char arr[][],int a,int b,int co,int ne,int nw,int se,int sw) {
		
		if(co>=2) {
			return;
		}
		
		if(a==8 && b==0) {
			

			a=a-1;
			b=b+1;
			
			CoronaVirus(x,a,b,co,ne,nw,se,sw);
		}
		
		else if(arr[a][b]=='*') {
	
			row.add(a);
			col.add(b);
			co++;
			
			if(ne==1) {
				ne=0;
				se=1;
			}
			else if(se==1) {
				se=0;
				ne=1;
			}
			else if(nw==1) {
				nw=0;
				sw=1;
			}
			else if(sw==1) {
				nw=1;
				sw=0;
			}
			
			if(ne==1) {
				a=a+1;
				b=b-1;
			}
			else if(nw==1) {
				a=a+1;
				b=b+1;
			}
			else if(se==1) {
				
				a=a-1;
				b=b-1;
			}
			else if (sw==1) {
				a=a-1;
				b=b+1;
				
			}
			CoronaVirus(x,a,b,co,ne,nw,se,sw);
		}
		else if(arr[a][b]=='a') {
			
			all--;
		
			row.add(a);
			col.add(b);
            arr[a][b]='-';
			if(sw==1) {
				sw=0;
				se=1;
				
			}
			else if(se==1) {
			   ne=1;
			   se=0;
		   }
			else if(nw==1) {
			   nw=0;
			   sw=1;
		   }
			else if(ne==1) {
			   ne=0;
			   nw=1;
		   }
			if(ne==1) {
				a=a+1;
				b=b-1;
			}
			else if(nw==1) {
				a=a+1;
				b=b+1;
			}
			else if(se==1) {
				
				a=a-1;
				b=b-1;
			}
			else if (sw==1) {
				a=a-1;
				b=b+1;
				
			}
			
			CoronaVirus(x,a,b,co,ne,nw,se,sw);
		}
		else if(arr[a][b]=='c') {
			all--;
			
	
			
			row.add(a);
			col.add(b);
			 arr[a][b]='-';
			if(sw==1) {
			sw=0;
			nw=1;
			
		}
		else if(se==1) {
		   sw=1;
		   se=0;
	   }
		else if(nw==1) {
		   nw=0;
		   ne=1;
	   }
		else if(ne==1) {
		   ne=0;
		   se=1;
	   }
			
			if(ne==1) {
				a=a+1;
				b=b-1;
			}
			else if(nw==1) {
				a=a+1;
				b=b+1;
			}
			else if(se==1) {
				
				a=a-1;
				b=b-1;
			}
			else if (sw==1) {
				a=a-1;
				b=b+1;
				
			}
			
			CoronaVirus(x,a,b,co,ne,nw,se,sw);
		}
		
		else if(arr[a][b]=='.' ||arr[a][b]=='-' ) {
			
	
			row.add(a);
			col.add(b);
			
			
			if(ne==1) {
				a=a+1;
				b=b-1;
			}
			else if(nw==1) {
				a=a+1;
				b=b+1;
			}
			else if(se==1) {
				
				a=a-1;
				b=b-1;
			}
			else if (sw==1) {
				a=a-1;
				b=b+1;
				
			}
			
			CoronaVirus(x,a,b,co,ne,nw,se,sw);
			
		}
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
	   
	    
		String s;
		Scanner sc=new Scanner(System.in);
		
		
		for(int i=0;i<9;i++) {
			s=sc.nextLine();
		
			
			
			if(s.length()>3) {
			
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)=='a' ||s.charAt(j)=='c') {
					all++;
					lost++;
				}
				
	
				x[i][j]=s.charAt(j);
			    }	
			}
			else if(s.length()<3&& i!=8){
			
				i=i-1;
			}
			
			
			
		}
		for (int j=0;j<20;j++) {
			x[8][j]='*';
		}
		

	
	
		
		
	   row.add(8);
	   col.add(0);
		CoronaVirus(x,8,0,count,nes,nws,ses,sws);
		
		
		for(int i=0;i<row.size();i++) {
			
			row.get(i);
			System.out.println(col.get(i)+" "+(8-row.get(i)));
		}
		
//		
//		for(int ls:row) {
//			
//			System.out.print((8-ls)+" ");
//		}
//		System.out.println();
//	  for(int ls:col) {
//			
//			System.out.print(ls+" ");
//		}
//	  
	  for(int i=0;i<9;i++) {
		  for(int j=0;j<20;j++) {
			  System.out.print(x[i][j]);
		  }
		  System.out.println();
		  System.out.println();
	  }
	  
	  System.out.println("safe="+(all));
	  System.out.println("infected="+(lost-all));
	  
	  
		
	
	}

}
