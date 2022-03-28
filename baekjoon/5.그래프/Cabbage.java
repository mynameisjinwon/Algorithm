/*
https://www.acmicpc.net/problem/1012
유기농 배추
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] giveUp, dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int M, N, k, cnt;

    public static void main(String[] args) throws IOException {
        input();
    }
    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0;i<dir.length;i++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];
            if( nx < 0 || ny < 0 || nx >= M || ny >= N ) continue;
            if(visited[nx][ny]) continue;
            if(giveUp[nx][ny]==0) continue;

            dfs(nx, ny);
        }
    }
    public static void solution() {
        cnt = 0;

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(giveUp[i][j]==1 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());

        for(int i=0;i<t;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            giveUp = new int[M][N];
            visited = new boolean[M][N];

            for(int j=0;j<k;j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                giveUp[x][y] = 1;
            }

            solution();
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
