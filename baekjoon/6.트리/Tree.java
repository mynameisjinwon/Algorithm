/*
https://www.acmicpc.net/problem/1068
트리
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    static int N, deleteNode, root;
    static ArrayList<Integer>[] adj;
    static int[] parent, child;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
    public static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());

        adj = new ArrayList[N];
        parent = new int[N];
        child = new int[N];
        visited = new boolean[N];

        for(int i=0;i<N;i++) {
            adj[i] = new ArrayList<Integer>();
        }
        // 각 노드의 부모를 parent 배열에 저장한다.
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(st.nextToken());
            parent[i] = x;
            // -1 인 경우는 루트인 경우다 root 변수에 i 를 저장한다.
            if(x == -1) {
                root = i;
                continue;
            }
            // 인접 리스트를 생성한다. 트리이기 때문에 adj[i].add(x) 만 해야 될것같다.
            adj[i].add(x);
            adj[x].add(i);
        }
        deleteNode = Integer.parseInt(bf.readLine());
    }
    public static void solution() {
        int cnt = 0;
        // 루트노드를 대상으로 dfs 메소드를 호출한다.
        dfs(root);

        for(int i=0;i<N;i++) {
            // 방문한 노드중 자식의 수가 0 인 노드가 있을 때 cnt 를 증가시킨다.
            if(visited[i] && child[i] == 0) cnt++;
        }
        System.out.println(cnt);
    }
    public static void dfs(int x) {

        // 루트 노드가 delete 노드이면 종료한다.
        if(x == deleteNode) return;
        visited[x] = true;

        for(int v : adj[x]) {
            // 인접한 노드 중 자신의 부모가 있다면 건너뛴다.
            if( v == parent[x]) continue;
            // 인접한 노드 중 삭제할 노드가 있다면 건너 뛴다. 
            // 삭제할 노드와 그 자식들은 방문하지 않는다. 
            if(v == deleteNode) continue;
            
            // 부모노드, 삭제할 노드를 제외하고 연결된 노드(자식)가 있다면 
            // 자식의 수를 의미하는 child 배열 값을 증가시키고 dfs 를 호출한다.
            child[x]++;
            dfs(v);
        }
    }
}
