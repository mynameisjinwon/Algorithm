/*
baekjoon1015.java와의 차이점
이전에는 이중 for문 으로 구현되어 시간복잡도가 O(N^2)이었으나
객체에 num값과 idx값을 저장해 N번 만큼 탐색을 하면 P를 완성할 수 있다. 
그래서 시간복잡도가 O(NlogN)으로 줄었다.
*/
import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static Num[] nums;
    static int[] P;
    static int N;
    
    //A배열의 인덱스값을 함께 저장하기위해 Num 클래스를 생성
    public static class Num implements Comparable<Num> {
        int num;
        int idx;
        public Num(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
        @Override
        public int compareTo(Num other) {
            //java에서 object의 정렬은 Tim sort를 사용해 이뤄지고
            //Tim sort는 stable한 정렬이기 때문에 if문을 제외하고
            //바로 return this.num - outer.num을 해주어도 결과는 동일하다.
            if(this.num-other.num!=0) {
                return this.num - other.num;
            } else
                return this.idx - other.idx;
        }
    }
    public static void input() {
        N = sc.nextInt();
        nums = new Num[N];
        P = new int[N];
      
        //A의 배열의 elements를 입력받고 인덱스도 함께 저장
        for(int i=0;i<N;i++) {
            int num = sc.nextInt();
            nums[i] = new Num(num, i);
        }
    }
    public static void myFunc() {
        //nums가 num값을 기준으로 오름차순 정렬  
        Arrays.sort(nums);
        
        //B[P[i]] = A[i] 이므로 
        //A[i]는 P[i]가 가리키는 B의 인덱스에 저장이된다.
        //B[i].idx는 P[i]값이다. 
        for(int i=0;i<N;i++) {
            P[nums[i].idx] = i;
        }
        for(int i=0;i<N;i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        input();
        myFunc();
    }
}
