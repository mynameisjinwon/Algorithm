/*
https://www.acmicpc.net/problem/11403
경로 찾기
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] adj;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
    public static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());

        adj = new int[N][N];
        visited = new boolean[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    adj[i][j] = 1;
                }
            }
        }
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();
        // 정점 i 에 대해서 j 와 연결되어있는지 확인 후 연결되어있으면 1 을 아니면 0 을 저장한다.
        for(int i=0;i<N;i++) {
            dfs(i);
            for(int j=0;j<N;j++) {
                if(visited[j]) sb.append(1).append(" ");
                else sb.append(0).append(" ");
                visited[j] = false;
            }
            sb.append("\n");
        }
        // 출력
        System.out.println(sb);
    }
    public static void dfs(int v) {
        // 정점 v 에 대해서 각 정점들과 연결되어있으면 visited[] 에 true 를 저장한다.
        for(int i=0;i<N;i++) {
            if(adj[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
