/*
https://www.acmicpc.net/problem/2163
초콜릿 자르기
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int c = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        while(c != 1) {
            c -= 1;
            cnt++;
        }
        
        System.out.println(cnt);
    }
}