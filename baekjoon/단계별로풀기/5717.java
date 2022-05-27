/*
https://www.acmicpc.net/problem/5717
상근이의 친구들
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            
            if( m == 0 && f == 0 ) break;
            
            sb.append(m + f).append("\n");
        }
        System.out.println(sb);
    }
}