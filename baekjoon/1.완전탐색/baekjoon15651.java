/*
백준 15649 백트래킹
문제 : 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
        1부터 N까지 자연수 중에서 M개를 고른 수열
        같은 수를 여러 번 골라도 된다.

입력 : 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

 */
import java.util.*;

class baekjun15651 {
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] selected;

    static void rec_func(int k) {
        if(k==M+1) {
            for (int i = 1; i <= M; i++)
                sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                selected[k] = i;
                rec_func(k + 1);
            }
        }
    }
    public static void main(String[] args) {
        int k = 1;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];

        rec_func(k);
        System.out.println(sb.toString());
    }
}
