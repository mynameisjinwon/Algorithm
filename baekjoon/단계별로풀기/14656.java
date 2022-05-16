/*
https://www.acmicpc.net/problem/14656
조교는 새디스트야!!
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        solution();
    }

    private static void solution() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int ans = 0;
        int N = Integer.parseInt(bf.readLine());
        Student[] stds = new Student[N+1];

        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=N;i++) {
            int num = Integer.parseInt(st.nextToken());
            stds[i] = new Student(num, i);
        }

        for(Student std : stds) {
            if(std != null && !std.inPosition()) ans++;
        }
        System.out.println(ans);
    }

    private static class Student {

        private final int num;
        private final int pos;

        public Student(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }

        private boolean inPosition() {
            return this.num == this.pos;
        }
    }

}