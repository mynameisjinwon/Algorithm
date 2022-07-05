/*
https://www.acmicpc.net/problem/2576
홀수
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static final int INPUT_CNT = 7;

    public static void main(String[] args) {
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        int sum = 0, cnt = 0, min = 101;
        for(int i=0;i<INPUT_CNT;i++) {
            int num = scan.nextInt();

            if(num % 2 != 0) {
                sum += num;
                cnt++;

                min = Math.min(min, num);
            }
        }
        if(cnt > 0) {
            sb.append(sum).append("\n").append(min);
        } else {
            sb.append(-1);
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
