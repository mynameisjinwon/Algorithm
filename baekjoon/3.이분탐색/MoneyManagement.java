/*
https://www.acmicpc.net/problem/6236
용돈 관리
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static int[] budget;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
    public static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        budget = new int[N];

        for(int i=0;i<N;i++) {
            budget[i] = Integer.parseInt(bf.readLine());
        }
    }
    public static void solution() {
        // k 의 최대값은 N 의 최대값 100000 X i 번째 날 이용할 최대 금액 10000
        int l = 0, r = 1000000000, result = 0;

        while(l <= r) {
            int m = (l + r) / 2;

            // determination 이 true 를 리턴하면 선택된 금액으로 M 번 또는 M 번 이하만큼 출금해 사용 가능하다는 뜻이다.
            // k 의 최소값을 찾아야하므로 탐색범위를 더 작은 쪽으로 좁힌다. ( m 을 기준으로 왼쪽을 탐색한다.)
            if(determination(m)) {
                result = m;
                r = m - 1;

            // false 를 리턴하면 해당 금액으로는 하루에 사용할 금액을 충당할 수 없다는 뜻이다.
            // 탐색 범위를 더 큰 쪽으로 좁힌다. ( m 을 기준으로 오른쪽을 탐색한다. )
            } else {
                l = m + 1;
            }
        }
        System.out.println(result);
    }
    public static boolean determination(int m) {
        // withdraw 는 출금한 금액, cnt 는 출금 횟수
        int withdraw = m, cnt = 1;

        for(int i=0;i<N;i++) {
            // 출금한 금액이 그날 써야하는 금액보다 적으면 한번 더 출금하고 출금 횟수를 증가시킨다.
            // 처음 문제를 풀 때 하루에 여러번 출금이 가능한 줄 알고 while 문을 사용해서 풀었더니 틀렸다.
            if(withdraw < budget[i]) {
                withdraw = m;
                cnt++;
            }
            // 출금한 금액에서 그 날 사용할 금액을 차감한다.
            // 출금한 금액이 0 보다 작으면 그 날 사용할 금액을 충당할 수 없다는 뜻이기 때문에 false 를 리턴하고 종료한다.
            withdraw -= budget[i];
            if(withdraw < 0) return false;
        }
        return cnt <= M;
    }
}