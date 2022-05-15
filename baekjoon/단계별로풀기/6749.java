/*
https://www.acmicpc.net/problem/6749
Next in line
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int y = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        
        int o = m + (m - y);
        
        System.out.println(o);
    }
}