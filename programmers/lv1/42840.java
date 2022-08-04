/*
https://school.programmers.co.kr/learn/courses/30/lessons/42840#
모의고사
*/
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer;
        int[][] guess = {{1,2,3,4,5},
                         {2,1,2,3,2,4,2,5},
                         {3,3,1,1,2,2,4,4,5,5}};
        int[] score = {0, 0, 0};
        int max = -1;
        
        for(int i=0;i<guess.length;i++) {
            for(int j=0;j<answers.length;j++) {
                if(answers[j] == guess[i][j%guess[i].length]) {
                    score[i]++;
                }
                max = Math.max(max, score[i]);
            }
        }
        for(int i=0;i<score.length;i++) {
            if(score[i]==max) {
                list.add(i+1);
            }
        }
        answer = new int[list.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}