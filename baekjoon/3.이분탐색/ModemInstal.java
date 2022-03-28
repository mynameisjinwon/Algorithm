/*
https://www.acmicpc.net/problem/2110
공유기 설치
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static boolean determination(int d) {
        // 0 번째 집에 공유기를 설치 cnt 는 설치된 공유기의 개수
        // x 는 마지막에 공유기를 설치한 위치
        int x=A[0], cnt=1;
        for(int i=1;i<A.length;i++) {
            // 마지막에 공유기를 설치한 집과 다른 집의 거리가 d 보다 크다면 
            // cnt 를 증가시키고 x 에 A[i] 를 저장한다
            if(A[i] - x >= d) {
                x = A[i];
                cnt++;
            }
        }
        // C 개 이상의 공유기를 설치할 수 있다면 true 를 리턴
        return C <= cnt;
    }
    public static void solution() {
        int l=0, r=1000000000, result = 0;

        // 좌표 순으로 배열을 정렬 
        Arrays.sort(A);

        while(l<=r) {
            int mid = (l+r)/2;
            // mid 만큼의 거리를 두고 공유기를 설치 할 수 있다면 
            // mid 의 최대값을 찾기 위해 오른쪽으로 탐색범위를 옮긴다.
            if(determination(mid)) {
                result = mid;
                l = mid + 1;
            // 그렇지 않으면 왼쪽으로 탐색범위를 옮긴다.
            } else {
                r = mid - 1;
            }
        }
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new int[N];
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }
    }
}