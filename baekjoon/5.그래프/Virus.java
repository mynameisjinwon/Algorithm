/*
https://www.acmicpc.net/problem/2606
바이러스
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    static int N, P, cnt;
    static ArrayList<Integer>[] com;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[] visited;

    public static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        P = Integer.parseInt(bf.readLine());

        com = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<com.length;i++)
            com[i] = new ArrayList<Integer>();

        for(int i=0;i<P;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            com[x].add(y);
            com[y].add(x);
        }
    }
    public static void solution() {

        dfs(1);
        System.out.println(cnt);

    }
    public static void dfs(int v) {

        visited[v] = true;

        for(int x : com[v]) {
            if(visited[x]) continue;

            // 1번과 연결된 점이 있으면
            // 1번을 제외하고 감염된 컴퓨터의 수 cnt 를 증가시킨다.
            cnt++;
            dfs(x);
        }
    }
    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
}
