/*
https://www.acmicpc.net/problem/2512
예산
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static boolean determination(int x) {
        int total=0;

        for(int i=0;i<N;i++) {
            // 예산을 충당할 수 없으면 예산의 상한을 total 에 저장
            if(A[i] > x)
                total += x;
            // 충당할 수 있으면 요청 예산을 저장
            else
                total += A[i];
        }

        // 상한을 적용한 예산이 총 전체 예산보다 작거나 같으면 true 를 리턴
        return M >= total;
    }
    public static void solution() {
        int l=1, r=0, result=1;
        int sum=0, max=Integer.MIN_VALUE;

        // 배열을 탐색하며 요청 예산의 합과 최댓값을 구한다.
        for(int i=0;i<A.length;i++) {
            sum += A[i];
            if(A[i] > max)
                max = A[i];
        }
        // 요청예산의 합이 전체 예산보다 작거나 같으면 요청 예산의 최댓값을 배정한다.
        if(M >= sum) {
            result = max;
        // 그렇지 않으면 1 ~ 요청 예산의 최댓값 사이에 예산을 충당하는 정수를 찾는다.
        } else {
            r = max;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (determination(mid)) {
                    result = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(bf.readLine());
    }
}