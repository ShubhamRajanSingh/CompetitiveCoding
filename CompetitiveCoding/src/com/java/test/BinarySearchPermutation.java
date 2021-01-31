package com.java.test;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jaynil
 */
public class BinarySearchPermutation {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CBinarySearch solver = new CBinarySearch();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class CBinarySearch {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int x = in.nextInt();
            int pos = in.nextInt();
            int left = 0;
            int right = n;
            int small = 0;
            int large = 0;
            long mod = 1_000_000_007;
            while (left < right) {
                int m = (left + right) / 2;
                if (m <= pos) {
                    small++;
                    left = m + 1;
                } else {
                    large++;
                    right = m;
                }
            }
 
            small--;
            long ans = Maths.nCrl(x - 1, small, mod);
            ans = ans * Maths.nCrl(n - x, large, mod);
            ans %= mod;
            for (int i = 1; i <= n - small - large - 1; i++) {
                ans *= i;
                ans %= mod;
            }
            for (int i = 1; i <= small; i++) {
                ans *= i;
                ans %= mod;
            }
            for (int i = 1; i <= large; i++) {
                ans *= i;
                ans %= mod;
            }
            out.println(ans);
        }
 
    }
 
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
    }
 
    static class Maths {
        static long nCrl(long n, long r, long p) {
            //r is small not updated
            long up = 1;
            long down = 1;
            for (long i = n - r + 1; i <= n; i++) {
                up *= i;
                up %= p;
            }
            for (long i = 1; i <= r; i++) {
                down *= i;
                down %= p;
            }
            return (up * power(down, p - 2, p)) % p;
        }
 
        static long power(long x, long y, long p) {
            long res = 1;
            x = x % p;
            while (y > 0) {
                if ((y & 1) == 1)
                    res = (res * x) % p;
                y = y >> 1;
                x = (x * x) % p;
            }
            return res;
        }
 
    }
}
 