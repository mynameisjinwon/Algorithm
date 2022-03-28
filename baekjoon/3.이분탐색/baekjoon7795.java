/*
https://www.acmicpc.net/submit/7795/39595762
이분 탐색 문제 
먹을 것인가 먹힐 것인가
*/
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int T, N, M;
    static int[] A, B;

    public static void main(String[] args) {
        Main main = new Main();

        main.input();
    }
    public void solution() {
        int result, total = 0 ;
        int l, r;
        int mid = 0;

        for(int i=1;i<N+1;i++) {
            l = 1;
            r = M;
            result = l - 1;
            
            while(l <= r) {
                mid = (l + r) / 2;
                if (A[i] > B[mid]) {
                    l = mid + 1;
                    result = mid;
                } else if(A[i] <= B[mid]) {
                    r = mid - 1;
                } 
            }
            total += result;
        }
        System.out.println(total);
    }
    public void input() {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int i=0;i<T;i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            A = new int[N+1];
            B = new int[M+1];
            for(int j=1;j<N+1;j++) {
                A[j] = sc.nextInt();
            }
            for(int j=1;j<M+1;j++) {
                B[j] = sc.nextInt();
            }
            Arrays.sort(B, 1, M+1);
            solution();
        }

    }
}
