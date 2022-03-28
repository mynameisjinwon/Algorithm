/*
https://programmers.co.kr/learn/courses/30/lessons/77484
로또의 최고 순위와 최저 순위

*/
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;
        int[] bestCase = {6, 6, 5, 4, 3, 2, 1};
        
        for(int i=0;i<lottos.length;i++) {
            if(lottos[i]==0) {
                zeroCnt++;
            }
            for(int j=0;j<win_nums.length;j++) {
                if(lottos[i] == win_nums[j]) {
                    cnt++;
                } 
            }
        }
        int sum = zeroCnt + cnt;

        answer[0] = bestCase[sum];
        answer[1] = bestCase[cnt];
        return answer;
    }
}