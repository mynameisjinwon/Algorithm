import java.util.*;

public class baekjoon6603 {
    static StringBuilder sb = new StringBuilder();
    //S는 수의 집합, lotto는 S에서 고른 수
    static int[] S, lotto;
    static int N;

    static void rec_func(int k, int idx) {
        //6개의 숫자를 다 골랐으면
        if(k==7) {
            //sb에 문자열 추가
            for(int i=1;i<=6;i++) sb.append(lotto[i]).append(' ');
            sb.append('\n');
        //아직 고를 수가 남아있으면
        } else {
            //직전에 사용한 인덱스+1을 받아
            //직전에 선택한 수보다 뒤쪽에있는 수부터 탐색한다.
            for(int i=idx;i<=N;i++) {
                lotto[k] = S[i];
                rec_func(k+1, i+1);
                lotto[k] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lotto = new int[7];

        while(true) {
            N = sc.nextInt();
            if(N==0) break;

            S = new int[N+1];

            for(int i=1; i<=N;i++) S[i] = sc.nextInt();
            rec_func(1, 1);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
