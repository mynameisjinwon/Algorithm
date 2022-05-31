/*
https://www.acmicpc.net/problem/2252
줄 세우기 
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int[] shorter = new int[N+1]; // 어떤 학생보다 작은 학생의 수
        ArrayList<Integer>[] taller = new ArrayList[N+1]; // 어떤 학생보다 큰 학생을 저장하는 배열
        for(int i=0;i<N+1;i++) taller[i] = new ArrayList<Integer>(); // ArrayList 배열 초기화

        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            shorter[t]++;
            taller[s].add(t);
        }

        for(int i=1;i<N+1;i++) {
            // 자신보다 작은 학생 수가 0 인 학생을 queue 에 삽입한다.
            if(shorter[i]==0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            // queue 에 저장된 원소를 뽑아 정렬결과를 저장할 StringBuilder 에 저장한다.
            int x = queue.poll();
            sb.append(x).append(" ");
            // 해당 학생을 제거했을 때 자신보다 작은 학생의 수가 0 이되는 학생을 queue 에 삽입한다.
            for(int y : taller[x]) {
                shorter[y]--;
                if(shorter[y]==0) queue.add(y);
            }
        }

        System.out.println(sb);
    }
}