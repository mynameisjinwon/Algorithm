/*
https://www.acmicpc.net/problem/1005
ACM Craft

*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int T, N, K, W;
    private static int[] D, indeg, time;
    private static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        input();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<indeg.length;i++) {
            if(indeg[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            time[x] = Math.max(time[x], D[x]);

            for(int y : adj[x]) {
                time[y] = Math.max(time[y], time[x] + D[y]);
                indeg[y]--;
                if(indeg[y] == 0)
                    queue.add(y);
            }
        }

        sb.append(time[W]).append("\n");
    }
    private static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(bf.readLine());
        for(int i=0;i<T;i++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            D = new int[N+1];
            indeg = new int[N+1];
            time = new int[N+1];
            adj = new ArrayList[N+1];
            for(int j=1;j<N+1;j++) {
                adj[j] = new ArrayList<Integer>();
            }

            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<N+1;j++) {
                D[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0;j<K;j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                indeg[y]++;
                adj[x].add(y);
            }
            W = Integer.parseInt(bf.readLine());

            solution();
        }
    }
}