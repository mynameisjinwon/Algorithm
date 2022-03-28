/*
https://www.acmicpc.net/problem/1253
좋다
HashMap을 사용해서 풀려고만 했다. 예외상황이 너무 많아서 해결하지 못했다.
다른 방법을 쓰고싶지 않았던게 아니라 이 방법 아니면 못 풀 줄 알았다.
투 포인터로 풀었다. 
*/
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] A;
    static int N;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static boolean isGood(int idx) {
        int l = 0, r = N-1, x = A[idx];

        // 두 수의 합으로 선택된 수 (A[idx]) 를 찾을 수 있는지 확인하는 것이기 때문에
        // l 과 r 이 같은 경우는 포함하지 않는다.
        while(l < r) {
            // 자신을 다른 수의 합으로 구할 수 있는지 확인하는데 자신을 이용하면 안된다.
            if(l == idx) {
                l++;
                continue;
            }
            if(r == idx) {
                r--;
                continue;
            }
            // 선택된 수가 다른 두 수의 합으로 나타낼 수 있으면 true 를 리턴한다.
            if(A[l]+A[r] == x) return true;
            // 다른 두 수의 합이 내가 찾는수 보다 크면
            // 더 큰값을 가리키는 포인터를 앞으로 땡긴다.
            else if(A[l]+A[r] > x) r--;
            // 아니면 더 작은값을 가리키는 포인터를 뒤로 땡긴다.
            else l++;
        }
        return false;
    }
    public static void solution() {
        int l, r, cnt = 0;

        // 최대 최소를 빠르게 찾기 위해 정렬
        Arrays.sort(A);

        // 배열의 원소를 하나씩 선택해
        // 해당 원소를 다른 원소의 합으로 나타낼 수 있는지 확인한다.
        for(int i=0;i<N;i++) {
            if(isGood(i)) cnt++;
        }
        System.out.println(cnt);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());
    }
}
