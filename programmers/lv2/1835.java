/*
https://school.programmers.co.kr/learn/courses/30/lessons/1835?language=java
단체사진 찍기
*/
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    static final int FRIENDS = 8;
    static boolean[] isUsed;
    static HashMap<Character, Integer> frineds = new HashMap<>();
    static int answer;
    
    public int solution(int n, String[] data) {
        answer = 0;
        
        isUsed = new boolean[FRIENDS];
        ArrayList<Integer> seq = new ArrayList<>();
        for(int i=0;i<FRIENDS;i++) {
            seq.add(-1);
        }
        
        frineds.put('A', 0);   frineds.put('C', 1);   frineds.put('F', 2);   frineds.put('J', 3);
        frineds.put('M', 4);   frineds.put('N', 5);   frineds.put('R', 6);   frineds.put('T', 7);
        
        makeSequence(0, seq, data);
        
        return answer;
    }
    //완전 탐색으로 줄을 세운다
    //8명 줄을 세우는 것 = 8개의 숫자를 중복을 허용하지 않고 순서대로 뽑는것?
    //중복을 허용하지 않기위해 isUsed[] 배열을 사용했다.
    public void makeSequence(int k, ArrayList<Integer> seq, String[] data) {
        // 8명을 줄 세웠으면 조건을 검사한다
        // 조건에 맞으면 answer를 증가시킨다
        if(k==8) {
            if(condition(seq, data)) {
                answer++;
            }
        } else {
            for(int i=0;i<FRIENDS;i++) {
                if(isUsed[i]) continue;
                seq.set(k, i);
                isUsed[i] = true;
                makeSequence(k+1, seq, data);
                isUsed[i] = false;
                seq.set(k, 0);
            }
        }
    }
    public boolean condition(ArrayList<Integer> seq, String[] data) {
        char name1, name2, cond, d;
        int dist, num1, num2, result;
        
        for(int i=0;i<data.length;i++) {
            name1 = data[i].charAt(0);
            name2 = data[i].charAt(2);
            cond = data[i].charAt(3);
            dist = data[i].charAt(4) - '0';
            
            num1 = seq.indexOf(frineds.get(name1));
            num2 = seq.indexOf(frineds.get(name2));
            result = Math.abs(num1 - num2) -1;
        
            // 명시된 조건을 만족하지 않는 경우에는 false를 리턴한다.
            if((cond == '=' && result != dist) ||
               (cond == '>' && result <= dist) ||
               (cond == '<' && result >= dist)) {
                return false;
            }
        }
        return true;
    }
}
