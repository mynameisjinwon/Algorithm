/*
https://www.acmicpc.net/problem/2470
두 용액
Scanner를 사용했더니 시간초과가 발생해서
BufferedReader를 사용했다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int N;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static int binSearch(int l, int r, int x) {
        //result 는 x 보다 큰값 중 가장 작은 값의 인덱스
        int result = r+1;
        while(l<=r) {
            int mid = (l+r)/2;
            // x 보다 mid 에 있는 값이 크거나 같다면
            // mid 의 왼쪽에 있는 값들을 탐색해야한다.
            // (내가 원하는건 큰값 중 가장 작은 값이니까 mid 에 있는 값보다 더 작은 값이 있는지 확인해야한다.)
            // 확인을 위해서 mid 보다 왼쪽으로 범위를 좁힌다 ( r 값을 조정 )
            if(x<=A[mid]) {
                result = mid;
                r = mid-1;
            // x 보다 mid 에 있는 값이 작으면
            // 탐색 범위를 mid 의 오른쪽으로 좁힌다.
            // 내가 원하는 건 x 보다 큰 값이니까
            } else {
                l = mid + 1;
            }
        }
        // x 보다 큰값이 있으면 그 중 가장 작은 값의 인덱스,
        // 없으면 R + 1 을 리턴한다.
        return result;
    }
    public static void solution() {
        int bestSum = Integer.MAX_VALUE;
        int v1=0, v2=0;

        // 이분 탐색을 위해서 배열을 정렬한다.
        Arrays.sort(A, 1, N+1);

        for(int left=1;left<N;left++) {
            int result = binSearch(left+1, N, -A[left]);

            // A[left] + A[result-1]
            // 배열에 -A[left] 보다 큰값이 없으면 R + 1을 리턴한다.
            // 이 경우를 대비해 A[left]와 result -1 과의 비교를 먼저한다.
            // 0과 가장 가까운 합을 찾았으면 갱신
            if(left < result-1 && bestSum > Math.abs(A[left] + A[result-1])) {
                bestSum = Math.abs(A[left] + A[result-1]);
                // 배열 A 는 정렬되어있기 때문에 A[left] 의 값은 A[result-1] 보다 작다.
                v1 = A[left];
                v2 = A[result-1];
            }
            // A[left] + A[result]
            if(result <= N && bestSum > Math.abs(A[left]+A[result])) {
                bestSum = Math.abs(A[left] + A[result]);
                v1 = A[left];
                v2 = A[result];
            }
        }
        System.out.println(v1 + " " + v2);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(bf.readLine());
         A = new int[N+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}