import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int N, M, start;
    static StringBuilder sb = new StringBuilder();
    // 인접행렬로 그래프 저장
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()) {
            int x = que.poll();
            sb.append(x).append(" ");

            for (int y=1;y<adj[x].length;y++) {
                if(adj[x][y]==0) continue;
                if(visited[y]) continue;

                visited[y] = true;
                que.add(y);
            }
        }
    }
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for(int y=1;y<adj[start].length;y++) {
            if(adj[start][y]==0) continue;
            if(visited[y]) continue;

            dfs(y);
        }
    }
    public static void solution() {
        dfs(start);
        sb.append("\n");
        // visited 배열을 초기화해준다. 
        Arrays.fill(visited, false);
        bfs(start);
        System.out.println(sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x, y;

        N = Integer.parseInt(st.nextToken());
        adj = new int[N+1][N+1];
        visited = new boolean[N+1];
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 인접행렬 초기화
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }
}
