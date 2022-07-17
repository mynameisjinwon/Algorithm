/*
https://www.acmicpc.net/problem/7569
토마토
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static final int[][] dir = {{1, 0, 0,}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    private static int[][][] box, dist;
    private static boolean[][][] visited;
    private static int M, N, H, noGood, ans;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        if(noGood == 0) {
            sb.append(0);
            return;
        }
        bfs();
        if(noGood > 0) sb.append(-1);
        else sb.append(ans);
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<M;k++) {
                    if(box[i][j][k] == 1) {
                        queue.add(i);
                        queue.add(j);
                        queue.add(k);
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        while(!queue.isEmpty()) {
            int h = queue.poll(); // 높이
            int n = queue.poll(); // 가로 위치
            int m = queue.poll(); // 열의 위치

            for(int i=0;i<dir.length;i++) {
                int nh = h + dir[i][0];
                int nn = n + dir[i][1];
                int nm = m + dir[i][2];

                if(nh < 0 || nh >= H || nn < 0 || nn >= N || nm < 0 || nm >= M) continue;
                if(visited[nh][nn][nm]) continue;
                if(box[nh][nn][nm] == -1) continue;
                if(box[nh][nn][nm] == 0) noGood--;

                dist[nh][nn][nm] = dist[h][n][m] + 1;
                ans = Math.max(ans, dist[nh][nn][nm]);
                queue.add(nh);
                queue.add(nn);
                queue.add(nm);

                visited[nh][nn][nm] = true;
            }
        }
    }
    private static void input() {
        M = scan.nextInt(); // 열 개수
        N = scan.nextInt(); // 행 개수
        H = scan.nextInt(); // 높이
        noGood = 0;

        box = new int[H][N][M];
        dist = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<M;k++) {
                    int t = scan.nextInt();
                    box[i][j][k] = t;
                    if(t == 0) noGood++;
                }
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
