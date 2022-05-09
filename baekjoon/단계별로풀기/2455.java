/*
https://www.acmicpc.net/problem/2455
지능형 기차
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = -1, total = 0, N = 4;
        int[] in = new int[N], out = new int[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            out[i] = Integer.parseInt(st.nextToken());
            in[i] = Integer.parseInt(st.nextToken());

            total += in[i] - out[i];
            if(total > max) {
                max = total;
            }
        }
        System.out.println(max);
    }
}