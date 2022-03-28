import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] cards;

    public static void input() {
        N = sc.nextInt();
        cards = new long[N];

        for(int i=0;i<N;i++) {
           cards[i] = sc.nextLong();
        }
    }
    public static void myFunc() {
        Arrays.sort(cards);
        //curCount : 현재 숫자의 빈도수
        //modeCount : 최빈값의 빈도수
        //mode : 최빈값을 갖는 수
        int curCount=1, modeCount=1;
        long mode=cards[0];
        for(int i=1;i<N;i++) {
            if(cards[i-1]==cards[i]) {
                curCount += 1;
            } else {
                curCount =1;
            }
            if(curCount > modeCount) {
                modeCount = curCount;
                mode = cards[i];
            }
        }
        System.out.println(mode);
    }
    public static void main(String[] args) {
        input();
        myFunc();
    }
}
