/*
https://programmers.co.kr/learn/courses/30/lessons/72410
신규아이디 추천
*/
class Solution {
    public String solution(String new_id) {
        String answer = " ";
        // 대문자를 소문자로
        new_id = new_id.toLowerCase();

        // 특수문자 제거
        new_id = removeCharacter(new_id);

        // 연속된 . 하나로 치환 && 첫 문자가 . 이면 제거
        new_id = periodProcess(new_id);

        // 빈 문자열이면 "a"를 대입한다.
        if(new_id.length() == 0) new_id = appendA(new_id);
        if(new_id.length() > 15) new_id = decreaseLength(new_id);
        if(new_id.length() <= 2) new_id = increaseLength(new_id);

        answer = new_id;

        return answer;
    }
    private String increaseLength(String id) {
        StringBuilder sb = new StringBuilder();
        int idx = id.length() - 1;
        char lastChar = id.charAt(idx);
        sb.append(id);

        while(sb.length() < 3) {
            sb.append(lastChar);
        }
        return sb.toString();
    }
    private String decreaseLength(String id) {
        id = id.substring(0, 15);
        return periodProcess(id);
    }
    private String appendA(String id) {
        return "a";
    }
    private String periodProcess(String id) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<id.length();i++) {
            if(i+1 < id.length() && id.charAt(i) == '.' && id.charAt(i+1) == '.') continue;
            if(sb.length() == 0 && id.charAt(i) == '.')  continue;
            if(i == id.length()-1 && id.charAt(i) == '.') continue;
            sb.append(id.charAt(i));
        }
        return sb.toString();
    }
    private String removeCharacter(String id) {
        StringBuilder sb = new StringBuilder();
        // id에 포함된 문자를 확인하면서 사용할 수 있는 문자만 sb에 append한다.
        for(int i=0;i<id.length();i++) {
            if(!isValidCharacter(id.charAt(i))) continue;
            sb.append(id.charAt(i));
        }
        return sb.toString();
    }
    private boolean isValidCharacter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.';
    }
}