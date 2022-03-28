/*
https://www.acmicpc.net/problem/2667
단지 번호 붙이기
격자형 그래프 문제를 풀 때는 
상 하 좌 우 방향으로 이동할 수 있도록 dir 배열을 선언하고
특정 좌표에 해당 배열의 값을 더하면서 이동시킨다. 
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static boolean[][] visited;
    static int N;
    static int[][] adj, dir={{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static int dfs(int x, int y) {
        int cnt=1;

        visited[x][y] = true;

        for(int i=0;i<dir.length;i++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];

            // nx, ny 가 범위에서 벗어나거나, 해당 좌표가 비어있거나,
            // 방문했던 집이면 건너뛴다.
            if( nx < 1 || ny < 1 || nx > N || ny > N ) continue;
            if( adj[nx][ny] == 0 )  continue;
            if( visited[nx][ny] ) continue;

            // 방문했던 적이 없는 집을 발견하면 해당 좌표에 대해 dfs 함수를 호출한다.
            cnt += dfs(nx, ny);
        }
        return cnt;
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> cntArr = new ArrayList<>();
        int cnt;

        // 1, 1 부터 행렬을 탐색하면서 방문하지 않았던 집이 있으면
        // 해당 좌표에 대해 dfs 메소드를 호출한다.
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(adj[i][j] == 1 && !visited[i][j]) {
                    cnt = dfs(i, j);
                    cntArr.add(cnt);
                }
            }
        }
        sb.append(cntArr.size()).append('\n');
        Collections.sort(cntArr);
        for (int n : cntArr)
            sb.append(n).append('\n');
        System.out.println(sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x, y;

        N = Integer.parseInt(bf.readLine());
        adj = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        // 인접행렬 초기화
        for(int i=1;i<=N;i++) {
            String digits = bf.readLine();
            for(int j=0;j<digits.length();j++) {
                adj[i][j+1] = digits.charAt(j) - '0';
            }
        }
    }
}
