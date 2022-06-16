/*
https://www.acmicpc.net/problem/15988
1, 2, 3 더하기 3
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[] Dy;
    private static int N;
    private static final int MAX_VALUE = 1000001;

    public static void main(String[] args) {
        preprocess();
        int T = scan.nextInt();

        while(T-- > 0) {
            input();
            solution();
        }
        printResult();
    }

    private static void preprocess() {
        Dy = new int[MAX_VALUE];
        // 초기값을 설정한다.
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        //Dy[i] 에는 1000000009 으로 나눈 나머지가 저장되기 때문에 int 변수로 다룰 수 있다.
        //3개의 int 변수의 합이 int 의 범위를 초과할 수 있기 때문에 덧셈의 결과를 long 타입으로 형변환 한뒤에
        //이를 다시 int 로 변환했다.
        //근데 그냥 long 으로 선언하면 될것 같다
        for(int i=4;i<MAX_VALUE;i++) {
            Dy[i] = (int)( ((long)Dy[i-1] + Dy[i-2] + Dy[i-3]) % 1000000009 );
        }

    }
    private static void printResult() {
        System.out.println(sb);
    }
    private static void solution() {
        sb.append(Dy[N]).append("\n");
    }
    private static void input() {
        N = scan.nextInt();
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