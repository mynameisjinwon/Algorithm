/*
https://www.acmicpc.net/problem/1100
하얀 칸
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int ROW = 8, COL = 8, cnt = 0;

        for(int i=0;i<ROW;i++) {
            String input = bf.readLine();
            for(int j=0;j<COL;j++) {
                if(i % 2 == 0 && j % 2 == 0 && input.charAt(j) == 'F') cnt++;
                if(i % 2 != 0 && j % 2 != 0 && input.charAt(j) == 'F') cnt++;
            }
        }

        System.out.println(cnt);
    }
}