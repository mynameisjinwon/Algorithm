/*
https://www.acmicpc.net/problem/1654
랜선자르기
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static boolean determination(long L) {
        int sum=0, cnt=0;

        // L 의 길이로 A[i]길이의 랜선을 잘랐을 때 나오는 랜선의 개수를 cnt 에 저장한다.
        for(int i=0;i<N;i++) {
            cnt += A[i]/L;
        }

        // K 개 이상의 랜선을 만들 수 있다면 true 를 리턴한다.
        return K <= cnt;
    }
    public static void solution() {
        // 랜선의 최대길이는 2^31 - 1 이다. ( = Integer.MAX_VALUE)
        long l=1, r=Integer.MAX_VALUE;
        int result = 0;

        while(l<=r) {
            // l, r 은 모두 int 형 변수에 저장할 수 있지만 l + r 을 할때 오버플로우가 발생하므로 long 형 변수에 저장했다.
            long mid = (l+r)/2;
            if(determination(mid)) {
                result = (int)mid;
                l = mid + 1;
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
        K = Integer.parseInt(st.nextToken());
        A = new int[N];

        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }

    }
}