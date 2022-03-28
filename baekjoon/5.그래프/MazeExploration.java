/*
https://www.acmicpc.net/problem/2178
미로 탐색
*/
import java.io.*;
import java.util.*;

public class Main {

    static int N, M ;
    static int[][] map, dist, dir = {{1, 0},{-1, 0},{0, -1},{0, 1}};;
    static boolean[][]  visited;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void bfs(int x, int y) {
        // 삽입할 떄 x, y 좌표를 삽입하고 꺼내올 때 x, y 를 같이 꺼내오기 때문에
        // Queue 가 하나만 있어도 된다.
        Queue<Integer> Q = new LinkedList<>();

        // 시작 점의 좌표를 큐에 삽입한다.
        Q.add(x);
        Q.add(y);
        visited[x][y] = true;
        // 칸을 셀 때 시작점과 종료지점도 포함하기 때문에
        // 시작점에서 거리를 저장하는 배열에 시작점에 해당하는 좌표에 1을 저장한다.
        dist[x][y] = 1;

        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();

            for(int i=0;i<dir.length;i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if( nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
                if( visited[nx][ny] ) continue;
                if( map[nx][ny] == 0 ) continue;

                Q.add(nx);
                Q.add(ny);
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }
    public static void solution() {
        bfs(0, 0);
        // 시작점 부터 목적지 까지의 거리를 출력한다.
        System.out.println(dist[N-1][M-1]);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String str = bf.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }
}