import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Point[] points;
    static class Point implements Comparable<Point> {
        int pos, col;
        Point(int pos, int col) {
            this.pos = pos;
            this.col = col;
        }
        @Override
        public int compareTo(Point other) {
            if(col - other.col != 0) return col - other.col;
            else return pos - other.pos;
        }
    }
    public static void input() {
        N = sc.nextInt();
        points = new Point[N];

        for(int i=0;i<N;i++) {
            int pos = sc.nextInt();
            int col = sc.nextInt();
            points[i] = new Point(pos, col);
        }
    }
    public static void myFunc() {
        Arrays.sort(points);
        int length;
        //색이 같은 점이 무조건 하나 이상 있으므로
        //배열을 정렬한 후에 가장 앞에있는 점에서 색이 같은 가장 가까운 점은 그 다음 점이다.
        length = points[1].pos - points[0].pos;
        for(int i=1;i<N-1;i++) {
            //앞 뒤 모두 색이 같을 때
            if(points[i-1].col == points[i].col && points[i].col == points[i+1].col) {
                //앞에 있는 점과 뒤에 있는 점 중에 더 가까운 점을 선택
                if(points[i].pos - points[i-1].pos < points[i+1].pos - points[i].pos)
                    length += points[i].pos - points[i-1].pos;
                else
                    length += points[i+1].pos - points[i].pos;
            //앞에만 색이 같을 때
            } else if(points[i-1].col == points[i].col) {
                length += points[i].pos - points[i-1].pos;
            //뒤에만 색이 같을 때
            } else {
                length += points[i+1].pos - points[i].pos;
            }
        }
        //for문을 통해서 points배열의 마지막 원소의 바로 앞 원소까지만 확인했으므로
        //for문을 탈출한 뒤 length에 마지막 원소와 그 직전 원소의 거리를 더해준다.
        length += points[N-1].pos - points[N-2].pos;

        System.out.println(length);
    }
    public static void main(String[] args) {
        input();
        myFunc();
    }
}
