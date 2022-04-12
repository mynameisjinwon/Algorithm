/*
https://www.acmicpc.net/problem/20291
파일 정리
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int N;

    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new TreeMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++) {
            // 입력된 문자열을 '.' 을 기준으로 구분하고 '.' 의 뒤에 있는 문자열을 format 변수에 저장한다.
            String format = bf.readLine().split("\\.")[1];
            // map 에 format 의 개수를 저장한다.
            // TreeMap 은 정렬된 상태로 입력을 받는다.
            map.put(format, map.get(format)==null? 1 : map.get(format)+1);
        }

        // keySet() 은 key 값만 필요할 때 사용한다.
//        for(String key : map.keySet()) {
//            sb.append(key).append(" ").append(map.get(key)).append("\n");
//        }

        // entrySet() 은 key 값, value 값이 필요할 때 사용한다.
        // entrySet() 은 Set<Map.Entry<>> 타입의 객체를 리턴한다.
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb);
    }
}