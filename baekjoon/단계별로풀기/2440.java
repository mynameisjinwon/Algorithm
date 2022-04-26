import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++) {
            sb.append("*".repeat(N - i));
            sb.append("\n");
        }

        System.out.println(sb);

    }
}