import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int move : moves) {
            int col = move - 1; // moves 배열은 1부터 시작하므로 0으로 맞추기 위해 -1

            for (int i = 0; i < board.length; i++) {
                if (board[i][col] != 0) {
                    // 인형이 있을 경우
                    int doll = board[i][col];
                    board[i][col] = 0; // 인형을 뽑았으므로 해당 위치를 0으로 설정

                    // 스택의 top과 같으면 터뜨리기
                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2; // 두 인형이 터지므로 2 추가
                    } else {
                        stack.push(doll);
                    }
                    break; // 인형을 뽑았으므로 다음 move로 이동
                }
            }
        }
        return answer;
    }
}
