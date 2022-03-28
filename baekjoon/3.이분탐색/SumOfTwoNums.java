/*
https://www.acmicpc.net/problem/3273
두 수의 합
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static boolean binSearch(int x, int l, int r) {

        while(l<=r) {
            int m = (l+r)/2;
            if(x>A[m]) {
                l = m + 1;
            } else if ( x<A[m]) {
                r = m - 1;
            } else
                return true;
        }
        return false;
    }
    public static void solution() {
        int cnt = 0;
        Arrays.sort(A);

        for(int i=0;i<A.length-1;i++) {
            int x = X - A[i];
            if(binSearch(x, i+1, A.length-1)) {
                cnt++;
            }
        }
        System.out.println(cnt);
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
        X = Integer.parseInt(bf.readLine());
    }
}