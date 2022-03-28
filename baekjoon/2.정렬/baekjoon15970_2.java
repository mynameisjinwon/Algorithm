import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] a;
    static int N;

    public static void input() {
        N = sc.nextInt();
        //ArrayList를 사용해 2차원 배열을 구현한다.
        //객체를 만들어 사용하는 것 보다 쉽다.
        a = new ArrayList[N+1];
        for(int col=1;col<=N;col++)
            a[col] = new ArrayList<Integer>();

        for(int i=0;i<N;i++) {
            int pos = sc.nextInt();
            int col = sc.nextInt();
            a[col].add(pos);
        }
    }
    public static int toLeft(int col, int pos) {
        //왼쪽 점과의 거리를 리턴해주는 메소드
        //왼쪽 점이 없으면 무한대를 리턴한다.
        if(pos==0) return Integer.MAX_VALUE;
        return a[col].get(pos) - a[col].get(pos-1);
    }
    public static int toRight(int col, int pos) {
        //오른쪽 점과의 거리를 리턴해주는 메소드
        //오른쪽 점이 없으면 무한대를 리턴한다.
        //a[col].size()는 a[col]의 원소의 개수를 리턴한다.
        //pos는 현재 idx값을 의미하기 때문에 pos의 값이 a[col].size-1이라면 pos가 마지막 인덱스라는 의미이다.
        if(pos==a[col].size()-1) return Integer.MAX_VALUE;
        return a[col].get(pos+1) - a[col].get(pos);
    }
    public static void myFunc() {
        for(int col=1;col<=N;col++) {
            Collections.sort(a[col]);
        }
        int length = 0;
        for(int col=1;col<=N;col++) {
            for(int i=0;i<a[col].size();i++) {
                //왼쪽 점과의 거리 toLeft;
                //오른쪽 점과의 거리 toRight;
                int left = toLeft(col, i);
                int right = toRight(col, i);
                //두값 중 더 작은 값을 리턴한다.
                if(left < right)
                    length += left;
                else
                    length += right;
                //length += Math.min(left, right);
            }
        }
        System.out.println(length);
    }
    public static void main(String[] args) {
        input();
        myFunc();
    }
}
