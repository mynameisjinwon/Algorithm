/*
https://www.acmicpc.net/problem/5543
상근날드
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int mH = 2001, mB = 2001;

        for(int i=0;i<3;i++) {
            int h = Integer.parseInt(bf.readLine());
            if(h < mH ) mH = h;
        }

        for(int i=0;i<2;i++) {
            int b = Integer.parseInt(bf.readLine());
            if(b < mB) mB = b;
        }

        int ans = mH + mB - 50;
        System.out.println(ans);
    }
}