/*
https://www.acmicpc.net/problem/14928
큰 수 (BIG)
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int divisor = 20000303;

        String dividend = bf.readLine();
        long remain = 0; 
        for(int i =0; i < dividend.length(); i++){ 
            remain = (remain * 10 + (dividend.charAt(i) - '0')) % divisor; 
        }
        System.out.println(remain);
    }
}