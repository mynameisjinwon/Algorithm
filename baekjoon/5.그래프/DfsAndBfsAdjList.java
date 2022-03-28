import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int N, M, start;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

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
            for(int y : adj.get(x)) {
                if(visited[y]) continue;

                visited[y] = true;
                que.add(y);
            }
        }
    }
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for(int y : adj.get(start)) {
            if(visited[y]) continue;

            dfs(y);
        }
    }
    public static void solution() {
        dfs(start);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(start);
        System.out.println(sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x, y;

        N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N+1;i++) {
            adj.add(i, new ArrayList<Integer>());
        }
        visited = new boolean[N+1];
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        for(int i=1;i<=N;i++)
            Collections.sort(adj.get(i));
    }
}
