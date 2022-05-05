/*
https://www.acmicpc.net/problem/3046
R2
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int R1 = Integer.parseInt(st.nextToken()), R2 = 0;
        int S = Integer.parseInt(st.nextToken());
        
        R2 = 2 * S - R1;
        
        System.out.println(R2);
    }
}