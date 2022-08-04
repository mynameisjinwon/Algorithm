/*
https://www.acmicpc.net/problem/5014
스타트링크
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[] dist;
    private static boolean[] visited;
    private static int F, S, G, D, U;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        initialize();
        bfs();
        if(dist[G]==-1) sb.append("use the stairs");
        else sb.append(dist[G]);
    }
    private static void initialize() {
        dist = new int[F+1];
        visited = new boolean[F+1];

        for(int i=1;i<F+1;i++) {
            dist[i] = -1;
        }
        dist[S] = 0;
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(S);
        visited[S] = true;

        while(!queue.isEmpty()) {
            int x = queue.poll();

            if(x + U <= F && !visited[x+U]) {
                dist[x+U] = dist[x] + 1;
                queue.add(x + U);
                visited[x+U] = true;
            }
            if(x - D != x && x - D >= 1 && !visited[x-D]) {
                dist[x-D] = dist[x] + 1;
                queue.add(x - D);
                visited[x-D] = true;
            }
        }
    }
    private static void input() {
        F = scan.nextInt();
        S = scan.nextInt();
        G = scan.nextInt();
        U = scan.nextInt();
        D = scan.nextInt();
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
