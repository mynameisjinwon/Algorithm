/*
https://www.acmicpc.net/problem/2445
별 찍기 - 8
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int spaceCnt = N * 2 - 2, asteriskCnt = 1;

        for(int i=0;i<N*2-1;i++) {
            printAsterisk(asteriskCnt);
            printSpace(spaceCnt);
            printAsterisk(asteriskCnt);
            sb.append("\n");

            if(i < N - 1) {
                spaceCnt -= 2;
                asteriskCnt++;
            } else {
                spaceCnt += 2;
                asteriskCnt--;
            }
        }

        System.out.println(sb);
    }
    private static void printSpace(int spaceCnt) {
        for(int i=0;i<spaceCnt;i++) {
            sb.append(" ");
        }
    }
    private static void printAsterisk(int asteriskCnt) {
        for(int i=0;i<asteriskCnt;i++) {
            sb.append("*");
        }
    }
}