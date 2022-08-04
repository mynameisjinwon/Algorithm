/*
https://school.programmers.co.kr/learn/courses/30/lessons/81301
숫자 문자열과 영단어
*/
class Solution {
    private final String[] number = {"zero", "one", "two", "three", "four", "five", 
                            "six", "seven", "eight", "nine", "ten"};
    
    public int solution(String s) {
        int answer = 0, tmp = 0;
        
        while(s.length() > 0) {
            if(isNumber(s.charAt(0))) {
                tmp = toNumber(s.charAt(0) - '0', tmp);
                s = s.substring(1);
            } else {
                int idx = findNumber(s);   
                tmp = toNumber(idx, tmp);
                s = s.substring(number[idx].length());
            }
        }   
        
        return tmp;
    }
    private int findNumber(String s) {
        for(int i=0;i<number.length;i++) {
            if(s.startsWith(number[i])) {
                return i;
            }
        }        
        return 0;
    }
    private int toNumber(int n, int tmp) {
        tmp *= 10;
        tmp += n;
        return tmp;
    }
    private boolean isNumber(char c) {
        if(c > 47 && c < 58) return true;
        return false;
    }
}
