/*
https://www.acmicpc.net/problem/4963
섬의개수
*/
import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int W, H;
    // dir = 상하좌우, 대각선으로 한칸 이동한 좌표를 구하기 위한 배열
    static int[][] map, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static boolean[][] visited;

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(bf.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            if(W == 0 && H == 0) break;

            map = new int[H][W];
            visited = new boolean[H][W];

            for(int h=0;h<H;h++) {
                st = new StringTokenizer(bf.readLine());
                for(int w=0;w<W;w++){
                    map[h][w] = Integer.parseInt(st.nextToken());
                }
            }
            solution();
        }
        System.out.println(sb);
    }
    public static void solution() {
        int isCnt = 0;

        for(int h=0;h<H;h++) {
            for(int w=0;w<W;w++) {
                // dfs() 를 호출하는 횟수가 섬의 개수다.
                if(map[h][w] == 1 && !visited[h][w]) {
                    dfs(h, w);
                    isCnt++;
                }
            }
        }
        sb.append(isCnt).append('\n');
    }
    public static void dfs(int h, int w) {

        visited[h][w] = true;

        for(int d=0;d<dir.length;d++) {
            int nw = w + dir[d][0];
            int nh = h + dir[d][1];
            if( nw < 0 || nh < 0 || nw >= W || nh >= H ) continue;
            if( map[nh][nw] != 1 ) continue;
            if( visited[nh][nw] ) continue;

            visited[nh][nw] = true;
            dfs(nh, nw);
        }

    }
    public static void main(String[] args) throws IOException {
        input();
    }
}
