package com.java.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
 
public class BallOfSteel {
    static InputReader in = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static final long mod = (long) 1e9 + 7;
    static long inf = (long) -1e8;
    static long ss = 0;
    static int MAX_N = (int) 1e8 + 9;
 
    public static void main(String args[]) {
 
        int t = 1;
        t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve();
        }
        pw.flush();
        pw.close();
    }
 
    private static void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        int x[] = new int[n+10];
        int y[] = new int[n+10];
        for(int i=0 ; i < n ; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        for(int i = 0 ; i < n ; i++) {
            boolean f=true;
            for(int j = 0 ; j < n ; j++) {
                int d = Math.abs(x[i] - x[j])  + Math.abs(y[i] - y[j]);
                if(d > k) {
                    f = false;
                    break;
                }
            }
            if(f) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(-1);
    }
 
    private static void print(ArrayList<Integer> ans) {
        int cnt = calAns(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
 
    private static int calAns(ArrayList<Integer> ans) {
        int cnt = 0;
        for (int i = 1; i < ans.size() - 1; i++) {
            if (ans.get(i - 1) > ans.get(i) && ans.get(i) < ans.get(i + 1)) {
                cnt++;
            }
        }
        return cnt;
    }
 
    private static ArrayList<Integer> sol(int mid, ArrayList<Integer> list) {
        ArrayList<Integer> ans = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            ans.add(0);
        }
        int p = mid - 1;
        for (int i = mid * 2 - 1; i >= 0; i -= 2) {
            ans.set(i, list.get(p--));
        }
        int n = list.size() - 1;
        for (int i = mid * 2; i >= 0; i -= 2) {
            ans.set(i, list.get(n--));
 
        }
        for (int i = mid * 2 + 1; i < ans.size(); i++) {
            if (n < mid) {
                break;
            }
            ans.set(i, list.get(n--));
        }
 
        if (mid == calAns(ans)) {
            return ans;
        } else return new ArrayList<>();
 
    }
 
    private static int[] scan(int r) {
        int[] ret = new int[r + 1];
        for (int i = 1; i < r + 1; i++) ret[i] = in.nextInt();
        Arrays.sort(ret);
        return ret;
    }
 
    private static void dfs(Set<Integer>[] rev, boolean[] vis, int v) {
        vis[v] = true;
        for (int u : rev[v]) {
            if (vis[u]) continue;
            dfs(rev, vis, u);
        }
 
    }
 
    private static void topSort(ArrayList<Integer> top, ArrayList<Integer>[] g, int v, boolean[] vis) {
        vis[v] = true;
        for (int u : g[v]) {
            if (vis[u]) continue;
            topSort(top, g, u, vis);
        }
        top.add(v);
    }
 
    public static long gcd(long a, long b) {
        if (b != 0)
            return gcd(b, a % b);
        else
            return a;
    }
 
 
    static long maxSubArraySum(ArrayList<Long> a) {
        int size = a.size();
        long max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a.get(i);
 
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return Math.max(0l, max_so_far);
    }
 
    private static long ncr(long n, long k, long[] fact) {
        if (n < k) return 0;
        long ret = fact[(int) n];
        ret = (ret * pow(fact[(int) (n - k)], mod - 2, mod)) % mod;
        ret = (ret * pow(fact[(int) (k)], mod - 2, mod)) % mod;
 
        return ret;
 
    }
 
    private static long pow(long a, long b, long mod) {
        if (b == 0) return 1;
        if (b == 1) return a % mod;
        long t = pow(a, b / 2, mod);
        t = (t * t) % mod;
        if (b % 2 != 0) {
            t = (t * a) % mod;
        }
        return t;
    }
 
    static class InputReader {
 
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
 
        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
 
 
    private static int[] bfs(ArrayList<Integer>[] g, int a, int n) {
        int dist[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = n + 10;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n + 1];
        dist[a] = 0;
        q.add(a);
        while (!q.isEmpty()) {
            int p = q.poll();
            if (vis[p] == true) {
                continue;
            }
            vis[p] = true;
            for (Integer i : g[p]) {
                if (!vis[i]) {
                    dist[i] = Integer.min(dist[i], dist[p] + 1);
                    q.add(i);
                }
            }
        }
        return dist;
    }
 
 
}