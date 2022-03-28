/*
https://www.acmicpc.net/problem/1764
듣보잡
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] noListen, noSee;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    public static int binSearch(String str) {
        int l=0, r=M-1;

        while(l<=r) {
            int m = (l+r)/2;
            if(str.compareTo(noSee[m]) > 0 ) {
                l = m + 1;
            } else if(str.compareTo(noSee[m]) < 0) {
                r = m -1;
            } else
                return m;
        }
        return -1;
    }
    public static void solution() {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        Arrays.sort(noListen);
        Arrays.sort(noSee);

        for(int i=0;i<N;i++) {
            String target = noListen[i];
            int isEither = binSearch(target);
            if(isEither!=-1) {
                cnt++;
                sb.append(target).append("\n");
            }
        }

        System.out.println(cnt + "\n" + sb);
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        noListen = new String[N];
        noSee = new String[M];

        for(int i=0;i<N;i++) {
            noListen[i] = bf.readLine();
        }
        for(int i=0;i<M;i++) {
            noSee[i] = bf.readLine();
        }
    }
}