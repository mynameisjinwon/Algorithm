/*
https://www.acmicpc.net/problem/1766
문제집

직접 우선순위 큐를 구현해서 풀려고했는데 시간초과가 발생해서 
PriorityQueue 를 사용했다.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] adj;
    private static int[] indeg;
    private static int N, M;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        // 우선순위큐를 사용해서 작은 숫자가 먼저 큐에 입력되도록 했다.
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=1;i<indeg.length;i++) {
            // inDegree 가 0인, 즉 먼저 풀어야할 문제가 없는 문제를 큐에 삽입한다.
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            // 우선 순위를 사용했기 때문에 큐의 가장 첫번째 원소는 현재 큐에있는 가장 작은 원소이다.
            // 해당 숫자를 뽑아서 sb 에 추가한다.
            int x = queue.poll();
            sb.append(x).append(" ");
            // 해당 숫자와 인접한, 즉 해당 문제를 풀면 쉽게 풀 수 있는 문제를 탐색하며
            // 해당 숫자를 제거했을 때 inDegree 가 0 이되는 숫자를 큐에 삽입한다.
            for(int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) {
                    queue.add(y);
                }
            }
        }
    }
    private static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        indeg = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=1;i<N+1;i++) {
            adj[i] = new ArrayList<Integer>();
        }

        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            indeg[y]++;
            adj[x].add(y);
        }
    }
}