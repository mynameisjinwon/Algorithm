/*
https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=java
더 맵게
최소힙을 구현에서 풀어보았다.

*/
class Solution {

    static class MinHeap {

        static final int MAX_SIZE = 1000001;
        static int[] heap;
        static int head, rear;

        public MinHeap() {
            heap = new int[MAX_SIZE];
            head = 1;
            rear = 1;
        }
        //put
        private void put(int element) {
            if(isEmpty()) {
                heap[rear] = element;
                rear++;
                return;
            }
            if(rear >= MAX_SIZE ) {
                poll();
            }
            heap[rear] = element;
            swapUp();
            rear++;
        }
        //poll
        private int poll() {
            int returnV = heap[head];
            heap[head] = heap[rear-1];
            swapDown();
            rear--;
            return returnV;
        }
        //peek
        private int peek() {
            return heap[head];
        }
        //swap 힙 구조를 유지하기위해 swap을 한다.
        private void swapUp() {
            int idx = rear;
            //부모보다 자식이 작으면
            while(idx/2 >= head && heap[idx] < heap[idx/2]) {
                int tmp = heap[idx];
                heap[idx] = heap[idx/2];
                heap[idx/2] = tmp;

                idx /= 2;
            }
        }
        private void swapDown() {
            int idx = head;

            while(idx*2+1 < rear && (heap[idx] > heap[idx*2] || heap[idx] > heap[idx*2+1])) {
                int tmp;
                if(heap[idx*2] < heap[idx*2+1]) {
                    tmp = heap[idx*2];
                    heap[idx*2] = heap[idx];
                    heap[idx] = tmp;
                    idx = idx * 2;
                } else {
                    tmp = heap[idx*2+1];
                    heap[idx*2+1] = heap[idx];
                    heap[idx] = tmp;
                    idx = idx * 2 + 1;
                }
            }
        }
        //size
        private int size() {
            return rear - 1 ;
        }
        //isEmpty
        private boolean isEmpty() {
            return head == rear;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            int right = 1;
            for(int i=head;i<rear;i++) {
                sb.append(heap[i]);
                if(i == right) {
                    sb.append("\n");
                    right = i * 2 + 1;
                }
            }
            return sb.toString();
        }
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;

        //우선순위 큐선언
        MinHeap heap = new MinHeap();

        //우선순위큐에 scoville 입력
        for(int i=0;i<scoville.length;i++) {
            heap.put(scoville[i]);
        }
        //큐.peek() 값이 k 보다 작을 동안
        //새로운 음식을 만들어 큐에 삽입
        while(heap.size()>=2 && heap.peek() < K) {
            int f1 = heap.poll();
            int f2 = heap.poll();
            heap.put(f1 + f2 * 2);
            answer++;
        }
        //큐가 비어있지 않고 최소값이 k 보다 작으면 -1 리턴
        if(heap.peek() < K) return -1;

        return answer;
    }
}
