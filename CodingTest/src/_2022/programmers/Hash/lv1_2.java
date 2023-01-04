package _2022.programmers.Hash;

// lv1. 완주하지 못한 선수 
import java.util.HashMap;


class lv1_2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //hashmap은 동일한 key가 들어오면 값을 덮어씌워버린다. 
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        for(int i=0; i<participant.length; i++){
            if(!map.containsKey(participant[i])) // map에 없으면 명수 1로 넣기 
                map.put(participant[i],1);
            else{ // map에 이미 있는 선수면 +1해서 덮어쓰기 
                map.put(participant[i],map.get(participant[i])+1);
            }
        }
        
        for(int i=0; i<completion.length; i++){ // 명수-1로 갱신해서 map에 넣으면 덮어씌어진다.
            map.put(completion[i],map.get(completion[i])-1);
        }
        
        for(int i=0; i<participant.length; i++){
            if(map.get(participant[i])==1) // 1명만 남기때문에 명수가 1인 key가 답이된다. 
                answer=participant[i];
        }
      
        return answer;
    }
}