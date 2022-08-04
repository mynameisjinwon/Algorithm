/*
https://school.programmers.co.kr/learn/courses/30/lessons/42586
기능개발
*/
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int[] release = new int[progresses.length+1];
        
        for(int i=0;i<progresses.length;i++) {
            int rest = 100 - progresses[i];
            int days = rest % speeds[i] == 0 ? rest / speeds[i] : rest / speeds[i] + 1;
            
            queue.add(days);
        }
        
        int len = 0;
        while(!queue.isEmpty()) {
            int prev = queue.poll();
            
            int cnt = 1;
            while(queue.size()>=1&& prev >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            release[len++] = cnt;
        }

        int[] answer = new int[len];
        for(int i=0;i<len;i++) {
            answer[i] = release[i];
        }
        return answer;
    }
}
