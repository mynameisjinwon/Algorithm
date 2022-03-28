/*
https://www.acmicpc.net/problem/1929
소수 구하기
N의 최대값이 1000000이라서 N^2 으로 풀면 시간 초과가 발생한다.
에라토스테네스의 체 알고리즘을 사용했다.

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();
        A = new int[1000001];
        A[1] = 1; // 1 은 소수가 아니다.

        //에라토스테네스의 체 알고리즘을 사용해 소수가 아닌 인덱스에는 1을 넣는다.
        //알고리즘을 제대로 구현했는지는 모르겠다.
        for(int i=2;i<N+1;i++) {
            // i 가 합성수일 때 continue;
            if(A[i]==1) continue;

            // i 가 소수이면서 M 보다 크면 sb에 append
            if(i >= M)
                sb.append(i).append("\n");

            // 합성수는 제외
            for(int j=i+i;j<=N;j+=i) {
                A[j] = 1;
            }
        }
        //출력
        System.out.println(sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
    }
}