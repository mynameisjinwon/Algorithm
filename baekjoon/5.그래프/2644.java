/*
https://www.acmicpc.net/problem/2644
촌수계산
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] adj;
    private static int[] dist;
    private static int n, m, x, y;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        bfs(x);

        sb.append(dist[y]);
    }
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.add(start);
        dist[start] = 0;

        while(!queue.isEmpty()) {
            int v = queue.poll();
            visited[v] = true;

            for(int node : adj[v]) {
                if(visited[node]) continue;
                dist[node] = dist[v] + 1;
                queue.add(node);
            }
        }
    }
    private static void input() {
        n = scan.nextInt();
        dist = new int[n+1];
        adj = new ArrayList[n+1];

        for(int i=1;i<n+1;i++) {
            adj[i] = new ArrayList<>();
            dist[i] = -1;
        }

        x = scan.nextInt();
        y = scan.nextInt();

        m = scan.nextInt();
        for(int i=0;i<m;i++) {
            int p = scan.nextInt();
            int c = scan.nextInt();

            adj[p].add(c);
            adj[c].add(p);
        }
    }
    private static class MyReader {
        BufferedReader bf;
        StringTokenizer st;

        private MyReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while( st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String str = "";
            try {
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
