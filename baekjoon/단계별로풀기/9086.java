/*
https://www.acmicpc.net/problem/9086
문자열
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(bf.readLine());
        
        for(int i=0;i<N;i++) {
            String str = bf.readLine();
            int len = str.length();
            sb.append(str.charAt(0)).append(str.charAt(len-1)).append("\n");
        }
        System.out.println(sb);
    }
}