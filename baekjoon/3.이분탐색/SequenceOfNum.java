/*
https://www.acmicpc.net/problem/2559
수열
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() throws IOException {
        int sum =0, R = 0, max = Integer.MIN_VALUE;

        // L + K - 1(K-1 일 이후의 온도까지 더해야하기 때문에)
        // 이 N 을 초과하지 않을 때 까지 L 을 증가시킨다.
        for(int L=1;L<=N+1-K;L++) {
            sum -= A[L-1];

            // R 이 K-1 일 이후의 온도를 가리킬 때 까지 sum 에 더한다.
            while(R <= L + K - 1) {
                sum += A[R];
                R++;
            }

            // 그 중 가장 큰 값을 max 에 저장
            if(sum > max) {
                max = sum;
            }
        }
        // 가장 큰 값을 출력
        System.out.println(max);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1];


        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}