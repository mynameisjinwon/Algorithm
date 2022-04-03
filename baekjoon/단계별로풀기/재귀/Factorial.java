import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(bf.readLine());
        
        System.out.println(fact(N));
        
    }
    public static int fact(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        
        return n * fact(n-1);
    }
}
