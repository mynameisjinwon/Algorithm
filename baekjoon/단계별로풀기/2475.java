import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int sum = 0;
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            sum += num * num;
        }
        int ans = sum % 10;
        System.out.println(ans);
    }
}