/*
https://www.acmicpc.net/problem/2531
회전 초밥
3 일만에 문제를 풀었다.
문제를 틀린이유는 문제를 잘못이해했다.
내가 선택한 맨 앞에 있는 초밥, 맨 뒤에 있는 초밥이 쿠폰에 써있는 초밥일 때만
쿠폰을 쓸 수 있는 줄 알았다.
근데 그게 아니었다. 
그냥 쿠폰없이 먹은 최대 가짓 수 + 쿠폰으로 먹을 수 있는 가짓수 가 답이었다.
문제를 잘 보자
*/
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] A, D;
    static int N, d, k, c;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() {
        int R, cnt, max = -1, coupon;


        for(int L=0;L<N;L++) {
            R = L + 1;
            // coupon 으로 먹을 수 있는 초밥
            coupon = 1;
            cnt = 1;
            D[A[L]] = 1;

            while(R < L + k) {
                int X = A[R%N];
                
                // 만약 선택한 초밥이 c 라면 쿠폰으로 먹을 수 있는 초밥은 0 개
                if(X == c)
                    coupon = 0;

                // 지금까지 먹지 않았던 초밥을 먹는경우 가짓수를 의미하는 cnt 를 증가시키고
                // 중복을 기록하는 배열 D 값을 변경해준다.
                if(D[X] != 1) {
                    cnt ++;
                    D[X] = 1;
                }
                R++;
            }
            // 쿠폰으로 먹을 수 있는 초밥의 개수를 cnt 에 더해준다.
            cnt += coupon;

            max = Math.max(max, cnt);
            
            // 중복을 확인하는 배열 D 의 모든 원소를 0 으로
            Arrays.fill(D, 0);
        }
        System.out.println(max);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        A = new int[N];
        D = new int[d+1];

        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }

    }
}
