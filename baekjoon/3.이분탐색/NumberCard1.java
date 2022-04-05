/*
https://www.acmicpc.net/problem/10815
숫자 카드
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] A , B;
    static int N, M;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(bf.readLine());
        A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(bf.readLine());
        B = new int[M];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++) {
            int exist = 0;
            exist = binSearch(B[i]);
            sb.append(exist).append(" ");
        }
        System.out.println(sb);
    }
    public static int binSearch(int x) {
        int l = 0, r = N-1, exist = 0;
        while(l <= r) {
            int m = (l+r) / 2;
            if(x > A[m]) {
                l = m + 1;
            } else if(x < A[m]) {
                r = m - 1;
            } else {
                exist = 1;
                break;
            }
        }
        return exist;
    }
}
