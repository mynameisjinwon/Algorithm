/*
https://www.acmicpc.net/problem/2558
A+B-2
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(bf.readLine());
        int B = Integer.parseInt(bf.readLine());

        int sum = A + B;
        
        System.out.println(sum);
    }
}