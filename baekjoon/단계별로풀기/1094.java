/*
https://www.acmicpc.net/problem/1094
막대기
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int cnt, X;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(bf.readLine());

        rec_func(64);

        System.out.println(cnt);
    }

    public static void rec_func(int x) {
        if(X < x) {
            rec_func(x/2);
        } else if(X > x) {
            X -= x;
            cnt++;
            if(X == 0) return;
            rec_func(x/2);
        } else {
            cnt++;
        }
    }
}