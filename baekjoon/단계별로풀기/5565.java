/*
https://www.acmicpc.net/problem/5565
영수증
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    private static final int MAX_BOOK_CNT = 10;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int total = Integer.parseInt(bf.readLine());
        int sum = 0, ans = 0;
        for(int i=1;i<MAX_BOOK_CNT;i++) {
            int price = Integer.parseInt(bf.readLine());
            sum += price;
        }
        ans = total - sum;
        
        System.out.println(ans);
    }
}