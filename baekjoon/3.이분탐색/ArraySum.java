/*
https://www.acmicpc.net/problem/11728
배열 합치기
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() {
        // 새로운 배열을 생성하는 것은 반복이 추가되어 오래걸릴 것 같아서 
        // 스트링 빌더에 담아서 마지막에 한번에 출력하도록 만들었다.
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 0;

        // A, B 의 인덱스 범위를 초과하지 않는 한에서 
        // A 와 B 의 값을 비교해 작은 것을 먼저 string builder 에 담는다.
        while(a < N && b < M ) {
            if(A[a] < B[b]) {
                sb.append(A[a++]).append(" ");
            } else {
                sb.append(B[b++]).append(" ");
            }
        }
        // b 가 M 과 같으면 B 의 원소들은 모두 처리가 된 것이다.
        // 남은 A 의 원소들을 담는다.
        if(b == M) {
            while( a < N ) {
                sb.append(A[a++]).append(" ");
            }
        } else {
            while( b < M ) {
                sb.append(B[b++]).append(" ");
            }
        }
        System.out.println(sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }
}