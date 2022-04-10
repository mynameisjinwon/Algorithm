/*
https://www.acmicpc.net/problem/1085
직사각형에서 탈출
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int x, y, w, h;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() throws IOException {
        int xMin = Math.min(w - x, x);
        int yMin = Math.min(h - y, y);
        int ans = Math.min(xMin, yMin);

        System.out.println(ans);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
    }
}