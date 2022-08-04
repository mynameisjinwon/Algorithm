/*
https://school.programmers.co.kr/learn/courses/30/lessons/43165
타겟 넘버
dfs로 풀긴했는데
문제 카테고리를 보지 않았으면 dfs로 풀 생각을 못했을것 같다.
*/
class Solution {
    
    static int[] operator = {-1, 1};
    static int cnt;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        cnt = 0;
        
        rec_func(numbers, target, 0, 0);
        
        answer = cnt; 
        
        return answer;
    }
    private void rec_func(int[] numbers, int target, int k, int sum) {
        if(k == numbers.length) {
            if(sum == target) cnt++;
            return;
        }
        for(int i=0;i<operator.length;i++) {
            int num = numbers[k] * operator[i];
            rec_func(numbers, target, k + 1, sum + num);
        }
    }
}