import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // ans 배열로
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        //냅따 for문 돌려 
            // 먼저 스택에 넣고, 하나씩 peek하면서 j랑 i랑 비교해 그러고 ans에 넣고 스택에서 제거
        for(int i =0; i<n; i++) {
            while(!stack.isEmpty()) {
                int j = stack.peek();
                if(prices[j]>prices[i]) {
                    answer[j] = i-j;
                    stack.pop();
                } else break;
            }
         stack.push(i);   
        } 
        while(!stack.isEmpty()) {
                int i = stack.pop();
                answer[i] = n-1-i;
        }
        return answer; 
    }
}