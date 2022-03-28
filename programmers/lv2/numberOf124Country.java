/*
https://programmers.co.kr/learn/courses/30/lessons/12899
124 나라의 숫자

*/
class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int[] nums = {4, 1, 2, 4};
        int[] thereNumber;
        int reminder = 0;
        int quotient = 0;
              
        int nod = findNod(n);
        thereNumber = new int[nod];
        for(int i=0;i<nod;i++) {
            quotient = n / 3;
            reminder = n % 3;
            if(reminder==0)
                quotient--;
            n = quotient;
            
            thereNumber[i] = nums[reminder];
        }
        
        for(int i=thereNumber.length-1;i>-1;i--) {
            sb.append(thereNumber[i]);
        }
        answer = sb.toString();
        return answer;
    }
    
    public int findNod(int n) {
        int nod = 1;
        while(true) {
            if(rec_func(nod++) > n)
                break;
        }
        return nod-2;
    }
    
    public int rec_func(int k) {
        if(k==1)
            return 1;
        else {
            return (int)Math.pow((double)3, (double)k-1) + rec_func(k - 1);
        }
    }
}