package _2022.programmers.Hash;
import java.util.HashMap;


//lv2_2. 위장 

class lv2_2 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        // System.out.println(clothes.length);
        for(int i=0; i<clothes.length; i++){
            if(!map.containsKey(clothes[i][1]))
                map.put(clothes[i][1],1);
            else
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
        }
        
        for(String key : map.keySet())
            answer*=map.get(key)+1;
        
        answer--;
        
        return answer;
    }
}