/*
https://www.acmicpc.net/problem/2566
최댓값
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        solution();
    }

    private static void solution() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        MaxNumber mn = new MaxNumber(-1, 0, 0);

        for(int i=1;i<10;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<10;j++) {
                int x = Integer.parseInt(st.nextToken());
                if(mn.getNum() < x) {
                    mn.setNum(x);
                    mn.setPos(i, j);
                }
            }
        }
        System.out.println(mn.toString());
    }

    private static class MaxNumber {
        private int num;
        private int row;
        private int col;

        private MaxNumber(int num, int row, int col) {
            this.num = num;
            this.row = row;
            this.col = col;
        }

        private void setNum(int num) {
            this.num = num;
        }

        private void setPos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        private int getNum() {
            return num;
        }

        @Override
        public String toString() {
            return num + "\n" + row + " " + col;
        }
    }
}