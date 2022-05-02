/*
https://www.acmicpc.net/problem/2442
별 찍기
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        int max = N * 2 - 1;

        for(int i=1;i<=N;i++) {
            int asterisk = i * 2 - 1;
            int space = (max - asterisk) / 2;
            printSpace(sb, space);
            printAsterisk(sb, asterisk);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void printSpace(StringBuilder sb, int space) {
        for(int i=0;i<space;i++) {
            sb.append(' ');
        }
    }

    public static void printAsterisk(StringBuilder sb, int asterisk) {
        for(int i=0;i<asterisk;i++) {
            sb.append('*');
        }
    }
}