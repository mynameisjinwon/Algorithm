/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    - 고른 수열은 오름차순이어야 한다.
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 */
import java.util.Scanner;

public class baekjun15650 {
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] selected, isUsed;

    static void rec_func(int k) {
        if(k==M+1) {
            for (int i = 1; i <= M; i++)
                sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                if(isUsed[i]==1|| selected[k-1]>i)
                    continue;
                selected[k] = i;
                isUsed[i] = 1;
                rec_func(k + 1);
                isUsed[i] = 0;
                selected[k] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int k = 1;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];
        isUsed = new int[N+1];

        rec_func(k);
        System.out.println(sb.toString());
    }
}

