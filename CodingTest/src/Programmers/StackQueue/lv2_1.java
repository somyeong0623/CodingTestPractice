package Programmers.StackQueue;

import java.util.Stack;

//lv2_1. 올바른 괄호 
class lv2_1{
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(c);
            }else{
                if( stack.size()==0 || stack.peek()==')')
                    return false;
                else
                    stack.pop();
            }
        }

        if(stack.size()>0) // 올바른 괄호이면 여기까지 실행되었을때 stack이 비어 있을 것임.
            answer=false;

        return answer;
    }
}
