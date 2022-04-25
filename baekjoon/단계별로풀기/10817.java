import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[3];
        int idx = 0;
        
        while(st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        System.out.println(arr[1]);
    }
}