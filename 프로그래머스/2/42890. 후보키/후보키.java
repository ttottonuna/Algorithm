import java.util.*;

public class Solution {
    public int solution(String[][] relation) {
        int rowLen = relation.length; // 행 길이
        int colLen = relation[0].length; // 열 길이

        List<Integer> candidates = new ArrayList<>();

        // 모든 부분 집합을 생성 (열의 인덱스를 비트마스크로 표현)
        for (int i = 1; i < (1 << colLen); i++) {
            if (isUnique(relation, rowLen, colLen, i)) {
                candidates.add(i);
            }
        }

        // 최소성을 검사
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < candidates.size(); i++) {
            boolean isMinimal = true;
            for (int j = 0; j < keys.size(); j++) {
                if ((candidates.get(i) & keys.get(j)) == keys.get(j)) {
                    isMinimal = false;
                    break;
                }
            }
            if (isMinimal) {
                keys.add(candidates.get(i));
            }
        }

        return keys.size();
    }

    // 유일성 검사
    private boolean isUnique(String[][] relation, int rowLen, int colLen, int subset) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < rowLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < colLen; j++) {
                if ((subset & (1 << j)) != 0) {
                    sb.append(relation[i][j]).append(",");
                }
            }
            if (!set.add(sb.toString())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] relation = {
            {"100","ryan","music","2"},
            {"200","apeach","math","2"},
            {"300","tube","computer","3"},
            {"400","con","computer","4"},
            {"500","muzi","music","3"},
            {"600","apeach","music","2"}
        };
        System.out.println(solution.solution(relation)); // Expected output: 2
    }
}
