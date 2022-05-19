/*
https://www.acmicpc.net/problem/2845
파티가 끝나고 난 뒤
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb= new StringBuilder();
        
        int p = 1;
        for(int i=0;i<2;i++) 
            p *= Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(x - p).append(" ");
        }
           
        System.out.println(sb);
    }
}