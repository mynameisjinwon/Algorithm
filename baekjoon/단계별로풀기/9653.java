/*
https://www.acmicpc.net/problem/9653
스타워즈 로고
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
        sb.append("    8888888888  888    88888").append("\n");
        sb.append("   88     88   88 88   88  88").append("\n");
        sb.append("    8888  88  88   88  88888").append("\n");
        sb.append("       88 88 888888888 88   88").append("\n");
        sb.append("88888888  88 88     88 88    888888").append("\n").append("\n");

        sb.append("88  88  88   888    88888    888888").append("\n");
        sb.append("88  88  88  88 88   88  88  88").append("\n");
        sb.append("88 8888 88 88   88  88888    8888").append("\n");
        sb.append(" 888  888 888888888 88  88      88").append("\n");
        sb.append("  88  88  88     88 88   88888888").append("\n");
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