/*
https://www.acmicpc.net/problem/16673
고려대학교에는 공식 와인이 있다
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ans = 0;
        while(C > 0) {
            ans += C * K + C * C * P;
            C--;
        }
        System.out.println(ans);
    }
}