/*
https://www.acmicpc.net/problem/13144
List of Uniqu Numbers 
cnt는 모든 연속구간의 합 = 50억 근데 int 로 선언해서 틀렸다.
*/
import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static int[] A;
    static int N;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() {
        int[] used = new int[100001];
        int R=1;
        long cnt = 0;

        for(int i=0;i<N;i++) {
            used[A[i]] = 1;
	//직전에 사용한 수는 제외한다.
            if(i>0)
                used[A[i-1]] = 0;

	// R 이 N 보다 작을 때 다음에 나오는 수가 중복된 수가 아니라면
	// R 을 사용했다고 체크하고 중복된 수가 나올 때 까지 R 을 증가시킨다.
            while(R < N && used[A[R]] == 0 ) {
                used[A[R]] = 1;
                R++;
            }
	// 1 2 3 1 4 이라는 수열이 주어졌을 때 
	// i 가 0 일 때 R 은 3 이다. R 에서 i 를 뺀 값이 중복된 수 없이 수열을 만드는 경우의 수이다.
            cnt += R - i;
        }
        System.out.println(cnt);
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
