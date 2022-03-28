/*
https://www.acmicpc.net/problem/2003
수들의 합 2
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() {
        int sum = 0, cnt = 0, R = 0;

        for(int L=1;L<N+1;L++) {
            // L = 1 일 때, sum 의 값이 M 보다 크거나 같을 때
            // sum 에서 가장 먼저 저장한 원소의 값을 뺀다. 
            // sum 의 값이 M 보다 클 때 L 의 값을 증가 시키면(가장 먼저 저장된 원소를 빼면) 
            // 그 값이 이전의 sum 값 보다 커질 수 없다.
            sum -= A[L-1];
            
            // sum 의 값이 M 보다 작다면 크거나 같아질 때 까지 A[R] 을 더한다. 
            while( R + 1 <= N && sum < M) {
                R++;
                sum += A[R];
            }
            // 조건을 만족하는 부분수열의 합을 찾으면 cnt 값을 증가시킨다.
            if(sum == M) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1];

        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}