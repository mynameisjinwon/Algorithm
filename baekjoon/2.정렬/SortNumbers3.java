/*
https://www.acmicpc.net/problem/10989
수 정렬하기 3
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] A;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(bf.readLine());
        A = new int[N];

        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }
        
        Arrays.sort(A);

        for(int n : A)
            sb.append(n).append("\n");

        System.out.println(sb);
    }

}
