package com.java.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CrossWord {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n;
//		int value;

		CrossNode<Integer> head = null;

		CrossNode<Integer> g;
		System.out.println("Enter N=\t");
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				g = new CrossNode<Integer>();
//				value=sc.nextInt();
				g.setValue(0);
				g.setNextup(null);
				g.setNextdown(null);
				g.setNextleft(null);
				g.setNextright(null);
				g.setrow(i);
				g.setcol(j);

				if (i == 1 && j == 1) {
					head = g;
				}

				else if (i == 1 && j != 1 && j != n) {
					g.connectLeft(g, i, head);// this will give the address of last node in the list to this new node's
												// leftnext variable
					g.connectRight(g, i, head);// this will give the address of new node to the last node's rightnext
												// variable

				} else if (i == 1 && j == n) {

					g.connectLeft(g, i, head);
					g.connectRight(g, i, head);

				}

				else if (j == 1 && i != n && i != 1) {
					g.connectup(g, j, head);
					g.connectdown(g, j, head);
				} else if (j == 1 && i == n) {
					g.connectup(g, j, head);
					g.connectdown(g, j, head);
				} else if (j == n && i != 1 && i != n) {
					g.connectup(g, j, head);
					g.connectdown(g, j, head);
					g.connectLeft(g, i, head);
					g.connectRight(g, i, head);
				} else if (i == n && j == n) {
					g.connectup(g, j, head);
					g.connectdown(g, j, head);
					g.connectLeft(g, i, head);
					g.connectRight(g, i, head);

				} else if (i == n && j != 1 && j != n) {
					g.connectLeft(g, i, head);
					g.connectRight(g, i, head);
					g.connectup(g, j, head);
					g.connectdown(g, j, head);
				} else if (i != 1 && i != n && j != 1 && j != n) {
					g.connectLeft(g, i, head);
					g.connectRight(g, i, head);
					g.connectup(g, j, head);
					g.connectdown(g, j, head);

				}
			}

		} // end of for loop
		BlankBox(head, n);
		

		SetNumber(head, n);
		CrossNode<Integer> wptr;
//		wptr=head;
//		 for(int i=1;i<=n;i++) {
//			 for (int j=1;j<=n;j++) {
//				 System.out.print(wptr.getValue()+" ");
//				 if(wptr.getNextright()!=null) {
//					 wptr=wptr.getNextright();
//				 }
//				 
//			 }
//			 System.out.println();
//				wptr=head;
//				for(int k=0; k<i && wptr.getNextdown()!=null;k++) {
//					wptr=wptr.getNextdown();
//					
//				}
//		 }
	}

	public static void BlankBox(CrossNode<Integer> head, int n) {

		Scanner sc = new Scanner(System.in);
		CrossNode<Integer> wptr = head;
		for (int i = 0; i < n; i++) {
			int count = 0;
			System.out.println("enter the Blank box co-ordinate");
			String x = sc.next();
			StringTokenizer st = new StringTokenizer(x, ",");
			StringTokenizer ss = new StringTokenizer(x, ",");
			while (st.hasMoreTokens()) {
				count++;
				st.nextToken();
			}
			int Blank[] = new int[count];
			int j = 0;
			while (ss.hasMoreTokens()) {
				Blank[j] = Integer.parseInt(ss.nextToken());
				j++;
			}
			if (Blank[0] != 0) {
				for (int w = 1; w < j; w = w + 2) {
					w--;
					while (wptr.getcol() != Blank[w]) {
						wptr = wptr.getNextright();
					}
					int k = 1;
					wptr.setBlack();
					w++;
					while (k < Blank[w]) {
						wptr = wptr.getNextright();
						wptr.setBlack();
						k++;
					}
				}
			}
			wptr = head;
			i++;
			for (int w = 0; w < i; w++) {
				wptr = wptr.getNextdown();
			}
			i--;
		}
	}

	public static void SetNumber(CrossNode<Integer> head, int n) {
		CrossNode<Integer> wptr;
		CrossNode<Integer> Lengthwptr;
		int boxLength=0;
		int count = 0;
		wptr = head;
		int flag=0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (wptr.getBlack() != (-2)) {
					if(wptr.getNextright() != null && wptr.getNextright().getBlack() != (-2))
					{    
						
						if(wptr.getNextleft() == null) {
							flag=1;
								count++;
								wptr.setValue(count);
								Lengthwptr=wptr;
								boxLength++;
								while(Lengthwptr.getNextright()!=null && Lengthwptr.getNextright().getBlack()!= -2) {
									boxLength++;
								    Lengthwptr=Lengthwptr.getNextright();
									
								}
								wptr.setBoxLength(boxLength);
					
						}
						else if(wptr.getNextleft().getBlack() == (-2)) {
							flag=1;
							count++;
							wptr.setValue(count);
							Lengthwptr=wptr;
							boxLength++;
							while(Lengthwptr.getNextright()!=null && Lengthwptr.getNextright().getBlack()!= -2) {
								boxLength++;
							    Lengthwptr=Lengthwptr.getNextright();
								
							}
							wptr.setBoxLength(boxLength);
						}
						
					}
					if(wptr.getNextdown() != null && wptr.getNextdown().getBlack() != (-2) && flag==0)
					{
						if(wptr.getNextup() == null || wptr.getNextup().getBlack() == (-2)) {
						
								count++;
								wptr.setValue(count);
								Lengthwptr=wptr;
								boxLength++;
								while(Lengthwptr.getNextdown()!=null && Lengthwptr.getNextdown().getBlack()!= -2) {
									boxLength++;
								    Lengthwptr=Lengthwptr.getNextdown();
									
								}
								wptr.setBoxLength(boxLength);
						}
						
					}
		
				}
				boxLength=0;
				if (wptr.getNextright() != null) {
					wptr = wptr.getNextright();
				}
				flag=0;
			}
			wptr=head;
			for(int k=0; k<i && wptr.getNextdown()!=null;k++) {
				wptr=wptr.getNextdown();
				
			}

		}

	}
}

