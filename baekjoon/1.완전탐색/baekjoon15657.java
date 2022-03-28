import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] A, nums;
    static int N, M;

    static void rec_func(int k, int idx) {
        if(k==M+1) {
            for(int i=1;i<=M;i++) sb.append(nums[i]).append(' ');
            sb.append('\n');
        } else {
            for(int i=idx;i<=N;i++) {
                nums[k] = A[i];
                rec_func(k+1, i);
                nums[k] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N+1];
        nums = new int[N+1];

        for(int i=1; i<=N;i++) A[i] = sc.nextInt();
        Arrays.sort(A);

        rec_func(1, 1);

        System.out.println(sb.toString());
    }
}
