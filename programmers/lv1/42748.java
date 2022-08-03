/*
https://school.programmers.co.kr/learn/courses/30/lessons/42748
k번째수
*/
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++) {
            
            int from = commands[i][0] - 1;
            int to = commands[i][1];
            int idx = commands[i][2] - 1;
            
            int[] tmp = Arrays.copyOfRange(array, from, to);
            Arrays.sort(tmp);
            
            answer[i] = tmp[idx];
            
        }
        return answer;
    }
}
