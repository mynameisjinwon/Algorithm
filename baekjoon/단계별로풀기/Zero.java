/*
https://www.acmicpc.net/problem/10773
제로
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static class Stack {

        private static int top;
        private int[] stack;

        public Stack(int stackSize) {
            top = 0;
            stack = new int[stackSize];
        }

        public void push(int num) {
            stack[top++] = num;
        }

        public int pop() {
            return stack[top--];
        }

        public int sum() {
            int sum = 0;
            for(int i=0;i<top;i++) {
                sum += stack[i];
            }
            return sum;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(bf.readLine());

        Stack stack = new Stack(K);

        for(int i=0;i<K;i++) {
            int n = Integer.parseInt(bf.readLine());
            if(n!=0)
                stack.push(n);
            else
                stack.pop();
        }

        System.out.println(stack.sum());
    }
}
