/*
https://www.acmicpc.net/problem/11725
트리의 부모 찾기
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    static int N;
    static ArrayList<Integer>[] adjList;
    static int[] parent ;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
    public static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());

        adjList = new ArrayList[N+1];
        parent = new int[N+1];

        // 루트가 1번이기 때문에 자신의 부모노드 번호를 저장하는 배열 parent 에 1 을 저장한다.
        parent[1] = 1;

        for(int i=0;i<adjList.length;i++)
            adjList[i] = new ArrayList<Integer>();

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList[x].add(y);
            adjList[y].add(x);
        }
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();
        dfs(1);
        for(int i=2;i<parent.length;i++)
            sb.append(parent[i]).append("\n");
        System.out.println(sb);
    }
    public static void dfs(int x) {

        for(int v : adjList[x]) {
            // parent 가 이미 정해진 정점은 건너 뛴다.
            if(parent[v]!=0) continue;
            // 1 번이 루트노드로 정해져있고 1번에 대해서 가장 먼저 메소드가 호출이 되기 때문에
            // parent 가 정해지지않은 정점의 부모노드를 자신 보다 먼저 호출된 연결된 정점으로 지정한다.
            parent[v] = x;
            dfs(v);
        }
    }
}
