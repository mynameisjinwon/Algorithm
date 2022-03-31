/*
https://www.acmicpc.net/problem/1068
트리
서브트리를 활용해 보았다.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    static int N, deleteNode, root;
    static ArrayList<Integer>[] tree;
    static int[] leaf, parent;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
    public static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());

        tree = new ArrayList[N];
        leaf = new int[N];
        parent = new int[N];

        for(int i=0;i<N;i++) {
            tree[i] = new ArrayList<Integer>();
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(st.nextToken());
            parent[i] = x;
            // -1 인 경우는 루트인 경우다 root 변수에 i 를 저장한다.
            if(x == -1) root = i;
        }
        deleteNode = Integer.parseInt(bf.readLine());
        parent[deleteNode] = -2;
        // 삭제될 노드의 부모를 없애버린다.
        // 삭제될 노드가 자식이 있으면 미아가 된다.
        // 삭제될 노드가 자식이 있어도 자식은 삭제될 노드를 가리키고있지만
        // 루트노드에 대해서 dfs 를 호출하기 때문에 root 와 연결되지 않아서 탐색하지 않는다.
        for(int i=0;i<N;i++) {
            if(parent[i] < 0) continue;
            tree[parent[i]].add(i);
        }
    }
    public static void solution() {
        // 삭제할 노드가 루트노드가 아닐 때 루트를 대상으로 dfs 메소드를 호출한다.
        if(root != deleteNode)
            dfs(root);
        System.out.println(leaf[root]);
    }
    public static void dfs(int x) {
        // tree[x] 가 비어있으면 x 는 단말노드라는 의미이다. leaf[x] 에 1을 저장하고 메소드를 종료한다.
        if(tree[x].isEmpty()) {
            leaf[x] = 1;
            return;
        }
        // 연결된 정점(자식 노드)에대해서 dfs 를 호출하고
        // 자식노드의 leaf[v] 값을 자신의 leaf[x] 값에 저장한다.
        for(int v : tree[x]) {
            dfs(v);
            leaf[x] += leaf[v];
        }
    }
}
