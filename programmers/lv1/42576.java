/*
https://school.programmers.co.kr/learn/courses/30/lessons/42576
완주하지 못한 선수
*/
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        
        for(String name : participant) {
            if(map.get(name) == null) 
                map.put(name, 1);
            else
                map.put(name, map.get(name) + 1);
            /*
            위의 코드 대신 아래의 코드를 사용할 수 있다.
            getOrDefault() : 찾는 키가 있으면 키의 값을 반환하고 없으면 기본값(두번째 인자)을 반환한다.
            해당 코드가 실행되면 처음 해시맵은 비어있는 상태이기 때문에
            모든 키에 대해 0이 저장이되고 + 1 에 의해 1이 된다.
            map.put(name, map.getOrDefault(name, 0) + 1);
            */
        }
        
        for(String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        for(String name : map.keySet()) {
            if(map.get(name) != 0)    
                answer = name;
        }
        
        return answer;
    }
}
