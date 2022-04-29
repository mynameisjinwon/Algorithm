/*
https://www.acmicpc.net/problem/10039
평균점수
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int stdCnt = 5;
        int sum = 0, ans = 0;
        
        for(int i=0;i<stdCnt;i++) {
            int x = Integer.parseInt(bf.readLine());
            if(x < 40) 
                sum += 40;
            else 
                sum += x;
        }
        ans = sum / stdCnt;
        System.out.println(ans);
    }
}
