/*
https://www.acmicpc.net/problem/1240
노드사이의 거리
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[][] dist, pair;
    private static int n, m;
    private static final int INF = 10000001;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        findDist();

        for(int i=0;i<m;i++) {
            int x = pair[i][0];
            int y = pair[i][1];

            sb.append(dist[x][y]).append("\n");
        }

    }
    private static void findDist() {
        for(int k=1;k<n+1;k++) {
            for(int j=1;j<n+1;j++) {
                for(int i=1;i<n+1;i++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    private static void input() {
        n = scan.nextInt();
        dist = new int[n+1][n+1];

        m = scan.nextInt();
        pair = new int[m][2];

        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
        for(int i=1;i<n;i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int d = scan.nextInt();

            dist[x][y] = d;
            dist[y][x] = d;
        }
        for(int i=0;i<m;i++) {
            int s = scan.nextInt();
            int d = scan.nextInt();

            pair[i][0] = s;
            pair[i][1] = d;
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
