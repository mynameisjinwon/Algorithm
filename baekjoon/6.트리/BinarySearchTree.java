/*
https://www.acmicpc.net/problem/5639
이진 검색 트리
이 문제로 골드 찍었다. 헤헤
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int length;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
    public static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = null;
        tree = new int[100001];


        while((num = bf.readLine())!=null) {
            if(num.equals("")) break;
            int x = Integer.parseInt(num);
            tree[length++] = x;
        }

    }
    public static void solution() {
        dfs(0, length-1);
        System.out.println(sb);
    }
    public static void dfs(int start, int end) {
        int root = tree[start];
        int leftEnd = end;

        if(start == end) {
            sb.append(root).append("\n");
            return;
        }
        // 루트보다 큰 값을 찾아서 왼쪽 서브트리 오른쪽 서브트리로 나눈다.
        // 루트보다 작은 값이 왼쪽 서브트리에 저장되기 때문에 배열을 탐색해 루트보다 큰값이 저장된 인덱스에서 1을 감소시켜 leftEnd 에 저장한다.
        // 전위 순회 결과가 tree 배열에 저장되어있기 때문에 배열의 각 원소는 서브트리의 루트라고 볼 수 있다.
        // 그 중에서 루트(가장 처음 입력된 값) 보다 작은 값들은 루트의 왼쪽에 저장되는 왼쪽 서브트리이고 큰 값들은 오른쪽 서브트리이다.
        for(int i=start;i<length;i++) {
            if(root < tree[i]) {
                leftEnd = i-1;
                break;
            }
        }
        // 왼쪽 서브트리 탐색
        // start 가 leftEnd 와 같으면 현재 루트보다 작은 값을 가지는 노드가 없다.
        // 왼쪽 서브트리가 없기 때문에 왼쪽 서브트리를 탐색할 필요가 없다.
        if(start != leftEnd)
            dfs(start+1, leftEnd);

        // 오른쪽 서브트리 탐색
        // leftEnd 가 end 와 같으면 현재 루트보다 큰 값을 가지는 노드가 없다.
        // 오른쪽 서브트리가 없기 때문에 오른쪽 서브트리를 탐색할 필요가 없다.
        if(leftEnd < end)
            dfs(leftEnd+1, end);

        sb.append(root).append("\n");

    }

}
