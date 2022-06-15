/*
https://www.acmicpc.net/problem/9095
1, 2, 3 더하기
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
    private static final int MAX_VALUE = 11;
   
    public static void main(String[] args) {
        preprocess();
        int T = scan.nextInt();

        while(T-- > 0) {
            input();
            solution();
        }
        printResult();
    }
    // 테스트케이스를 입력받기 전에 Dy 배열을 채워넣는다.
    private static void preprocess() {
        Dy = new int[MAX_VALUE];
        // 초기값을 설정한다.
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;
	
        // 점화식을 이용해 범위안에 있는 모든 수에대한 정답을 Dy배열에 저장한다.
        for(int i=4;i<Dy.length;i++) {
            Dy[i] = Dy[i-1] + Dy[i-2] + Dy[i-3];
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
