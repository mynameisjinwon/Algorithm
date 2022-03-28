/*
https://www.acmicpc.net/problem/16472
고냥이
*/
import java.io.*;

public class Main {

    static String lang;
    static int[] used = new int[26];
    static int N, cnt=0;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void add(char x) {
        used[x-'a']++;
        if(used[x-'a']==1)
            cnt++;
    }
    public static void erase(char x) {
        used[x-'a']--;
        if(used[x-'a']==0)
            cnt--;
    }
    public static void solution() {
        int len=0;

        // R 을 먼저 이동시키면서 cnt 가 N 보다 작을 때 길이를 갱신한다.
        for(int R=0, L=0;R<lang.length();R++) {
            // 현재 R 이 가리키는 문자를 내 마음속에 추가한다.
            add(lang.charAt(R));

            // cnt 가 N 보다 작거나 같을 때 R 을 계속 추가하면서 길이를 확인한다.
            // cnt 가 N 을 초과하면 가장 먼저 추가한 문자를 제거한다. cnt 가 N 보다 작아질 때 까지
            while( cnt > N ) {
                erase(lang.charAt(L++));
            }

            len = Math.max(len, R-L+1);
        }
        System.out.println(len);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        lang = bf.readLine();

    }
}
