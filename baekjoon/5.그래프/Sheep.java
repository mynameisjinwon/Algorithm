/*
https://www.acmicpc.net/problem/3184
양
*/
import java.io.*;
import java.util.*;

public class Main {

    static int R, C, sheep, wolf;
    static String[] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R];
        visited = new boolean[R][C];

        for(int r=0;r<R;r++) {
            map[r] = bf.readLine();
        }
    }
    public static void solution() {
        int svSheep = 0, svWolf = 0;

        for(int r=0;r<R;r++) {
            for(int c=0;c<C;c++) {
                sheep = 0;
                wolf = 0;
                if(map[r].charAt(c) != '#' && !visited[r][c]) {
                    dfs(r, c);
                    if(sheep <= wolf) svWolf += wolf;
                    else svSheep += sheep;
                }
            }
        }
        System.out.println(svSheep + " " + svWolf);

    }
    public static void dfs(int r, int c) {

        if(map[r].charAt(c) == 'o') sheep++;
        if(map[r].charAt(c) == 'v') wolf++;
        visited[r][c] = true;

        for(int d=0;d<dir.length;d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if( nr < 0 || nc < 0 || nr >= R || nc >= C ) continue;
            if( map[nr].charAt(nc) == '#' ) continue;
            if( visited[nr][nc] ) continue;

            visited[nr][nc] = true;
            dfs(nr, nc);
        }

    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
