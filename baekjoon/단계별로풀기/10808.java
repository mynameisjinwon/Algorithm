/*
https://www.acmicpc.net/problem/10808
알파벳 개수
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine();

        int[] alpha = new int[26];

        for(char c : input.toCharArray()) {
            int idx = c - 'a';
            alpha[idx]++;
        }
        for(int n : alpha) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}