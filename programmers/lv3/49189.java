/*
https://school.programmers.co.kr/learn/courses/30/lessons/49189
가장 먼 노드
*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    
    ArrayList<Integer>[] adj;
    int[] dist;
    boolean[] visited;
    int max; 
    
    public int solution(int n, int[][] edge) {
        //그래프를 인접리스트로 표현하기위한 2차원 배열
        adj = new ArrayList[n+1];
        //1번 정점과 각 정점들과의 거리를 저장하기 위한 배열
        dist = new int[n+1];
        //이미 방문한 점을 다시 방문하지않기위해 방문 여부를 저장하는 배열
        visited = new boolean[n+1];
        //1번 정점과 가장 먼 정점과의 거리를 저장하기 위한 변수
        max = -1;
        
        //배열 초기화
        for(int i=1;i<n+1;i++) {
            adj[i] = new ArrayList<>();
            dist[i] = -1;
            visited[i] = false;
        }
        
        //인접 리스트 생성
        for(int i=0;i<edge.length;i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            
            //양방향 그래프
            adj[x].add(y);
            adj[y].add(x);
        }
        
        //1번 정점과 각 정점사이의 거리를 구하기 위해 bfs수행
        bfs(1);
        
        //1번 정점과의 거리가 가장 먼 정점들의 수를 세서 answer 에 담는다.
        int answer = 0;
        for(int i=2;i<dist.length;i++) {
            if(dist[i] == max) 
                answer++;
        }
        
        return answer;
    }
    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        //시작 정점 큐에 삽입
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;
        
        while(!queue.isEmpty()) {
            int x = queue.poll();

            //각 정점과 연결된 정점들 중 아직 방문하지 않은 정점과의 거리를 갱신하고
            //해당 정점과 연결된 또 다른 정점을 탐색하기위해 큐에 삽입한다.
            for(int v : adj[x]) {
                if(visited[v]) continue;
                
                dist[v] = dist[x] + 1;
                max = Math.max(dist[v], max);
                queue.add(v);
                visited[v] = true;
            }
        }
    }
}