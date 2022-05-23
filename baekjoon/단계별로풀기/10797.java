/*
https://www.acmicpc.net/problem/10797
10부제
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int d = Integer.parseInt(bf.readLine()), cnt = 0;
        
        st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            if(d == x)    
                cnt ++;
        }
        System.out.println(cnt);
    }
}