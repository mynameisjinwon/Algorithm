/*
https://www.acmicpc.net/problem/2920
음계
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        boolean isAsc = false, isDes = false;

        int prev = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());
            if( prev - cur < 0) {
                isAsc = true;
            } else {
                isDes = true;
            }
            prev = cur;
        }
        if( isAsc && isDes ) {
            System.out.println("mixed");
        } else if( isAsc ) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}