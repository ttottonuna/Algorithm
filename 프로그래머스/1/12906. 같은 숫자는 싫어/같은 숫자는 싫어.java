import java.util.Stack;

public class Solution {
    public int[] solution(int[] arr) {
        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // arr 순회
        for (int i : arr) {
            // 스택이 비어있거나 i가 직전에 담긴 값과 다를 경우 스택에 i 넣기
            if (stack.empty() || !stack.peek().equals(i)) {
                stack.push(i);
            }
        }

        // stack to array
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
