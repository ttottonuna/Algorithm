import java.util.*;

class Solution {
    public int solution(String s) {
        //1. 변수 묶어서 생성
        String sb = s + s;
        int answer = 0;
        //2. isvalid 유효 확인하고
        for(int i=0; i<s.length(); i++)
        if(isValid(sb.substring(i,i + s.length()))) {
            answer++;
        }
        return answer;   
    }
        //3. isvalid 규칙 짜기
        public boolean isValid(String s) {
            Deque<Character> stack =  new ArrayDeque<>();
            
            for(char cur : s.toCharArray()) {
                if(cur=='(' || cur=='{' || cur=='[') {
                    stack.push(cur);
                } else {
                    if(stack.isEmpty()) return false;
                    char target = stack.pop();
                    if(target == '(' && cur !=')' ||
                       target == '{' && cur !='}' ||
                       target == '[' && cur !=']'
                      ) return false;
                }
            }
            return stack.isEmpty();
        }
}