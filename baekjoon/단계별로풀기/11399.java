/*
https://www.acmicpc.net/problem/11399
ATM
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[] P = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        int sum = 0;
        for(int i=0;i<N;i++) {
            sum += P[i] * (N-i);
        }

        System.out.println(sum);
    }
}