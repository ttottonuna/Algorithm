import java.util.*;

class Solution {
    public int solution(String s) {
        //두배로 만들기, ans 선언, 스택은 나중에 만들기
        int ans = 0;
        String sb = s+s;
    
        // 유효확인 괄호가 유효하면 ans++ 리턴해라
        for(int i=0; i<s.length(); i++) {
            if(isValid(sb.substring(i,i+s.length()))) {
                ans++;
            }
        }
        return ans;
    }
        // 유효구현 스택 만들고 열린괄호 스택에 넣고, 스택에서 빼면서 닫힌 괄호랑 비교 
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char cur : s.toCharArray()) {
            if(cur=='(' || cur=='{' || cur=='[') {
                stack.push(cur);
            } else {
                if(stack.isEmpty()) return false;
                char target = stack.pop();
                if(target =='(' && cur !=')' || 
                   target =='{' && cur !='}' ||
                   target =='[' && cur !=']'  ) 
                 return false;   
        }
        }
        return stack.isEmpty();
    }
}