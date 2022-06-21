/*
https://www.acmicpc.net/problem/11066
파일 합치기
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[][] Dy, sum;
    private static int[] A;
    private static int N;

    public static void main(String[] args) {
        int T = scan.nextInt();

        while(T-- > 0) {
            input();
            solution();
        }
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void preprocess() {
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(i == j)
                    sum[i][j] = A[i];
                else
                    sum[i][j] = sum[i][j - 1] + A[j];
            }
        }
    }
    private static void solution() {
        preprocess();

        for(int len=2;len<=N;len++) {
            for(int i=1;i<=N - len + 1;i++) {
                int j = i + len - 1;
                Dy[i][j] = Integer.MAX_VALUE;

                for(int k=i;k<j;k++) {
                    Dy[i][j] = Math.min(
                            Dy[i][j],
                            Dy[i][k] + Dy[k+1][j] + sum[i][j]
                    );
                }
            }
        }

        sb.append(Dy[1][N]).append("\n");
    }
    private static void input() {
        N = scan.nextInt();

        Dy = new int[N+1][N+1];
        sum = new int[N+1][N+1];
        A = new int[N+1];

        for(int i=1;i<=N;i++) {
            A[i] = scan.nextInt();
        }
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