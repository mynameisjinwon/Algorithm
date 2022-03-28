/*
https://www.acmicpc.net/problem/2667
단지 번호 붙이기
격자형 그래프 문제를 풀 때는 
상 하 좌 우 방향으로 이동할 수 있도록 dir 배열을 선언하고
특정 좌표에 해당 배열의 값을 더하면서 이동시킨다. 
*/
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {

    static boolean[][] visited;
    static int N;
    static int[][] adj, dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void setQue(int x, int y, Queue<Integer> xQue, Queue<Integer> yQue) {
        xQue.add(x);
        yQue.add(y);
        visited[x][y] = true;
    }
    public static int bfs(int x, int y) {
        Queue<Integer> xQue = new LinkedList<>();
        Queue<Integer> yQue = new LinkedList<>();
        int cnt= 0;

        visited[x][y] = true;
        xQue.add(x);
        yQue.add(y);
        cnt++;

        while( !xQue.isEmpty() & !yQue.isEmpty() ) {
            x = xQue.poll();
            y = yQue.poll();

            // 상 하 좌 우를 보고 1이거나 방문하지 않은 점이라면 큐에 집어넣는다.
            // 상, 하, 좌, 우 방향으로 한칸씩 이동할 수 있게 dir 배열을 만들고
            // x, y 를 dir 배열의 원소와 합해 nx, ny 에 대입한다.
            // nx, ny 는 각각 x, y 에 대해 상,하,좌,우 방향으로 한칸씩 이동한 좌표이다.
            for(int i=0;i<dir.length;i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];

                // 한칸씩 이동한 좌표가 범위를 벗어나거나, 이미 방문한 적이 있거나
                // 집이 없는 경우에는 건너 뛴다.
                if( nx > N || ny > N || nx < 1 || ny < 1 ) continue;
                if( adj[nx][ny] == 0 ) continue;
                if( visited[nx][ny] ) continue;

                // 방문한 적이 없는 집을 발견하면 큐에 nx, ny 를 삽입하고 cnt 를 증가시킨다.
                setQue(nx, ny, xQue, yQue);
                cnt++;
            }
        }
        return cnt;
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> cntArr = new ArrayList<>();
        int cnt;

        // 1,1 부터 행렬을 탐색하며 방문하지 않은 집을 발견하면 bfs 함수를 호출한다.
        // bfs 함수가 리턴되면 인접한 모든 점에 대해서는 탐색을 완료했다는 뜻이므로
        // 반환된 cnt 값을 리스트에 저장한다.
        // bfs 가 호출되는 횟수가 단지의 수를 의미한다.
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(adj[i][j] == 1 && !visited[i][j]) {
                    cnt = bfs(i, j);
                    cntArr.add(cnt);
                }
            }
        }
        sb.append(cntArr.size()).append('\n');
        Collections.sort(cntArr);
        for (int n : cntArr)
            sb.append(n).append('\n');
        System.out.println(sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        adj = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        // 인접행렬 초기화
        for(int i=1;i<=N;i++) {
            String digits = bf.readLine();
            for(int j=0;j<digits.length();j++) {
                adj[i][j+1] = digits.charAt(j) - '0';
            }
        }
    }
}
