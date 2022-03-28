/*
https://www.acmicpc.net/problem/2343
기타레슨
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static boolean determination(long min) {
        int sum=0, cnt=1;

        // 강의 시간의 합이 min 을 초과하지 않게 sum 에 담는다.
        // sum 이 min 값을 초과하면 cnt (블루레이의 개수) 값을 증가시킨다.
        for(int i=0;i<A.length;i++) {
            if(A[i] > min) {
                cnt = M + 1;
                break;
            }
            if((sum + A[i]) > min) {
                cnt++;
                sum = A[i];
            } else {
                sum += A[i];
            }
        }
        // 가장 긴 강의 시간보다 min 값이 작거나 같아야한다. min (minute 의 약자임)
        // min 보다 긴 강의 시간이 있으면 블루레이에 담을 수 없기 때문
        return M >= cnt;
    }
    public static void solution() {
        long l=0, r=10000000000L, result = 0;

        while(l<=r) {
            long mid = (l+r)/2;
            if(determination(mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}