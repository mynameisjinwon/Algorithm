/*
https://www.acmicpc.net/problem/11724
연결 요소의 개수
정점만 있는 경우도 연결 요소가 있는 것이다.
solution() 메소드에서 list[i].size() 가 0 을 초과할 때와 정점 i 를 방문하지 않았을 때만 dfs 메소드를 호출했는데
정점만 있는 경우는 연결 요소로 추가하지 않아서 틀렸다.
그래서 list[i].size() > 0 조건을 빼고 제출했더니 맞았다.
*/
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int V, E;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void dfs(int start) {
        visited[start] = true;

        for(int x : list[start]) {
            if(visited[x]) continue;

            dfs(x);
        }
    }
    public static void solution() {
        int cnt=0;

        for(int i=1;i<list.length;i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        visited = new boolean[V+1];

        for(int i=1;i<V+1;i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }
    }
}
