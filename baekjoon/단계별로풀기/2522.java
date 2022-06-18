/*
https://www.acmicpc.net/problem/2522
별 찍기 - 12
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
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
        int asteriskCnt = 1, spaceCnt = N-1;
        for(int i=0;i<N*2-1;i++) {
            printSpace(spaceCnt);
            printAsterisk(asteriskCnt);
            if(i < N -1) {
                spaceCnt--;
                asteriskCnt++;
            } else {
                spaceCnt++;
                asteriskCnt--;
            }
        }
    }
    private static void printSpace(int spaceCnt) {
        for(int i=0;i<spaceCnt;i++) {
            sb.append(" ");
        }
    }
    private static void printAsterisk(int asteriskCnt) {
        for(int i=0;i<asteriskCnt;i++) {
            sb.append("*");
        }
        sb.append("\n");
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