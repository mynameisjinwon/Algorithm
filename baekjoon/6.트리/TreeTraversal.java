/*
https://www.acmicpc.net/problem/1991
트리 순회
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static Node[] node;
    static int[] parent;

    // 트리를 저장하기위한 클래스
    static class Node {
        char root;
        Node left;
        Node right;

        public Node(char root, Node left, Node right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
    public static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());

        node = new Node[N];
        parent = new int[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node leftChild = null;
            Node rightChild = null;

            // 왼쪽 오른쪽 자식을 root 로 하는 Node 인스턴스를 생성한다.
            // node 배열의 인덱스값이 parent 배열에 저장된다. 
            // 자기 부모 노드가 node 배열에 저장될 인덱스를 parent 배열에 저장한다. 
            if (left != '.') {
                parent[left - 'A'] = root - 'A';
                leftChild = new Node(left, null, null);
            }
            if (right != '.') {
                parent[right - 'A'] = root - 'A';
                rightChild = new Node(right, null, null);
            }

            // rootNode 를 생성한다.
            Node rootNode = new Node(root, leftChild, rightChild);
            // 노드 배열에 생성한 인스턴스를 저장한다.
            node[root - 'A'] = rootNode;

            // i 가 0 일때 루트노드인 A 가 저장이된다. 그래서 0 일 경우에는 건너뛴다.
            // 내 자식이 하나라도 있으면 실행한다. 자식이 하나도 없으면 건너뛴다.
            if(i!=0 && ( leftChild != null || rightChild != null )) {
                // 부모노드가 저장되어있는 node 배열의 인덱스를 idx 에 저장한다.
                int idx = parent[root - 'A'];

                // 부모 노드의 왼쪽, 오른쪽 자식이 있고 그 자식이 나라면 거기에 나를 저장한다. 
                // 내 자식과 부모노드를 연결한다.
                if(node[idx].left != null && node[idx].left.root == root)
                    node[idx].left = rootNode;
                else if(node[idx].right != null  && node[idx].right.root == root)
                    node[idx].right = rootNode;
            }
        }
    }
    public static void solution() {
        // 순회 결과를 StringBuilder 에 담고 순회가 끝나면 개행문자를 추가한다.
        preOrder(0);
        sb.append('\n');
        
        inOrder(0);
        sb.append('\n');
        
        postOrder(0);

        System.out.println(sb);
    }
    public static void preOrder(int idx) {

        int leftIdx = -1, rightIdx = -1;
        Node rootNode = node[idx];

        // 왼쪽 자식이 있으면 leftIdx 에 왼쪽 자식이 저장되어있는 node 배열의 인덱스를 저장한다.
        if(rootNode.left != null)
            leftIdx = rootNode.left.root - 'A';
        // 오른쪽 자식이 있으면 leftIdx 에 왼쪽 자식이 저장되어있는 node 배열의 인덱스를 저장한다.
        if(rootNode.right != null)
            rightIdx = rootNode.right.root - 'A';
        
        // 전위 순회는 루트를 가장 먼저 방문하기 때문에
        // 자식 노드를 대상으로 해당 메소드를 호출하기 전에 루트 노드를 출력한다. 
        sb.append(rootNode.root);

        if(leftIdx != -1)
            preOrder(leftIdx);
        if(rightIdx != -1)
            preOrder(rightIdx);
    }
    public static void inOrder(int idx) {

        int leftIdx = -1, rightIdx = -1;
        Node rootNode = node[idx];

        if(rootNode.left != null)
            leftIdx = rootNode.left.root - 'A';
        if(rootNode.right != null)
            rightIdx = rootNode.right.root - 'A';

        if(leftIdx != -1)
            inOrder(leftIdx);
        
        // 중위순회는 왼쪽 자식 노드가 없을때 or 왼쪽 자식들을 모두 순회한 뒤에 루트노드를 방문하는 것이기때문에
        // 왼쪽 자식에 대한 해당 메소드의 실행이 끝나면 루트노드를 출력한다.
        sb.append(rootNode.root);

        if(rightIdx != -1)
            inOrder(rightIdx);

    }
    public static void postOrder(int idx) {

        int leftIdx = -1, rightIdx = -1;
        Node rootNode = node[idx];

        if(rootNode.left != null)
            leftIdx = rootNode.left.root - 'A';
        if(rootNode.right != null)
            rightIdx = rootNode.right.root - 'A';

        if(leftIdx != -1)
            postOrder(leftIdx);

        if(rightIdx != -1)
            postOrder(rightIdx);

        // 후위순회는 오른쪽 자식이 없을 때 or 왼쪽, 오른쪽 자식을 모두 순회하고 난 뒤에 루트노드를 방문하는 것이기 때문에
        // 오른쪽 자식에 대한 해당 메소드 실행이 끝나면 루트를 출력한다.
        sb.append(rootNode.root);
    }
}
