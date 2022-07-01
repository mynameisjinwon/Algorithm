/*
https://www.acmicpc.net/problem/5339
콜센터
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        sb.append("     /~\\").append("\n");
        sb.append("    ( oo|").append("\n");
        sb.append("    _\\=/_").append("\n");
        sb.append("   /  _  \\").append("\n");
        sb.append("  //|/.\\|\\\\").append("\n");
        sb.append(" ||  \\ /  ||").append("\n");
        sb.append("============").append("\n");
        sb.append("|          |").append("\n");
        sb.append("|          |").append("\n");
        sb.append("|          |").append("\n");
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
