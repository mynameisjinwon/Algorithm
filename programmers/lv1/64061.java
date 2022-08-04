/*
https://school.programmers.co.kr/learn/courses/30/lessons/64061?language=java
크레인 인형뽑기 게임
*/
import java.util.Stack;

class Solution {
    private int cnt;
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<moves.length;i++) {
            int doll = pickUp(board, moves[i]-1);
            if(doll != -1) {
                push(stack, doll);
            } 
        }
        return cnt;
    }
    private void push(Stack stack, int doll) {
        // 스택이 비어있거나 스택의 최상단에 있는 것이 지금 스택에 삽입하려는 것과 동일하지 않으면
        // 그냥 삽입하고 그렇지 않으면 스택의 최상단에 있는 것을 꺼내서 버리고 cnt 값을 2 증가시킨다.
        if(stack.isEmpty() || doll != (int)stack.peek() ) {
            stack.push(doll);
        } else {
            stack.pop();
            cnt += 2;
        }
    }
    // 선택된 열의 가장 높은 위치의 인형을 리턴한다.
    // 선택된 열에 인형이 없으면 -1을 리턴한다.
    private int pickUp(int[][] board, int x) {
        int picked = -1;
        
        for(int i=0;i<board.length;i++) {
            if(board[i][x] != 0) {
                picked = board[i][x];
                board[i][x] = 0;
                break;
            }
        }
        return picked;
    }
}
