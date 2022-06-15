/*
https://www.acmicpc.net/problem/1753
최단경로
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Edge>[] adj;
    private static int[] dist;
    private static int start;
    private static final int MAX_WEIGHT = 200001;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void dijkstra() {

        PriorityQueue<Info> queue = new PriorityQueue<>();

        queue.add(new Info(start, 0));

        while(!queue.isEmpty()) {
            Info info = queue.poll();
            if(dist[info.idx] < info.weight) continue;

            for(Edge edge : adj[info.idx]) {
                int new_weight = info.weight + edge.weight;
                if(dist[edge.to] <= new_weight) continue;
                dist[edge.to] = new_weight;
                queue.add(new Info(edge.to, new_weight));
            }
        }
    }
    private static void solution() {

        dijkstra();
        for(int i=1;i<dist.length;i++) {
            if(dist[i] == MAX_WEIGHT) sb.append("INF");
            else sb.append(dist[i]);

            sb.append("\n");
        }

    }
    private static void input() {
        int v = scan.nextInt();
        dist = new int[v+1];
        adj = new ArrayList[v+1];
        for(int i=1;i<v+1;i++) {
           adj[i] = new ArrayList<>();
           dist[i] = MAX_WEIGHT;
        }

        int e = scan.nextInt();
        start = scan.nextInt();
        dist[start] = 0;

        for(int i=0;i<e;i++) {
            int s = scan.nextInt();
            int d = scan.nextInt();
            int w = scan.nextInt();

            adj[s].add(new Edge(d, w));
        }
    }
    private static class Info implements Comparable<Info> {
        private int idx;
        private int weight;

        private Info(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return weight - o.weight;
        }
    }
    private static class Edge {
        private int to;
        private int weight;

        private Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
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
