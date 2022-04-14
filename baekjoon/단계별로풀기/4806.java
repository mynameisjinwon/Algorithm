/*
https://www.acmicpc.net/problem/4806
줄 세기
*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        while(sc.hasNextLine()) {
            sc.nextLine();
            cnt++;
        }

        System.out.println(cnt);
    }
}