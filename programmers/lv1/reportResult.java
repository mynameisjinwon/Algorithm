/*
https://programmers.co.kr/learn/courses/30/lessons/92334
신고결과받기 

*/
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, ArrayList<String>> reportLog = new HashMap<>();
        HashMap<String, ArrayList<String>> reporter = new HashMap<>();
        ArrayList<String> banList = new ArrayList<>();
        
        for(String id : id_list) {
            reportLog.put(id, new ArrayList<String>());
            reporter.put(id, new ArrayList<String>());
        }
        for(int i=0;i<report.length;i++) {
            String[] split = report[i].split(" ");
            
            if(!(reportLog.get(split[1]).contains(split[0]))) {
                reportLog.get(split[1]).add(split[0]);
            }
            if(!(reporter.get(split[0]).contains(split[1]))) {
                reporter.get(split[0]).add(split[1]);
            }
        }
        for(String id : id_list) {
            if(reportLog.get(id).size() > k-1) {
                banList.add(id);
            }
        }
        for(int i=0;i<id_list.length;i++) {
            for(String ban : banList) {
                if(reporter.get(id_list[i]).contains(ban)) {
                    answer[i] += 1;
                }
            }
        }
        
        return answer;
    }
    public boolean isDuplicate(HashMap<String, ArrayList<String>> reportLog, String[] split) {
        return reportLog.get(split[1]).contains(split[0]);
    }
}