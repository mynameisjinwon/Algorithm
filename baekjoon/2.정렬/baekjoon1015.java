import java.util.*;

class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int[] A, B, P, used;
    public static int N;

    public static void input() {
        N = sc.nextInt();
        A = new int[N];
        B = new int[N];
        P = new int[N];
        used = new int[N];

        for(int i=0;i<N;i++) {
            A[i] = sc.nextInt();
            B[i] = A[i];
        }
        Arrays.sort(B);
    }
    public static void findP() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(B[i]==A[j]) {
                    if(used[j]==1) continue;
                    P[j] = i;
                    used[j] = 1;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        input();
        findP();
        for(int i=0;i<N;i++) {
            System.out.print(P[i] + " ");
        }
    }
}
