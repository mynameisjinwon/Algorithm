/*
https://www.acmicpc.net/problem/7568
덩치
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] mass;
    static int[] rank;
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(bf.readLine());
        rank = new int[N];
        mass = new int[N][2];
        
        // 입력 받기 mass[i][0] 은 체중, mass[i][1] 은 신장
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            
            mass[i][0] = Integer.parseInt(st.nextToken());
            mass[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 각 원소들을 모두 비교하며 현재 선택한 원소보다 체중, 신장이 모두 큰 원소가 있으면 cnt 를 증가시킨다.
        for(int i=0;i<N;i++) {
            int cnt = 0;
            for(int j=0;j<N;j++) {
                if(mass[i][0] < mass[j][0] && mass[i][1] < mass[j][1]) cnt++;                    
            }
            // cnt 는 현재 선택된 원소보다 체중, 신장이 모두 큰 원소의 개수이다.
            // 순위를 매기기위해 cnt 에 1을 더한다.
            rank[i] = cnt+1;
        }
        
        // 출력
        for(int n : rank) 
            sb.append(n).append(" ");
        
        System.out.println(sb);
            
    }
}