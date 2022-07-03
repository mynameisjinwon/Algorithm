/*
https://www.acmicpc.net/problem/2167
2차원 배열의 합
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[][] arr, cond;
    private static int r, c, t;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static int addArr(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for(int i=x1;i<=x2;i++) {
            for(int j=y1;j<=y2;j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
    private static void solution() {
        for(int i=0;i<t;i++) {
            int x1 = cond[i][0], y1 = cond[i][1];
            int x2 = cond[i][2], y2 = cond[i][3];

            int sum = addArr(x1, y1, x2, y2);
            sb.append(sum).append("\n");
        }
    }
    private static void input() {
        r = scan.nextInt();
        c = scan.nextInt();

        arr = new int[r+1][c+1];
        for(int i=1;i<=r;i++) {
            for(int j=1;j<=c;j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        t = scan.nextInt();
        cond = new int[t][4];

        for(int i=0;i<t;i++) {
            for(int j=0;j<4;j++) {
                cond[i][j] = scan.nextInt();
            }
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
