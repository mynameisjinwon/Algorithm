/*
https://www.acmicpc.net/problem/11653
소인수분해
*/
import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        input();
        solution();
    }
    public static void solution() {
        if(N==1) 
            return;
        while(N>1) {
            for(int i=2;i<N+1;i++) {
                if(N%i==0) {
                    N/=i;
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

    }
}