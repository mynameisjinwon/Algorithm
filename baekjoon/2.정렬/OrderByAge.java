/*
https://www.acmicpc.net/problem/10814
나이순 정렬
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static class Member implements Comparable<Member> {

        private int age;
        private String name;
        private int order;

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

        @Override
        public int compareTo(Member other) {
            if(this.age - other.age == 0) return this.order - other.order;
            return this.age - other.age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        Member[] members = new Member[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(age, name, i);
        }

        Arrays.sort(members);

        for(int i=0;i<N;i++)
            sb.append(members[i].toString()).append("\n");

        System.out.println(sb);
    }
}
