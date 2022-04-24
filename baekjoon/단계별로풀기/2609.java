import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = GCD(A, B);
        int lcm = LCM(A, B, gcd);

        System.out.println(gcd + "\n" + lcm);
    }

    public static int GCD(int A, int B) {
        int r = A % B;

        if(r == 0) return B;

        return GCD(B, r);
    }

    public static int LCM(int A, int B, int gcd) {
        int a = A / gcd, b = B / gcd;
        return a * b * gcd;
    }
}