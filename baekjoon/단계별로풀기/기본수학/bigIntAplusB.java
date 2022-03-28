/*
https://www.acmicpc.net/problem/10757
큰 수 A+B
*/
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static String str1, str2;

    public static void main(String[] args) {
        input();
        solution();
    }
    public static void solution() {
        BigInteger bigInt1 = new BigInteger(str1);
        BigInteger bigInt2 = new BigInteger(str2);

        System.out.println(bigInt1.add(bigInt2));
    }
    public static void input() {
        Scanner sc = new Scanner(System.in);

        str1 = sc.next();
        str2 = sc.next();
    }
}