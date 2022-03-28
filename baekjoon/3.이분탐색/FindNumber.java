/*
https://www.acmicpc.net/problem/1920
수 찾기
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A, X;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static int binSearch(int x) {
        int l=0, r=N-1;

        while(l<=r) {
            int m = (l+r)/2;
            if(x>A[m]) {
                l = m + 1;
            } else if ( x<A[m]) {
                r = m - 1;
            } else
                return 1;
        }
        return 0;
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(A);

        for(int i=0;i<M;i++) {
            int isExist = binSearch(X[i]);
            sb.append(isExist).append("\n");
        }
        System.out.println(sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i=0;

        N = Integer.parseInt(bf.readLine());
        A = new int[N];
        st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()) {
            A[i++] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(bf.readLine());
        X = new int[M];
        st = new StringTokenizer(bf.readLine());
        i = 0;
        while(st.hasMoreTokens()) {
            X[i++] = Integer.parseInt(st.nextToken());
        }
    }
}