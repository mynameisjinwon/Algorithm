/*
https://www.acmicpc.net/problem/1182
부분수열의 합
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, S, cnt;
    public static int[] num;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        
        // 길이가 1 ~ N 인 부분수열을 확인한다. 
        for(int i=1;i<N+1;i++) {
            rec_func(i, 0, 0, 0);
        }
        System.out.println(cnt);
    }
    // len 은 부분수열의 길이, k 는 현재 뽑은 수의 개수, sum 은 현재 뽑은 부분수열의 모든 수의 합
    // start 는 직전에 선택한 인덱스 + 1 
    public static void rec_func(int len ,int k, int sum, int start) {
        if(k == len) {
            // 부분수열의 합이 S 이면 cnt 를 증가시킨다.
            if(sum == S) cnt ++;
        } else {
            // 직전에 뽑은 수의 다음 수를 선택하고 sum 에 더한 뒤 재귀호출을 한다.
            for(int i=start;i<N;i++) {
                sum += num[i];
                rec_func(len, k+1, sum, i+1);
                sum -= num[i];
            }
        }
    }
}