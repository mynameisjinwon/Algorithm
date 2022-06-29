/*
https://www.acmicpc.net/problem/2953
나는 요리사다
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static String str;
    private static int[] score;
    private static int max, winner;
    private static final int COOK = 5;

    public static void main(String[] args) {
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        for(int i=0;i<COOK;i++) {
            int sum = 0;
            for(int j=1;j<COOK;j++) {
                int s = scan.nextInt();
                sum += s;
            }
            if(max < sum) {
                max = sum;
                winner = i+1;
            }
        }
        sb.append(winner).append(" ").append(max);
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
