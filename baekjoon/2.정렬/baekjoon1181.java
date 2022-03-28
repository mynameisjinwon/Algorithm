import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String>[] arr;
    static int N;

    public static void input() {
        N = sc.nextInt();
        arr = new ArrayList[51];
        //arr의 행은 입력된 문자열의 길이, 문자열 길이의 최대값은 50을 넘지않는다.
        for(int len=0;len<=50;len++)
            arr[len] = new ArrayList<String>();
        for(int i=0;i<N;i++) {
            String str = sc.next();
            //같은 문자열이 입력되면 저장하지 않는다.
            if(arr[str.length()].contains(str)) continue;
            //길이가 같은 문자열을 같은 행에 저장한다.
            arr[str.length()].add(str);
        }
    }
    public static void myFunc() {
        //arr에 저장된 문자열 배열을 정렬한다.
        for(int len=0;len<=50;len++)
            Collections.sort(arr[len]);
        //출력
        for(int len=0;len<=50;len++) {
            if(arr[len].size()>0)
                for(int i=0;i<arr[len].size();i++)
                    sb.append(arr[len].get(i)).append('\n');
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        input();
        myFunc();
    }
}
