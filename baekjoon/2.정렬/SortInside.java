/*
https://www.acmicpc.net/problem/1427
소트인사이드
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static Integer[] A;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = bf.readLine();
        A = new Integer[num.length()];

        for(int i=0;i<A.length;i++)
            A[i] = Integer.parseInt(String.valueOf(num.charAt(i)));

        Arrays.sort(A, Collections.reverseOrder());

        for(int n : A)
            sb.append(n);

        System.out.println(sb);
    }
}
