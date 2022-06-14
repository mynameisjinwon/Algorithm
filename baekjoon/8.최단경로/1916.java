/*
https://www.acmicpc.net/problem/1916
최소비용 구하기
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
    private static int start, dest;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        PriorityQueue<Info> queue = new PriorityQueue<>();

        queue.add(new Info(start, 0));

        while(!queue.isEmpty()) {
            Info info = queue.poll();
            // 먼저 삽입된 경로의 가중치가 현재까지 알아낸 가중치보다 크다면 해당 경로를 탐색할 가치가 없다.
            if(dist[info.idx] < info.weight) continue;

            for(Edge edge : adj[info.idx]) {
                int new_weight = info.weight + edge.weight;
                // 새로운 경로의 가중치가 현재까지 알아낸 가중치보다 크다면 해당 경로를 탐색할 가치가 없다.
                if(new_weight >= dist[edge.to]) continue;
                dist[edge.to] = new_weight;
                queue.add(new Info(edge.to, new_weight));
            }
        }
        sb.append(dist[dest]);
    }
    private static void input() {
        int n = scan.nextInt();
        adj = new ArrayList[n+1];
        dist = new int[n+1];

        for(int i=1;i<n+1;i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        int m = scan.nextInt();

        for(int i=0;i<m;i++) {
            int s = scan.nextInt();
            int d = scan.nextInt();
            int w = scan.nextInt();

            adj[s].add(new Edge(d, w));
        }
        start = scan.nextInt();
        dest = scan.nextInt();
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
