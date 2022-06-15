/*
https://www.acmicpc.net/problem/11726
2Xn 타일링
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[] Dy;
    private static int N;
    private static final int MAX_VALUE = 1001;

    public static void main(String[] args) {
        preprocess();
        input();
        solution();
        printResult();
    }
    private static void preprocess() {
        Dy = new int[MAX_VALUE];
        Dy[1] = 1;
        Dy[2] = 2;
        
        for(int i=3;i<Dy.length;i++) {
            Dy[i] = (Dy[i-1] + Dy[i-2]) % 10007;
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
