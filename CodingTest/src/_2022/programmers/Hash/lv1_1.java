package _2022.programmers.Hash;

import java.util.HashSet;
import java.util.Set;

//폰켓몬 
import java.util.Set;
import java.util.HashSet;

class lv1_1 {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        if(set.size()>nums.length/2)
            answer=nums.length/2;
        else
            answer=set.size();
        return answer;
    }
}