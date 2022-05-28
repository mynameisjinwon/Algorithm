/*
https://www.acmicpc.net/problem/9325
얼마?
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        int s = 0, opt_cnt;

        for(int i=0;i<T;i++) {
            s = Integer.parseInt(bf.readLine());
            opt_cnt = Integer.parseInt(bf.readLine());

            while( opt_cnt > 0 ) {
                st = new StringTokenizer(bf.readLine());
                int cnt = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                s += cnt * price;
                opt_cnt--;
            }
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}