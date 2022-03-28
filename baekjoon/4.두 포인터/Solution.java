/*
https://www.acmicpc.net/problem/2467
용액
solution에 용액이라는 뜻도 있다고한다.
*/
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int N;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static int binSearch(int l, int X) {
        int idx=N, r = N-1;

        // -(자신의 값) 보다 같거나 큰 수 중에 제일 작은 값을 찾아 인덱스를 리턴한다.
        // 없으면 N 을 리턴한다. ( 배열의 마지막 원소의 인덱스 + 1 )
        while(l<=r) {
            int mid = (l+r)/2;
            if(X <= A[mid]) {
                idx = mid;
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return idx;
    }
    public static void solution() throws IOException {
        int v1 = 1000000000, v2 = 1000000000;
        int result=0, sum = 2000000000;
        
        for(int i=0;i<N-1;i++) {
            // 자신의 왼쪽에서 -(자신) 보다 큰 값 중 제일 작은 값을 찾는다.
            // X 와 더해서 0 과 가까우려면 -X 이거나 
            // -X 보다 큰 값중 제일 작은 값 또는 작은 값중 제일 큰값을 더해야한다.
            // binSearch() 메소드를 호출해 큰 값중 제일 작은 값의 인덱스를 리턴받고
            // A[result], A[result-1] 과 A[i] 의 합을 비교해 작은 값을 sum 에 저장한다.
            // binSearch() 가 N 이 아닌 값을 리턴했을 때 
            // A[result] 는 큰 값중 제일 작은 값 A[result -1] 은 작은값중 제일 큰 값이다. A가 정렬된 상태이므로
            // result 는 항상 i 보다 크기 때문에 오름 차순 출력을 위해 v1에 A[i] v2 에 A[result] or A[result-1] 을 저장한다.
            result = binSearch(i+1, -A[i]);

            if(i < result -1 && Math.abs(sum) > Math.abs(A[i] + A[result-1])) {
                sum = Math.abs(A[i] + A[result - 1]);
                v1 = A[i];
                v2 = A[result -1];
            }
            if( result < N && Math.abs(sum) > Math.abs(A[i] + A[result])) {
                sum = Math.abs(A[i] + A[result]);
                v1 = A[i];
                v2 = A[result];
            }
        }
        System.out.println(v1 + " " + v2);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}