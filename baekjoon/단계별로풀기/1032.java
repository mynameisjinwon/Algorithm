/*
https://www.acmicpc.net/problem/1032
명령 프롬프트
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(bf.readLine());
        String[] file = new String[N];

        for(int i=0;i<N;i++) {
            file[i] = bf.readLine();
        }

        char[] format = new char[file[0].length()];

        for(int i=0;i<format.length;i++)
            format[i] = file[0].charAt(i);

        if(N==1) {
            System.out.println(file[0]);
            return;
        }

        for(int i=0;i<N-1;i++) {
            for(int j=0;j<format.length;j++) {
                if(file[i].charAt(j) == file[i+1].charAt(j)) continue;
                format[j] = '?';
            }
        }

        for(char c : format) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}