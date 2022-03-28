/*
https://www.acmicpc.net/problem/1644
소수의 연속합
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, primeCnt = 0;
    static int[] isPrime, primes;

    public static void main(String[] args) throws IOException {
        input();
        findPrime();
        solution();
    }
    public static void findPrime() {

        for(int i=2;i<isPrime.length;i++) {
            if(isPrime[i]==1) continue;
            primes[primeCnt++] = i;

            for(int j=i+i;j<isPrime.length;j+=i) {
                isPrime[j] = 1;
            }
        }
    }
    public static void solution() {
        int sum = 0, cnt = 0, R = 0;

        // primCnt 는 N 이하의 소수의 개수 + 1
        // primes 는 N 이하의 소수가 저장된 배열
        for(int L=0;L<primeCnt;L++) {
            if(L!=0) {
                sum -= primes[L-1];
            }
            // 마지막 소수까지 sum 에 더해야하기 때문에 R+1 이 primeCnt 와 같을 때까지 증가할 수 있어야한다.
            while(R+1 <= primeCnt && sum < N) {
                sum += primes[R];
                R++;
            }
            if(sum == N ) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        isPrime = new int[N+1];
        primes = new int[N+1];
    }
}