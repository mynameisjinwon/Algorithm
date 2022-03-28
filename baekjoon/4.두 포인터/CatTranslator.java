/*
https://www.acmicpc.net/problem/16472
고냥이 
*/
import java.io.*;

public class Main {

    static String lang;
    static int N;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static void solution() {
        int[] used = new int['z'+1];
        char[] cat = lang.toCharArray();
        int cnt=0, len=0, R=0, max=0;

        for(int L=0;L<cat.length;L++) {
            if(L>0) {
                // L 을 증가시키면서 이전에 사용했던 문자를 더 이상 사용하지 않으니까
                // 길이를 의미하는 len 과 문자의 사용횟수를 기록하는 used 배열의 값을 감소시킨다.
                used[cat[L-1]]--;
                len--;
                // used 배열의 값이 0 이 아니면 아직 사용하는 문자라는 뜻이다.
                // 사용하는 문자에 대해서 cnt 값을 감소시키면 안되기 때문에
                // used 배열의 값이 0 일 때만 cnt 를 감소시킨다.
                if(used[cat[L-1]]==0)
                    cnt--;
            }
            while( R < cat.length ) {
                // 현재 R 이 가리키는 문자를 아직 사용하지 않았다면
                // cnt 를 증가시킨다.
                if(used[cat[R]]==0)
                    cnt++;
                // cnt 를 증가시켰을 때 N 을 초과하면 cnt 를 감소시키고 반복문을 탈출한다.
                if(cnt > N) {
                    cnt--;
                    break;
                }
                // 문자의 사용횟수, 길이를 증가시키고 R 이 다음 문자를 가리키도록한다.
                used[cat[R]]++;
                len++;
                R++;
            }
            // 인식할 수 있는 문자의 최대길이를 저장한다.
            max = Math.max(len, max);
        }
        System.out.println(max);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        lang = bf.readLine();

    }
}
