/*
https://www.acmicpc.net/problem/15681
트리와 쿼리
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] adj, child;
    private static int[] query, Dy;
    private static int n, root, q;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        // 트리를 순회하며 Dy 배열을 채운다.
        solveQuery(root, -1);

        for(int x : query) {
            sb.append(Dy[x]).append("\n");
        }
    }
    private static void solveQuery(int x, int parent) {
        Dy[x] = 1;

        for(int v : adj[x]) {
            if(v == parent) continue;
            solveQuery(v, x);
            Dy[x] += Dy[v];
        }
    }
    private static void input() {
        n = scan.nextInt();
        adj = new ArrayList[n+1];
        child = new ArrayList[n+1];
        Dy = new int[n+1];

        for(int i=1;i<=n;i++) {
            adj[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }
        root = scan.nextInt();
        q = scan.nextInt();
        query = new int[q];

        for(int i=1;i<n;i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }
        for(int i=0;i<q;i++) {
            query[i] = scan.nextInt();
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
