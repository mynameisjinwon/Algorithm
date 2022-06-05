/*
https://www.acmicpc.net/problem/2309
일곱 난쟁이
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static final int DWARF_CNT = 9;
    private static final int DWARF_ORG = 7;
    private static final int TOTAL_HEIGHT = 100;
    private static boolean[] used;
    private static int[] dwarf;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        dwarf = new int[DWARF_CNT];
        used = new boolean[DWARF_CNT];

        for(int i=0;i<DWARF_CNT;i++) {
            dwarf[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(dwarf);

        rec_func(0, 0);

        System.out.println(sb);
    }
    private static void rec_func(int k, int sum) {
        if(k == DWARF_ORG ) {
            if(sum == TOTAL_HEIGHT && sb.length() == 0) {
                makeAnswer();
            }
        } else {
            for(int i=0;i<DWARF_CNT;i++) {
                if(used[i]) continue;
                sum += dwarf[i];
                used[i] = true;
                rec_func(k+1, sum);
                sum -= dwarf[i];
                used[i] = false;
            }
        }
    }
    private static void makeAnswer() {
        for(int i=0;i<DWARF_CNT;i++)
            if(used[i]) sb.append(dwarf[i]).append("\n");

    }

}
