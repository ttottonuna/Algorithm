import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
 public int solution(String s) {
     String sd = s + s ;
     int ans = 0;
     
     for(int i =0; i < s.length(); i++) {
         if (isValid(sd.substring(i,s.length()+i)))
             ans++;
     }
     return ans;
 }
    private boolean isValid(String s) {
     Deque<String> stack = new ArrayDeque<>();
        
        for(char p : s.toCharArray()) {
            if(p == '(') {
                stack.push(")");
            } else if (p == '{') {
                stack.push("}");
            } else if (p == '[') {
                stack.push("]");
            } else if (!stack.isEmpty() && stack.peek().equals(String.valueOf(p))) {
                stack.pop();
            } else
                return false;
    }
        return stack.isEmpty();
}
}