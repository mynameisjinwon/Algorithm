/*
https://school.programmers.co.kr/learn/courses/30/lessons/12977
소수 만들기 
*/
class Solution {
    
    private static final int MAX_VALUE = 50001;
    
    public int solution(int[] nums) {
        int answer = -1, prime_cnt = 0;
        boolean[] isNotPrime = new boolean[MAX_VALUE];
        
        initialize(isNotPrime);
        
        for(int i=0;i<nums.length-2;i++) {
            for(int j=i+1;j<nums.length-1;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(!isNotPrime[sum]) prime_cnt++;
                }
            }
        }
        
        return prime_cnt;
    }
    private void initialize(boolean[] isNotPrime) {
        for(int i=2;i<isNotPrime.length;i++) {
            if(isNotPrime[i]) continue;
            for(int j=i+i;j<isNotPrime.length;j+=i) {
                if(isNotPrime[j]) continue;
                isNotPrime[j] = true;
            }
        }
    }
}
