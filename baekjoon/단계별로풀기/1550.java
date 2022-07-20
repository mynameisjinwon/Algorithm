/*
https://www.acmicpc.net/problem/1550
16진수
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static String s;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        int ans = 0;

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int tmp = decToHex(c, i);
            ans += tmp;
        }

        sb.append(ans);
    }
    private static int decToHex(char c, int i) {
        int rv = 0;
        if(c > 47 && c < 58)
            return (c - '0') * (int)Math.pow(16, s.length()-i-1);
        switch(c) {
            case 'A':
                rv = 10;
                break;
            case 'B':
                rv = 11;
                break;
            case 'C':
                rv = 12;
                break;
            case 'D':
                rv = 13;
                break;
            case 'E':
                rv = 14;
                break;
            case 'F':
                rv = 15;
                break;
        }
        return rv * (int)Math.pow(16, s.length()-i-1);
    }
    private static void input() {
        s = scan.next();
    }
    private static class MyReader {
        BufferedReader bf;
        StringTokenizer st;

        private MyReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while( st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String str = "";
            try {
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
