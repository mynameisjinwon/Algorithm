import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    //nums는 입력받은 수열 sequence는 N개 중 M개를 고른 수열
    //used는 숫자의 사용여부를 기록하는 배열
    static int[] nums, sequence, used;
    static int N, M;

    static void rec_func(int k) {
        //M개의 수를 다 골랐으면
        if(k==M+1) {
            //sb에 문자열 추가
            for(int i=1;i<=M;i++) sb.append(sequence[i]).append(' ');
            sb.append('\n');
        //아직 고를 수가 남아있으면
        } else {
            for(int i=1;i<=N;i++) {
                //nums 특정 인덱스를 이미 사용했다는 것을 기록하면
                //다음엔 사용하지 않는다.
                if(used[i]==1) continue;
                sequence[k] = nums[i];
                used[i] = 1;
                rec_func(k+1);
                used[i] = 0;
                sequence[k] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N+1];
        used = new int[N+1];
        sequence = new int[M+1];

        for(int i=1; i<=N;i++) nums[i] = sc.nextInt();
        Arrays.sort(nums);
        rec_func(1);

        System.out.println(sb.toString());
    }
}
