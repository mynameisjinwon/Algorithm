/*
https://www.acmicpc.net/problem/11052
카드 구매하기
반례 :
10
1 100 160 1 1 1 1 1 1 1
답 520;
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[] Dy, price;
    private static int N;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        Dy[1] = price[1];
        
        for(int i=2;i<=N;i++) {
            for(int j=1;j<=i;j++) {
                Dy[i] = Math.max(Dy[i], price[j] + Dy[i-j]);
            }
        }

        sb.append(Dy[N]);
    }
    private static void input() {
        N = scan.nextInt();
        price = new int[N+1];
        Dy = new int[N+1];

        for(int i=1;i<=N;i++) {
            price[i] = scan.nextInt();
        }
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
