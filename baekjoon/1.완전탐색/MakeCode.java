/*
https://www.acmicpc.net/problem/1759
암호 만들기
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static char[] selected, cand;
    private static int L, C;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        selected = new char[L];
        cand = new char[C];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<C;i++) {
            cand[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(cand);

        rec_func(0, 0);
        System.out.println(sb);
    }

    // k 는 선택된 문자 -1, k 가 L - 1 이면 L 개를 선택한거임 그래서 k 가 L 일 때 재귀를 멈추고
    // 모음과 자음의 개수를 세서 조건에 맞는 경우만 sb 에 append 한다.
    // start 는 직전에 선택한 문자가 있는 cand 배열의 인덱스, 해당 인덱스 부터 cand 의 문자를 차례대로 선택해
    // selected 에 저장한다.
    // cand 는 이미 정렬이 되어있고 하나의 문자를 선택했다면 그 문자보다 앞에 있는 문자를 선택하면 안되다. 알파벳이 증가하는 순서로 저장해야하기 때문에
    public static void rec_func(int k, int start) {
        if(k == L) {
            if(validCheck()) {
                for(char c : selected) {
                    sb.append(c);
                }
                sb.append("\n");
            }
        } else {
            for(int i=start;i<C;i++) {
                selected[k] = cand[i];
                rec_func(k+1, i+1);
            }

        }
    }

    // 선택된 문자들 중 모음과 자음의 개수를 세서
    // 모음이 하나 이상인지, 자음이 둘 이상인지를 확인한다.
    public static boolean validCheck() {
        int vCnt =0, cCnt = 0;
        for(int i=0;i<L;i++) {
            if(isVowel(selected[i])) {
                vCnt++;
            } else {
                cCnt++;
            }
        }
        return vCnt >= 1 && cCnt >= 2;
    }

    // 인자로 전달된 문자가 모음인지 확인한다.
    public static boolean isVowel(char c) {
        ArrayList<Character> vowel = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        return vowel.contains(c);
    }
}