class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] position = {
            {3, 1}, // 0
            {0, 0}, {0, 1}, {0, 2}, // 1, 2, 3
            {1, 0}, {1, 1}, {1, 2}, // 4, 5, 6
            {2, 0}, {2, 1}, {2, 2}  // 7, 8, 9
        };

        int[] left = {3, 0}; // 초기 위치 '*'
        int[] right = {3, 2}; // 초기 위치 '#'

        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer += "L";
                left = position[i];
            } else if (i == 3 || i == 6 || i == 9) {
                answer += "R";
                right = position[i];
            } else { // i가 2, 5, 8, 0일 때
                int leftDist = Math.abs(left[0] - position[i][0]) + Math.abs(left[1] - position[i][1]);
                int rightDist = Math.abs(right[0] - position[i][0]) + Math.abs(right[1] - position[i][1]);

                if (leftDist < rightDist) {
                    answer += "L";
                    left = position[i];
                } else if (rightDist < leftDist) {
                    answer += "R";
                    right = position[i];
                } else { // 거리가 같을 때
                    if (hand.equals("left")) {
                        answer += "L";
                        left = position[i];
                    } else {
                        answer += "R";
                        right = position[i];
                    }
                }
            }
        }
        return answer;
    }
}
