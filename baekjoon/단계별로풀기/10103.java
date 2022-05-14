/*
https://www.acmicpc.net/problem/10103
주사위 게임
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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());

        Player p1 = new Player();
        Player p2 = new Player();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            p1.setNum(x1);
            p2.setNum(x2);

            if(p1.compare(p2) < 0) {
                p1.setLife(p2.getNum());
            } else if(p1.compare(p2) > 0) {
                p2.setLife(p1.getNum());
            }
        }
        sb.append(p1.getLife()).append("\n").append(p2.getLife());
        System.out.println(sb);
    }

    private static class Player {

        private static final int MAX_LIFE = 100;
        private int num;
        private int life;

        private Player() {
            life = MAX_LIFE;
            this.num = 0;
        }

        private void setNum(int num) {
            this.num = num;
        }

        private void setLife(int point) {
            life -= point;
        }

        private int getNum() {
            return num;
        }

        private int getLife() {
            return life;
        }

        private int compare(Player other) {
            return Integer.compare(num, other.num);
        }
    }
}