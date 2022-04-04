/*
https://www.acmicpc.net/problem/10816
숫자 카드 2
이분탐색 카테고리에 있는 문제이지만
해쉬맵을 사용해서 풀어보았다.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();


        N = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            int key = Integer.parseInt(st.nextToken());
            map.putIfAbsent(key, 0);
            map.put(key, map.get(key) + 1);
        }

        M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++) {
            int n = Integer.parseInt(st.nextToken());
            if(map.get(n) == null) sb.append(0).append(" ");
            else sb.append(map.get(n)).append(" ");
        }
        System.out.println(sb);
    }
}
