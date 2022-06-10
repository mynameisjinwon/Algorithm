/*
https://www.acmicpc.net/submit/2523/44399023
별찍기 - 13
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int asteriskCnt = 1;

        for(int i=0;i<N*2-1;i++) {
            printAsterisk(asteriskCnt);
            if(i < N - 1)
                asteriskCnt++;
            else
                asteriskCnt--;
        }

        System.out.println(sb);
    }
    private static void printAsterisk(int asteriskCnt) {
        for(int i=0;i<asteriskCnt;i++) {
            sb.append("*");
        }
        sb.append("\n");
    }
}
