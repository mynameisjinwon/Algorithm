/*
https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=java
더 맵게
우선순위큐를 사용해 풀어보자
*/
import java.util.PriorityQueue;

class Solution {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        //우선순위 큐선언
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        //우선순위큐에 scoville 입력
        for(int i=0;i<scoville.length;i++) {
            queue.add(scoville[i]);
        }
        //큐.peek() 값이 k 보다 작을 동안
        //새로운 음식을 만들어 큐에 삽입
        while(queue.size()>=2 && queue.peek() < K) {
            int f1 = queue.poll();
            int f2 = queue.poll();
            queue.add(f1 + f2 * 2);
            answer++;
        }
        //큐가 비어있지 않고 최소값이 k 보다 작으면 -1 리턴
        if(queue.peek() < K) return -1;

        return answer;
    }
}
