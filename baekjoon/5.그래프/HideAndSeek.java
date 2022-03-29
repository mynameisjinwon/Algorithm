import java.io.*;
import java.util.*;

public class Main {

    static int S, D;
    static ArrayList<Integer>[] adjList;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    public static void bfs(int x) {
        Queue<Integer> Q = new LinkedList<>();

        Q.add(x);
        dist[x] = 0;
        visited[x] = true;

        while (!Q.isEmpty()) {
            x = Q.poll();

            for (int v : adjList[x]) {
                if (v < 0 || v > 100000 || visited[v]) continue;

                dist[v] =dist[x] + 1;
                visited[v] = true;
                Q.add(v);
            }
        }

    }
    public static void solution() {
        // 시작점에 대해 bfs() 를 호출한다.
        bfs(S);
        // 수빈이가 있는 점에서 동생이 있는 곳 까지 걸리는 최단시간을 출력한다.
        System.out.println(dist[D]);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        visited = new boolean[100001];
        
        // 각 정점에서 1초만에 갈 수 있는 정점들을 리스트에 저장한다.
        adjList = new ArrayList[100001];
        adjList[0] = new ArrayList<>(Arrays.asList(1));
        adjList[1] = new ArrayList<>(Arrays.asList(0, 2));
        for (int i = 2; i < 100001; i++) {
            adjList[i] = new ArrayList(Arrays.asList(i - 1, i + 1, i * 2));
        }
    }
}
