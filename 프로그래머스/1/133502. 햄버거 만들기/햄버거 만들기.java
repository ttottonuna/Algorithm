import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < ingredient.length; i++) {
            stack.add(ingredient[i]);
            
            // 스택의 마지막 4개의 요소가 1, 2, 3, 1인지 확인
            if (stack.size() >= 4) {
                int fourth = stack.removeLast();
                int third = stack.removeLast();
                int second = stack.removeLast();
                int first = stack.removeLast();
                
                // 1, 2, 3, 1의 순서가 맞으면 answer 증가
                if (first == 1 && second == 2 && third == 3 && fourth == 1) {
                    answer++;
                } else {
                    // 순서가 맞지 않으면 다시 스택에 넣음
                    stack.addLast(first);
                    stack.addLast(second);
                    stack.addLast(third);
                    stack.addLast(fourth);
                }
            }
        }
        return answer;
    }
}
