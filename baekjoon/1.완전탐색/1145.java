/*
https://www.acmicpc.net/problem/1145
적어도 대부분의 배수
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[5];
        int idx = 0;

        while(st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        solution(arr);
    }
    public static void solution(int[] arr) {
        int MAX = 1000001, ans = 0;

        for(int i=1;i<MAX;i++) {
            if(validCheck(arr, i)) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
    public static boolean validCheck(int[] arr, int mid) {
        int cnt = 0;

        for(int i=0;i<arr.length;i++) {
            if(mid % arr[i] == 0) cnt++;
        }

        return cnt >= 3;
    }
}