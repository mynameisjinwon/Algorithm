/*
https://www.acmicpc.net/problem/11057
오르막 수
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[][] Dy;
    private static int[] D;
    private static int N;
    private static final int DECIMAL = 10, MOD = 10007;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        // 초기값 설정
        // Dy[1][i] : 길이가 1인 수가 i 로 끝나는 수의 개수 0 ~ 9 각 1개
        // D[1] : 길이가 1인 수의 개수 0 ~ 9 총 10개
        for(int i=0;i<DECIMAL;i++) {
            Dy[1][i] = 1;
            D[1] += Dy[1][i];
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < DECIMAL; j++) {
                for (int k = j; k < DECIMAL; k++) {
                    // Dy[i][j] : 10^(i-1)의 자리가 j 인 수의 개수다.
                    // 이는 10^(i-2)의 자리가 j 인 수 부터 9인 수 까지의 합으로 구할 수 있다.
                    // Dy[2][1] : 십의자리가 1인 오르막 수의 개수 (11 ~ 19) 9 개
                    // 십의자리가 1인 수의 개수 : 일의 자리가 1인 수의 개수 + 2인 수의 개수 + ... + 9인 수의 개수
                    
                    //개수의 합이 int 범위를 넘기지 않도록 10007으로 나눈 나머지를 저장한다.
                    Dy[i][j] += Dy[i-1][k] % MOD;
                }
                // D[i] : 길이가 i인 오르막 수의 개수
                // D[2] : 길이가 2인 오르막 수의 개수 11 ~ 19, 22 ~ 29 ...(D[2]) 총 45개
                D[i] += Dy[i][j];
            }
            // (A % C) + (B % C) != (A + B) % C 
            // {(A % C) + (B % C)} % C == (A + B) % C 
            D[i] %= MOD;
        }

        
        sb.append(D[N]);
    }
    private static void input() {
        N = scan.nextInt();
        Dy = new int[N+1][DECIMAL];
        D = new int[N+1];
    }
    private static class MyReader {
        BufferedReader bf;
        StringTokenizer st;

        private MyReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while( st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String str = "";
            try {
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}