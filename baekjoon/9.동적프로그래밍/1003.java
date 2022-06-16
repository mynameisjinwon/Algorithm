/*
https://www.acmicpc.net/problem/1003
피보나치 함수
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[] zeroCnt, oneCnt;
    private static int N;
    private static final int MAX_VALUE = 41;

    public static void main(String[] args) {
        preprocess();
        int T = scan.nextInt();

        while(T-- > 0) {
            input();
            solution();
        }
        printResult();
    }
    // zeroCnt[i] 는 i 가 입력되었을 때 0이 출력되는 횟수
    // oneCnt[i] 는 i 가 입력되었을 때 1이 출력되는 횟수
    private static void preprocess() {
        zeroCnt = new int[MAX_VALUE];
        oneCnt = new int[MAX_VALUE];
        // 초기값을 설정한다.
        zeroCnt[0] = 1;
        oneCnt[0] = 0;

        zeroCnt[1] = 0;
        oneCnt[1] = 1;

        for(int i=2;i<zeroCnt.length;i++) {
            zeroCnt[i] = zeroCnt[i-1] + zeroCnt[i-2];
            oneCnt[i] = oneCnt[i-1] + oneCnt[i-2];
        }
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        sb.append(zeroCnt[N]).append(" ");
        sb.append(oneCnt[N]).append("\n");
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