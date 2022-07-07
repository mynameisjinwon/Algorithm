/*
https://www.acmicpc.net/problem/1949
우수 마을
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] adj;
    private static int[][] Dy;
    private static int[] resident;
    private static int N;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        dfs(1, -1);
        int ans = Math.max(Dy[1][0], Dy[1][1]);
        sb.append(ans);
    }
    private static void dfs(int root, int parent) {
        //Dy[i][0] : i를 루트노드로 하는 서브트리 중 루트 노드를 선택하지 않았을 때 최대 주민 수
        //Dy[root][0] = sum(Math.max(Dy[child][0], Dy[child][1]))
        //루트 노드를 선택하지 않는 경우, 자식 노드를 선택할 수도 있고, 선택하지 않을 수도 있기 때문에
        //모든 자식의 Dy[j][0], Dy[j][1] 더 큰 값들을 합쳐서 Dy[root][0] 을 구한다.
        //Dy[i][1] : i를 루트노드로 하는 서브트리 중 루트 노드를 선택했을 때 최대 주민 수
        //루트 노드를 선택하는 경우, 자식 노드를 선택할 수 없기 때문에
        //resident[root] 와 Dy[child][0] 을 합해 Dy[root][1]을 구한다.
        Dy[root][0] = 0;
        Dy[root][1] = resident[root];

        for(int x : adj[root]) {
            if(x == parent) continue;
            dfs(x, root);
            Dy[root][0] += Math.max(Dy[x][0], Dy[x][1]);
            Dy[root][1] += Dy[x][0];
        }
    }
    private static void input() {
        N = scan.nextInt();
        resident = new int[N+1];
        adj = new ArrayList[N+1];
        // 마을의 수의 최대값이 10,000 이고 최대 주민수가 10,000 이기 때문에 
        // 트리 형태를 갖는 마을들 중 최대 9,999 개의 마을을 선택할 수 있고 
        // 그 마을의 주민수가 최대인경우 99,990,000명으로 int 범위 안에 있다.
        Dy = new int[N+1][2];

        for(int i=1;i<=N;i++) {
            resident[i] = scan.nextInt();
            adj[i] = new ArrayList<>();
        }
        for(int i=1;i<N;i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            adj[x].add(y);
            adj[y].add(x);
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
