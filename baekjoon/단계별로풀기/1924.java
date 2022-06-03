/*
https://www.acmicpc.net/problem/1924
2007년
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final String[] dayOfWeek = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    private static final int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int BASE_DATE = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String ans = null;

        int month = Integer.parseInt(st.nextToken());
        int date = Integer.parseInt(st.nextToken());

        int daysDiff = date - BASE_DATE;

        for(int i=1;i<month;i++) {
            daysDiff += days[i];
        }
        ans = dayOfWeek[daysDiff%7];
        System.out.println(ans);
    }
}