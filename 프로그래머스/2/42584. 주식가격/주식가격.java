import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        //1. 리턴 배열로 만들고, 스택 만들기
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        //2. 리턴값 규칙 만들기  여기서 i는 인덱스 :0부터 시작한당
        for(int i =0; i <prices.length; i++ ) {
            while(!stack.isEmpty()) {
                int j = stack.peek();
                if(prices[j] > prices[i]) {
                    answer[j] = i - j;
                    stack.pop();
                } else 
                    break;
            }
            stack.push(i);    
        }
       //3. 나머지 안떨어진 값들 구하기
            while(!stack.isEmpty()) {
                int i = stack.pop();
             answer[i] = prices.length-1-i;
        }
        return answer;
    }
}