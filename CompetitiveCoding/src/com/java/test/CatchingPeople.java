package com.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
 
/**
 * https://codeforces.com/contest/1436/problem/D
 * 
 * @author Maksim
 *
 */
public class CatchingPeople {
	public static void main(String[] arg) {
		final FastScanner in = new FastScanner(System.in);
		final PrintWriter out = new PrintWriter(System.out);
		final int n = in.nextInt();
		final int[] p = in.readIntArr(n - 1);
		final long[] a = new long [n];
		for(int i=0;i<n;i++) {
			a[i]=in.nextLong();
		}
		Solution solution = new Solution(n, p, a);
		out.println(solution.solution2());
		out.close();
		in.close();
	}
 
	private static class Solution {
		private final int n;
		private final int[] p;
		private final long[] a;
		private final Map<Integer, List<Integer>> g;
 
		public Solution(final int n, final int[] p, final long[] a) {
			this.n = n;
			this.p = p;
			this.a = a;
			g = new HashMap<>();
 
			for (int i = 1; i <= n; i++) {
				g.put(i, new ArrayList<>());
			}
 
			for (int i = 2; i <= n; i++) {
				g.get(i).add(p[i-2]);
				g.get(p[i-2]).add(i);
			}
		}
		
		public long solution() {
			PriorityQueue<long []> result = dfs(1, new HashSet<Integer>());
			long max =0;
			for(long []e:result) {
				max=Math.max(e[0], max);
			}
			return max;
		}
		
		public long solution2() {
			long [] max =new long[1];
			dfs_2(1, new HashSet<>(), max);
			return max[0];
		}
		
		
		private long[] dfs_2(int node, Set<Integer> s, long[] max) {
			long sum = a[node-1];
			long leafs = 0;
			s.add(node);
			if(node!=1&&g.get(node).size()==1) {
				leafs=1;
			}
			for(Integer v:g.get(node)) {
				if(s.contains(v)) {
					continue;
				}
				long [] subres = dfs_2(v, s, max);
				sum+=subres[0];
				leafs+=subres[1];
			}
			long localMax = sum/leafs;
			if(sum%leafs!=0) {
				localMax+=1;
			}
			max[0]=Math.max(localMax, max[0]);
			
			return new long[] {sum, leafs};
		}
 
		public PriorityQueue<long[]> dfs(int node, Set<Integer> s) {
			List<Integer> children = g.get(node);
			PriorityQueue<long[]> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1[0], e2[0]));
 
			// leave node
			if (children.size() == 1 && node!=1) {
				pq.add(new long[] { a[node - 1], 1 });
				return pq;
			}
 
			s.add(node);
			for (Integer v : children) {
				if (s.contains(v)) {
					continue;
				}
				PriorityQueue<long[]> r = dfs(v, s);
				pq.addAll(r);	
			}
			compress(pq);
			long people = a[node - 1];
			while (people > 0) {
				long[] e = pq.poll();
				if (pq.isEmpty()) {
					e[0] += people / e[1];
					people %= e[1];
					if (people > 0) {
						long[] ne = new long[] { e[0] + 1, people };
						pq.add(ne);
						people = 0;
					}
					pq.add(e);
				} else {
					long[] next = pq.poll();
					long diff = next[0] - e[0];
					long maxAdd = people / e[1];
					long added = Math.min(diff, maxAdd);
					if (added == 0) {
						long[] ne = new long[] { e[0] + 1, people % e[1] };
						e[1] -= people % e[1];
						people = 0;
						pq.add(ne);
						pq.add(e);
						pq.add(next);
						compress(pq);
						continue;
					}
					e[0] += added;
					people -= added * e[1];
					pq.add(next);
					pq.add(e);
					compress(pq);
				}
			}
		    return pq;
		}
		
		private void compress(PriorityQueue<long[]> pq) {
			if(pq.isEmpty()) return;
			long [] e =pq.poll();
			while(!pq.isEmpty()&&pq.peek()[0]==e[0]) {
				long [] e1 = pq.poll();
				e[1]+=e1[1];
			}
			pq.add(e);
		}
	}
 
 
	private static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
 
		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		int[] readIntArr(int n) {
			int[] result = new int[n];
			for (int i = 0; i < n; i++) {
				result[i] = Integer.parseInt(next());
			}
			return result;
		}
 
		void close() {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
	}
 
}