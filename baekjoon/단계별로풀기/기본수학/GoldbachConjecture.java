/*
https://www.acmicpc.net/problem/9020
골드바흐의 추측
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] isPrime = new boolean[10001];
    static int[] A, prime = new int[10001];
    static int T, n;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    // 소수 배열을 만드는 메소드
    public static int setPrime() {
        int idx = 1;
        for(int i=2;i<isPrime.length;i++) {
            // boolean 배열을 초기화하지않으면 모두 false;
            if(!isPrime[i]) {
                prime[idx++] = i;
                for(int j=i+i;j<isPrime.length;j+=i) {
                    isPrime[j] = true;
                }
            }
        }
        return idx;
    }
    // n 보다 작은 소수 중 제일 큰 소수의 인덱스를 리턴하는 메소드
    public static int findIndex(int n, int size) {
        int l = 1, r = size-1;
        int idx = -1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(prime[mid] < n) {
                idx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return idx;
    }
    public static void findBestPair(int idx, int n) {
        int p1=Integer.MIN_VALUE/2, p2=Integer.MAX_VALUE/2;
        int diff = p2 - p1;
        for(int i=idx;i>0;i--) {
            for(int j=i;j>0;j--) {
                if(((prime[i]+prime[j]) == n) && Math.abs(diff) > Math.abs(prime[i] - prime[j])) {
                    p1 = prime[j];
                    p2 = prime[i];
                    diff = p2 - p1;
                }
            }
        }
        sb.append(p1 + " " + p2 + "\n");
    }
    public static void solution() {
        int idx;
        int size = setPrime();

        for(int i=0;i<A.length;i++) {
            int n = A[i];
            idx = findIndex(n, size);
            findBestPair(idx, n);
        }
        System.out.println(sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());
        A = new int[T];

        for(int i=0;i<T;i++) {
            A[i] =  Integer.parseInt(bf.readLine());
        }
    }
}