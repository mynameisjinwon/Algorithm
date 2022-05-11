/*
https://www.acmicpc.net/problem/2902
KMP는 왜 KMP일까?
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final String DELIMITER = "-";

    public static void main(String[] args) throws Exception {
        solution();
    }

    private static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        String[] strArr = input();

        for(String s : strArr) {
            sb.append(s.charAt(0));
        }
        System.out.println(sb);
    }

    private static String[] input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        return bf.readLine().split(DELIMITER);
    }
}