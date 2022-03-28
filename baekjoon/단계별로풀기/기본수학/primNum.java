/*
https://www.acmicpc.net/problem/2581
소수
*/
import java.util.Scanner;

public class Main {
    static int N, M;

    public static void main(String[] args) {
        input();
        solution();
    }
    public static void solution() {
        boolean isPrime;
        int sum = 0;
        int min = 10001;


       if(N != 2 && N%2==0)
            N+=1;
        while(N <= M) {
            if(N==1) {
                N++;
                continue;
            } else if(N==2) {
                sum += N;
                min = N;
                N++;
                continue;
            }
            isPrime = true;
            for(int j=2;j<N;j++) {
                if(N%j==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                sum += N;
                min = Math.min(min, N);
            }
            N+=2;
        }
        if(min == 10001)
            System.out.println(-1);
        else
            System.out.println(sum + "\n" + min);
    }
    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
    }
}