/*
https://www.acmicpc.net/problem/1264
모음의 개수
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = null;
        while((str = bf.readLine()).charAt(0) != '#') {
            int cnt = 0;
            for(int i=0;i<str.length();i++) {
                if(isVowel(str.charAt(i))) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c =='E' || c == 'I' || c == 'O' || c == 'U';
    }
}