package _2022.programmers.StackQueue;

import java.util.Stack;
//lv1_1. 같은 숫자는 싫어 

public class lv1_1 {
    public int[] solution(int []arr) {
        // int[] answer = {};
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<arr.length; i++){
            if(stack.size()==0) { // 스택 비어있으면 push
                stack.push(arr[i]);
                continue;
            }
            if(stack.peek()==arr[i]) continue; // 스택의 마지막 숫자가 넣을려는 숫자면 안넣고 패스
            
            stack.push(arr[i]); // 연속되지 않은거 확인했으면 push
        }
        
        int cnt = stack.size();
        int answer[] =new int[cnt]; // 스택 사이즈만큼 정답배열 선언. 
        for(int i=cnt-1; i>=0; i--){ //스택에서 pop해서 배열의 끝에서부터 넣기
            answer[i]=stack.pop();
        }
        return answer;
    }
}
