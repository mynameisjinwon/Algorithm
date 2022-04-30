/*
https://www.acmicpc.net/problem/11721
열 개씩 끊어 출력하기
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word = bf.readLine();

        for(int i=1;i<word.length()+1;i++) {
            sb.append(word.charAt(i-1));
            if(i % 10 == 0) {
                sb.append('\n');
            }
        }
        System.out.println(sb);

    }
}