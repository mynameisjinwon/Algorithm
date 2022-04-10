/*
https://www.acmicpc.net/problem/4153
직각삼각형
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] A = new int[3];
        int a, b, c, max, min, sum;

        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(bf.readLine());

            sum = 0;
            max = -1;
            min = 30001;
            for(int i=0;i<3;i++) {
                A[i] = Integer.parseInt(st.nextToken());
                if(A[i] > max)
                    max = A[i];
                if(A[i] < min)
                    min = A[i];
                sum += A[i];
            }
            if( sum == 0 )
                break;

            a = min;
            b = sum - max - min;
            c = max;

            if( a*a + b*b == c*c)
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}