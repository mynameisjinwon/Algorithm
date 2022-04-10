/*
https://www.acmicpc.net/problem/4948
베르트랑 공준
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> nums = new ArrayList<>();
    static int[] A = new int[246913];
    static int N;

    public static void main(String[] args) {
        input();
        solution();
    }
    public static int countPrime(int n) {

        int cnt = 0;

        for(int i=2;i<=2*n;i++) {
            //i 가 합성수이면 continue;
            if(A[i]==1) continue;

            //n 과 2n 사이에있는 소수이면 cnt 를 증가
            if(i>n)
                cnt++;
            // 합성수는 지운다.
            for(int j=i+i;j<=2*n;j+=i) {
                A[j] = 1;
            }
        }
        return cnt;
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        //입력받은 배열의 원소를 하나씩 꺼내 countPrime 메소드를 호출한다.
        for(int num : nums) {
            cnt = countPrime(num);
            sb.append(cnt).append("\n");
        }
        //출력
        System.out.println(sb);
    }
    public static void input() {
        Scanner sc = new Scanner(System.in);
        int num = 1;

        while(num!=0) {
            num = sc.nextInt();
            nums.add(num);
        }
        nums.remove(nums.size()-1);
    }
}