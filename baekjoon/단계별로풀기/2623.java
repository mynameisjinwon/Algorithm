/*
https://www.acmicpc.net/problem/2623
음악프로그램
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    private static MyReader scan = new MyReader();
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] adj;
    private static int[] indeg;

    public static void main(String[] args) {
        input();
        solution();
        printResult();
    }
    private static void printResult() {
        // 싸이클이 있는 경우에는 답을 구할 수 없다.
        // 싸이클이 있는 경우에는 solution 메소드에서 inDegree 가 0인 정점을 큐에 삽입할 때 
        // 모든 정점을 큐에 삽입할 수 없다. 싸이클이 없는 경우에는 그래프에서 정점을 하나씩 제거하면서 모든 정점의 inDegree가 0이되는데
        // 싸이클이 있는 경우에는 그렇지 않기 때문에 sb의 길이가 정점의 개수보다 작다.
        if(sb.length()/2 < indeg.length -1) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }
    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<indeg.length;i++) {
            if(indeg[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append("\n");

            for(int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0)
                    queue.add(y);
            }
        }
    }
    private static void input() {
       int n = scan.nextInt();
       adj = new ArrayList[n+1];
       indeg = new int[n+1];
       for(int i=1;i<n+1;i++) {
           adj[i] = new ArrayList<Integer>();
       }
       int m = scan.nextInt();

       for(int i=0;i<m;i++) {
           int size = scan.nextInt();
           int[] music = new int[size];
           for(int j=0;j<size;j++) {
               music[j] = scan.nextInt();
               if(j > 0) {
                   adj[music[j - 1]].add(music[j]);
                   indeg[music[j]]++;
               }
           }
       }
    }
    private static class MyReader {
        BufferedReader bf;
        StringTokenizer st;

        private MyReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while( st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String str = "";
            try {
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
