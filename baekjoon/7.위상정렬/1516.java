/*
https://www.acmicpc.net/problem/1516
게임 개발
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    // 그래프를 저장하는 인접리스트 adj, 먼저 지어져야하는 건물을 저장하는 2차원배열 mustBuild
    private static ArrayList<Integer>[] adj, mustBuild;
    private static int[] time, indeg;
    private static int N;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        for(int i=1;i<time.length;i++) {
            sb.append(time[i]).append("\n");
        }
        System.out.println(sb);
    }
    private static void updateTime(int x) {
        int max = -1;
        // 해당 건물이 짓기 위해 먼저 지어져야하는 건물들을 짓는데 걸리는 시간 중 최대값과
        // 해당 건물을 짓는데 걸리는 시간을 합친다.
        for(int y : mustBuild[x]) {
            if(max < time[y])
                max = time[y];
        }
        time[x] = time[x] + max;
    }
    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();

        // inDegree 가 0인, 즉 먼저 지어져야할 건물이 없는 건물의 번호를 큐에 삽입한다.
        for(int i=1;i<mustBuild.length;i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();

            // 먼저 지어져야할 건물이 없는 건물을 그래프에서 삭제했을 때
            // 새롭게 inDegree 가 0이 되는 건물의 번호를 큐에 삽입하고
            // 해당 건물이 지어지는 데 필요한 시간을 갱신하는 updateTime 메소드를 호출한다.
            for(int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) {
                    updateTime(y);
                    queue.add(y);
                }
            }
        }
    }
    private static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        mustBuild = new ArrayList[N+1];
        time = new int[N+1];
        indeg = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=1;i<N+1;i++) {
            adj[i] = new ArrayList<Integer>();
            mustBuild[i] = new ArrayList<>();
        }

        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            while(true) {
                int mb = Integer.parseInt(st.nextToken());
                if(mb == -1) break;
                indeg[i]++;
                mustBuild[i].add(mb);
                adj[mb].add(i);
            }
        }
    }
}