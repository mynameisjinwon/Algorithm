/*
https://school.programmers.co.kr/learn/courses/30/lessons/62048
멀쩡한 사각형
*/
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = getGcd(w, h);
        
        answer = (long)w * h - (w + h - gcd);
        
        return answer;
    }
    private int getGcd(int w, int h) {
        while(h>0) {
            int r = w % h;
            w = h;
            h = r;
        }
        return w;
    }
}
