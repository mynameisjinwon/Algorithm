/*
https://www.acmicpc.net/problem/5063
TGN
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int r, e, c;

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
    public static void solution() {
        if(r < e - c) {
            sb.append("advertise");
        } else if(r > e - c) {
            sb.append("do not advertise");
        } else {
            sb.append("does not matter");
        }
        sb.append("\n");
    }
    private static void input() {
        r = scan.nextInt();
        e = scan.nextInt();
        c = scan.nextInt();
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
