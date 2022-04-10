/*
https://www.acmicpc.net/problem/1978
소수찾기
*/
import java.util.Scanner;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) {
        input();
        solution();
    }
    public static void solution() {
        boolean isPrime;
        int count = 0;

        for(int i=0;i<N;i++) {
            if(nums[i]==1)  continue;
            int num = nums[i];
            isPrime = true;
            for(int j=2;j<num;j++) {
                if(num % j == 0 )
                    isPrime = false;
            }
            if(isPrime)
                count++;
        }
        System.out.println(count);
    }
    public static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = sc.nextInt();
        }
    }
}