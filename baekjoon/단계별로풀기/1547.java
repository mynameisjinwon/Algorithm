import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Cup {
        private int number;
        private int position;

        public Cup(int number, int position) {
            this.number = number;
            this.position = position;
        }

        public void swap(Cup other) {
            int tmp = position;
            this.position = other.position;
            other.position = tmp;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(bf.readLine());
        int ans = -1;

        Cup[] cups = new Cup[4];
        for(int i=1;i<4;i++)
            cups[i] = new Cup(i, i);

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cups[x].swap(cups[y]);
        }

        for(int i=1;i<4;i++)
            if(cups[i].position == 1) ans = i;

        System.out.println(ans);
    }
}