/**
* https://school.programmers.co.kr/learn/courses/30/lessons/42862#
* 최육복


* 반례 13, [1, 2, 5, 6, 10, 12, 13], [2, 3, 4, 5, 7, 8, 9, 10, 11, 12]
* 출력 11
* 반례 7, [2, 3, 4], [1, 2, 3, 6]
* 출력 6
*/
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] canLend = new boolean[n+1];
        
        //여분의 체육복이 있으면 canLend[] 배열에 true를 저장
        for(int i=0;i<reserve.length;i++) {
            canLend[reserve[i]] = true;
        }
        
        //lost 가 정렬되지 않는 경우 반례
        //5 [4, 2], [5, 3] 출력 5 
        //lost[i]-1 을 보고 lost[i]+1 을 보기때문에 정렬을 해야한다.
        Arrays.sort(lost);
        
        //여분의 체육복이 있는데 도난당한경우에 내가 입어야하기 때문에
        //canLend[] 를 false 로 바꾸고 lost[i] 에 -1을 저장한다.
        for(int i=0;i<lost.length;i++) {
            if(canLend[lost[i]]) {
                answer++;
                canLend[lost[i]] = false;
                lost[i] = -1;
            }
        }
        
        //lost[i] 가 -1인 경우에는 생략한다.
        for(int i=0;i<lost.length;i++) {
            if(lost[i] < 0) continue;
            
            //앞사람에게 빌릴 수 있는지 먼저 확인한다.
            if(canLend[lost[i]-1]) {
                answer++;
                canLend[lost[i]-1] = false;
                continue;    
            } 
            
            //뒷사람에게 빌릴 수 있는지 확인한다.
            if(lost[i]+1 <= n && canLend[lost[i]+1]) {
                answer++;
                canLend[lost[i]+1] = false;
            }
        }
        
        return answer;
    }
}
