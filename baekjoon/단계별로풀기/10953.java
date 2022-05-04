/*
https://www.acmicpc.net/problem/10953
A+B - 6
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());

        IntegerParser ip = null;


        for(int i=0;i<N;i++) {
            AddNum an = new AddNum();
            ip = new IntegerParser(bf.readLine());
            an.setNum(ip.parseInt());
            sb.append(an.getSum()).append('\n');
        }
        System.out.println(sb);
    }
    private static class IntegerParser {
        private final String DELIMITER = ",";
        private final int NUM_COUNT = 2;
        private final String nums;

        private IntegerParser(String nums) {
            this.nums = nums;
        }

        private int[] parseInt() {
            int[] num = new int[NUM_COUNT];

            for(int i=0;i<NUM_COUNT;i++) {
                num[i] = Integer.parseInt(nums.split(DELIMITER)[i]);
            }
            return num;
        }
    }
    private static class AddNum {
        private final int NUM_COUNT = 2;
        private int[] num;
        private int sum;

        private AddNum() {
            num = new int[NUM_COUNT];
        }

        private void setNum(int[] num) {
            this.num = num;
        }

        private void add() {
            for(int n : num) {
                sum += n;
            }
        }

        private int getSum() {
            this.add();
            return sum;
        }

    }
}