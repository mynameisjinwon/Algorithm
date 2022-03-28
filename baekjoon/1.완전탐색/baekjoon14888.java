import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<String> opStack = new Stack<String>();
    static int[] nums, operators, order;
    static int N, max, min;

    static int calculator(int operand1, int operator, int operand2) {
            if(operator==1)
                return operand1 + operand2;
            else if(operator==2)
                return operand1 - operand2;
            else if(operator==3)
                return operand1 * operand2;
            else
                return operand1 / operand2;
    }
    static void rec_func(int k, int value) {
        if(k==N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for(int cand=1;cand<=4;cand++) {
                if(operators[cand]>=1) {
                    order[k] = cand;
                    operators[cand]--;
                    rec_func(k+1, calculator(value, cand, nums[k+1]));
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N+1];
        order = new int[N];
        operators = new int[5];

        for(int i=1;i<=N;i++)
            nums[i] = sc.nextInt();
        for(int i=1;i<5;i++)
            operators[i] = sc.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        rec_func(1, nums[1]);

        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }
}
