import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static class Position implements Comparable<Position> {

        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position other) {
            if(this.x - other.x == 0) return this.y - other.y;
            return this.x - other.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        Position[] pos = new Position[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i] = new Position(x, y);
        }

        Arrays.sort(pos);

        for(int i=0;i<N;i++)
            sb.append(pos[i].toString()).append("\n");

        System.out.println(sb);
    }
}
