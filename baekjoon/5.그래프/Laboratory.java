/*
https://www.acmicpc.net/problem/14502
연구소
*/
import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_WALL_CNT = 3;
    static int N, M, maxZeroCnt = -1, wallCnt;
    static int[][] lab, dir = {{0, -1},{0, 1},{-1, 0},{1, 0}};
    static boolean[][] wall, visited;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static int bfs(int x, int y) {
        Queue<Integer> xQ = new LinkedList<>();
        Queue<Integer> yQ = new LinkedList<>();
        int virusCnt = 1;

        // 바이러스가 처음 발견된 좌표를 큐에삽입하고, 방문했다는 표시를 해준다.
        xQ.add(x);
        yQ.add(y);
        visited[x][y] = true;

        while(!xQ.isEmpty() & !yQ.isEmpty()) {
            x = xQ.poll();
            y = yQ.poll();

            // 상, 하, 좌, 우로 한칸 씩 이동할 수있도록 dir 배열의 값과 현재 x, y의 값을 더해 nx, ny를 구해준다.
            for(int d=0;d<dir.length;d++) {
                int nx = x + dir[d][0], ny = y + dir[d][1];
                // nx, ny 가 연구소 범위를 벗어나거나, 방문을 했던 좌표이거나, 벽이 있으면 건너뛴다.
                if( nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
                if( visited[nx][ny] ) continue;
                if( lab[nx][ny] == 1 ) continue;

                // 연구소 영역을 탐색하면서 바이러스가 있고 바이러스와 인접한 좌표에
                // 0 이 있으면 바이러스가 확산 될 수 있다.
                // 해당 좌표에 2 나 0 이 있으면 virusCnt 를 증가시킨다.
                xQ.add(nx);
                yQ.add(ny);
                visited[nx][ny] = true;
                virusCnt++;
            }
        }
        return virusCnt;
    }
    // 완전 탐색으로 벽 세개를 세운다.
    public static void setWall(int k) {
        // 벽 세개를 다 세웠으면
        if(k==MAX_WALL_CNT+1) {
            int virusCnt = 0;

            // bfs 를 통해 바이러스의 최대 수를 구한다.
            // 바이러스가 존재하는 좌표를 인자로 전달한다.
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(lab[i][j] == 2 && !visited[i][j]) {
                        virusCnt += bfs(i, j);
		// 처음 제출할때 여기에서 break; 를 해서 틀렸다.
		// 모든 2에대해서 탐색을 해야되기 때문에 break를 하면안되는데
		// 실행시간을 조금이라도 줄이고싶은마음에 break를 추가했더니 틀렸다.
                    }
                }
            }
            // 안전 영역의 수는 전체 연구소 영역에서 벽의 개수, 퍼진 바이러스의 개수를 빼서 구한다.
            // 최대가 되는 안전 영역의 수를 maxZeroCnt 에 저장한다.
            int zeroCnt = N * M - wallCnt - virusCnt;
            maxZeroCnt = Math.max(zeroCnt, maxZeroCnt);

            // 안전 영역의 수를 세고 방문했던 영역을 표시하는 배열인 visited 배열을 초기화해준다.
            // setWall 메소드의 실행이 끝나면 또 다른 벽을 세우는 경우의 새로운 연구소의 영역이 들어오기 때문에
            // 새로운 연구소의 영역에 대해 탐색하기 위해 초기화해주는 것이다.
            for(int i=0;i<N;i++)
                for(int j=0;j<M;j++)
                    visited[i][j] = false;
        } else {
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(lab[i][j]==1 || lab[i][j]==2) continue;
                    if(wall[i][j]) continue;
                    lab[i][j] = 1;
                    wall[i][j] = true;
                    setWall(k+1);
                    lab[i][j] = 0;
                    wall[i][j] = false;
                }
            }
        }
    }
    public static void solution() {
        // 현재 연구소의 벽의 개수와 새로 세울 수 있는 최대 벽의 개수를 더한다.
        wallCnt += MAX_WALL_CNT;
        setWall(1);
        System.out.println(maxZeroCnt);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        wall = new boolean[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                int x = Integer.parseInt(st.nextToken());
                lab[i][j] = x;
                if( x == 1 ) {
                    wallCnt++;
                }
            }
        }
    }
}
