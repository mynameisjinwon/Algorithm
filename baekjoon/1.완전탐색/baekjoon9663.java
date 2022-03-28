import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<String> opStack = new Stack<String>();
    static int[] cols;
    static int N, count;

    static boolean attackable(int c1, int r1, int c2, int r2) {
        if(c1 == c2) return true;
        if(c1+r1 == c2+r2) return true;
        if(c1-r1 == c2-r2) return true;
        else return false;
    }
    static void rec_func(int row) {
        if(row==N+1) {
            count++;
        } else {
            for(int c=1;c<=N;c++) {
                boolean possible = true;
                for(int i=1; i<row;i++) {
                    if(attackable(c, row, cols[i], i)) {
                        possible = false;
                        break;
                    }
                }
                if(possible) {
                    cols[row] = c;
                    rec_func(row + 1);
                    cols[row] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cols = new int[N+1];

        rec_func(1);
        System.out.println(count);
    }
}
