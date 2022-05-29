/*
https://www.acmicpc.net/problem/13752
히스토그램
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++) {
            int hist = Integer.parseInt(bf.readLine());

            for(int j=0;j<hist;j++) {
                sb.append("=");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}