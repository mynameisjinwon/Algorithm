/*
https://www.acmicpc.net/problem/10801
카드게임
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        solution();
    }

    private static void solution() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());

        int result = 0;
        for(int i=0;i<10;i++) {
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            if( a > b ) {
                result++;
            }else if( b > a ) {
                result--;
            }
        }
        String ans;
        if(result < 0) {
            ans = "B";
        } else if(result > 0) {
            ans = "A";
        } else {
            ans = "D";
        }
        System.out.println(ans);
    }
}