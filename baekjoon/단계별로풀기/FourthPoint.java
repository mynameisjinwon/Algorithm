/*
https://www.acmicpc.net/problem/3009
네 번째 점
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] X, Y;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() {
        int xAns = 0, yAns = 0, xCnt = 0, yCnt = 0;

        for(int i=1;i<3;i++) {
            int x = X[i] - X[0];
            int y = Y[i] - Y[0];
            if(x != 0) {
                xAns = X[i];
                xCnt ++;
            }
            if(xCnt == 2) {
                xAns = X[0];
            }
            if(y != 0) {
                yAns = Y[i];
                yCnt ++;
            }
            if(yCnt == 2) {
                yAns = Y[0];
            }

        }
        System.out.println( xAns + " " + yAns);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        X = new int[3];
        Y = new int[3];

        for(int i=0;i<3;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
    }
}