/*
https://www.acmicpc.net/problem/2251
물통
넘모 어렵다
이런 문제가 정답률 50%라니 믿을 수가 없다.
...
*/
import java.io.*;
import java.util.*;

public class Main {

    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    static class State {
        int[] X;
        State(int[] _X) {
            X = new int[3];
            for(int i=0;i<3;i++) X[i] = _X[i];
        }

        State move(int from, int to) {
            int[] tmp = {X[0], X[1], X[2]};

            int cap = limit[to] - tmp[to];
            if(tmp[from] <= cap) {
                tmp[to] += tmp[from];
                tmp[from] = 0;
            } else {
                tmp[to] = limit[to];
                tmp[from] -= cap;
            }
            return new State(tmp);
        }
    }
    public static void bfs(State state) {
        Queue<State> que = new LinkedList<>();
        int a = state.X[0] , b = state.X[0], c = state.X[0];

        que.add(state);
        visited[a][b][c] = true;

        while(!que.isEmpty()) {
            State tmp = que.poll();
            if(tmp.X[0] == 0) possible[tmp.X[2]] = true;

            for(int from=0;from<state.X.length;from++) {
                if(tmp.X[from] == 0) continue;
                for(int to=0;to<state.X.length;to++) {
                    if(from == to) continue;
                    if(tmp.X[to]==limit[to]) continue;

                    State ns = tmp.move(from, to);
                    if(!visited[ns.X[0]][ns.X[1]][ns.X[2]]) {
                        visited[ns.X[0]][ns.X[1]][ns.X[2]] = true;
                        que.add(ns);
                    }
                }
            }
        }
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();

        bfs(new State(new int[]{0, 0, limit[2]}));
        for(int i=0;i<possible.length;i++) {
            if(possible[i])
                sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        limit = new int[3];
        possible = new boolean[201];
        visited = new boolean[201][201][201];
        for(int i=0;i<3;i++)
            limit[i] = Integer.parseInt(st.nextToken());
    }
}
