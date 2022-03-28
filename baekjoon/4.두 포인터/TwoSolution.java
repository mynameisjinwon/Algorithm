/*
https://www.acmicpc.net/problem/2470
두 용액
*/
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] A;
    static int N;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() {
        int L=0, R = N-1;
        int v1=0, v2=0, ans = 2000000001;

        Arrays.sort(A);

        while(L < R) {
            int sum = A[L] + A[R];
            if( Math.abs(sum) < ans ) {
                ans = Math.abs(sum);
                v1 = A[L];
                v2 = A[R];
            }

            if( sum > 0 ) {
                R--;
            } else {
                L++;
            }
        }
        System.out.println(v1 + " " + v2);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

    }
}
