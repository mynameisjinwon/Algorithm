/*
https://www.acmicpc.net/problem/4999
아!
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String j = bf.readLine();
        String d = bf.readLine();
        
        if(j.length() >= d.length()) sb.append("go");
        else sb.append("no");
        
        System.out.println(sb);
    }
}