/*
https://www.acmicpc.net/problem/2490
윷놀이
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static final int PLAY_CNT = 3;
    private static final char[] YUT = { 'E', 'A', 'B', 'C', 'D'};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<PLAY_CNT;i++) {
            int cnt = 0;
            st = new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 0) cnt ++;
            }
            sb.append(YUT[cnt]).append("\n");
        }
        System.out.println(sb);
    }
}