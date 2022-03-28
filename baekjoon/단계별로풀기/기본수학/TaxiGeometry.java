import java.io.*;
/*
https://www.acmicpc.net/problem/3053
택시기하학
*/
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int r;
        final double pi = Math.PI;

        r = Integer.parseInt(bf.readLine());

        sb.append(r*r*pi).append("\n").append(r*r*2.0);
        System.out.println(sb);
    }
}
