import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여분이 있지만 도난당한 사람 처리
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;  // 도난당했지만 여분이 있는 경우 체육복을 입을 수 있으므로 정답 증가
                    lost[i] = -1;  // 이미 해결된 학생을 표시
                    reserve[j] = -1;  // 여분 체육복을 사용한 학생 표시
                    break;
                }
            }
        }
        
        // 다른 학생들에게 체육복 빌려주는 경우 처리
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) continue;  // 이미 처리된 학생은 건너뜀
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) continue;  // 이미 체육복을 빌려준 학생은 건너뜀
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;  // 체육복을 빌려주면 정답 증가
                    reserve[j] = -1;  // 체육복을 빌려준 학생 표시
                    break;
                }
            }
        }
    
        return answer;
    }
}
