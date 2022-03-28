/*
https://www.acmicpc.net/problem/2805
나무 자르기
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        int max = input();
        solution(max);
    }
    public static boolean determination(int h) {
        long sum=0;
        // 톱날의 높이 H 로 나무를 잘라 얻을 수 있는 나무의 길이를 구한다.
        for(int i=0;i<A.length;i++) {
            if(h < A[i])
                sum += A[i]-h;
        }
        // H 높이로 잘라 얻을 수 있는 나무의 길이가 필요한 나무 길이보다 크거나 같으면 TRUE 를 리턴
        return sum >= M;
    }
    // 0 ~ 가장 긴 나무 높이 + 1 사이에서 조건을 만족하는 톱날의 높이의 최대값을 찾는다.
    public static void solution(int max) {
        int l=0, r=max+1;
        int result=0;

        while(l<=r) {
            int m = (l+r)/2;
            // 조건을 만족하는 H 의 최대값을 찾아야 함으로
            // determination 이 true 를 리턴하면 탐색 범위를 오른쪽으로 옮긴다.
            // (높이를 증가시켜서 그 높이로 원하는 길이를 얻을 수 있는지 확인한다.)
            if(determination(m)) {
                l = m+1;
                result = m;
            // determination 이 false 를 리턴하면 원하는 길이의 나무를 얻지 못한다는 뜻
            // = h 의 값이 너무 길다 -> 탐색 범위를 왼쪽으로 옮긴다. ( h 의 값을 줄인다. )
            } else {
                r = m-1;
            }
        }
        System.out.println(result);
    }
    public static int input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int i = 0, max = Integer.MIN_VALUE;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(bf.readLine());
        // 입력을 받으면서 높이가 최대인 나무의 높이를 리턴한다.
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            A[i++] = tmp;
            if(tmp > max)
                max = tmp;
        }
        return max;
    }
}