/*
https://www.acmicpc.net/problem/2446
별 찍기 - 9
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int spaceCnt = 0, asteriskCnt = N * 2 - 1;

        for(int i=0;i<N*2-1;i++) {
            printSpace(spaceCnt);
            printAsterisk(asteriskCnt);
            if(i < N - 1) {
                spaceCnt++;
                asteriskCnt -= 2;
            } else {
                spaceCnt--;
                asteriskCnt += 2;
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
        sb.append("\n");
    }
}