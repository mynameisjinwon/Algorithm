/*
https://www.acmicpc.net/problem/15991
1, 2, 3 더하기 6
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static long[] Dy;
    private static int N;
    private static final int MAX_VALUE = 100001, DIVISOR = 1000000009;

    public static void main(String[] args) {
        int T = scan.nextInt();

        preprocess();
        while(T-- > 0) {
            input();
            solution();
        }
        printResult();
    }
    private static void preprocess() {
        Dy = new long[MAX_VALUE];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 2;
        Dy[4] = 3;
        Dy[5] = 3;
        Dy[6] = 6;

        // 합이 대칭을 이루어야 하기때문에
        // 전에 있던 합의 양 끝에
        // 1, 1 을 합치는 경우(+2),
        // 2, 2 를 합치는 경우(+4),
        // 3, 3 을 합치는 경우(+6) 를 합쳐서 새로운 항을 구할 수 있다.
        for(int i=7;i<MAX_VALUE;i++) {
            Dy[i] = (Dy[i-2] + Dy[i-4] + Dy[i-6]) % DIVISOR;
        }
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        sb.append(Dy[N]).append("\n");
    }
    private static void input() {
        N = scan.nextInt();
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
