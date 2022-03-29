/*
https://www.acmicpc.net/problem/3055
탈출
정답의 최대치를 잘못 계산해서 틀렸다.
*/
import java.io.*;
import java.util.*;

public class Main {

    static int R, C, MAX = 200;
    static char[][] forest;
    static int[][] dist, water, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        forest = new char[R][C];
        dist = new int[R][C];
        water = new int[R][C];
        visited = new boolean[R][C];

        for(int r=0;r<R;r++) {
            String str = bf.readLine();
            for(int c=0;c<C;c++) {
                forest[r][c] = str.charAt(c);
            }
        }
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();
        char[] avoid = new char[2];
        int ans = 0;

        // 물이 있는 좌표에서 부터 전체 좌표에 물이 도착하는데 걸리는 시간을 저장하는 배열 water 를 초기화한다.
        initMap('*', water);
        // 고슴 도치가 갈 수 있는 좌표와 걸리는 시간을 저장하는 배열 dist 를 초기화한다.
        initMap('S', dist);

        for(int r=0;r<R;r++) {
            for(int c=0;c<C;c++) {
                // 목적지까지 걸리는 시간을 ans 에 저장한다.
                if (forest[r][c] == 'D') {
                    ans = dist[r][c];
                }
            }
        }

        // ans == MAX 이면 물이 더 빨리차서 고슴도치가 목적지로 이동하지 못한경우이다.
        if(ans==MAX)
            sb.append("KAKTUS");
        else
            sb.append(ans);
        System.out.println(sb);
    }
    // 나아가려는 좌표와 현재 좌표값을 받고 나아갈 수 있는 좌표인지를 확인한다.
    public static boolean possibleToGo(char s, int nr, int nc, int r, int c) {
        // 범위를 벗어나거나 방문한 좌표라면 false 를 리턴한다.
        if( nr < 0 || nc < 0 || nr >= R || nc >= C ) return false;
        if( visited[nr][nc] ) return false;

        boolean possible = false;

        // s 가 물이면
        if( s == '*' ) {
            // 나아가려는 좌표에 돌과 비버집이 없으면 true 를 리턴한다.
            if(forest[nr][nc] != 'X' && forest[nr][nc] != 'D')
                possible = true;
        // s 가 고슴도치면 나아가려는 좌표에 물이 닿는 시간보다 고슴도치가 도착하는 시간이 더 빠를 경우,
        // 나아가려는 좌표에 돌이나 물이 없을 때 true 를 리턴한다.
        } else {
            if( water[nr][nc] > dist[r][c] + 1 && (forest[nr][nc] != 'X' && forest[nr][nc] != '*'))
                possible = true;
        }
        return possible;
    }
    public static void initMap(char s, int[][] arr) {
        Queue<Integer> Q = new LinkedList<>();

        for(int r=0;r<R;r++) {
             for(int c=0;c<C;c++)     {
                 // 인자로 들어온 배열의 모든 원소를 MAX 값으로 초기화한다.
                 arr[r][c] = MAX;
                // visited 배열을 초기화한다.
                visited[r][c] = false;
                // 인자로 전달받은 문자가 있는 좌표를 큐에 저장한다.
                if(forest[r][c] == s) {
                    Q.add(r);
                    Q.add(c);
                    arr[r][c] = 0;
                    visited[r][c] = true;
                }
            }
        }
        while (!Q.isEmpty()) {
            int r = Q.poll();
            int c = Q.poll();

            for(int d=0;d<dir.length;d++) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];
                if(!possibleToGo(s, nr, nc, r, c)) continue;

                arr[nr][nc] = arr[r][c] + 1;
                visited[nr][nc] = true;
                Q.add(nr);
                Q.add(nc);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
