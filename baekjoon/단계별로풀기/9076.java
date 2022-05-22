/*
https://www.acmicpc.net/problem/9076
점수 집계
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        final int MAX_DIFF = 4;
        final int SCORE_CNT = 5;

        int N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<SCORE_CNT;j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr);
            arr.remove(0);
            arr.remove(arr.size()-1);
            if(arr.get(arr.size()-1) - arr.get(0) >= MAX_DIFF) {
                sb.append("KIN").append("\n");
                continue;
            }
            int sum = 0;
            for(int n : arr) {
                sum += n;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}