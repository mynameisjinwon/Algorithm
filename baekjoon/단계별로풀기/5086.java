/*
https://www.acmicpc.net/problem/5086
배수와 약수
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        final String factor = "factor";
        final String multiple = "multiple";
        final String neither = "neither";

        while(true) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if( x == 0 && y == 0 ) break;

            if( y % x == 0 ) sb.append(factor);
            else if( x % y == 0 ) sb.append(multiple);
            else sb.append(neither);

            sb.append("\n");
        }
        System.out.println(sb);
    }
}