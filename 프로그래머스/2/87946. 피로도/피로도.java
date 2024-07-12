class Solution {
    private int maxCount = 0; // 유저가 탐험할 수 있는 최대 던전 수

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length]; // 던전 방문 여부를 추적하는 배열
        dfs(k, dungeons, visited, 0); // DFS 탐색 시작
        return maxCount; // 최대 던전 수 반환
    }

    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        maxCount = Math.max(maxCount, count); // 현재까지 탐험한 던전 수와 최대 던전 수 비교

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 던전을 방문하지 않았고, 최소 필요 피로도를 만족하는 경우
                visited[i] = true; // 던전 방문 표시
                dfs(k - dungeons[i][1], dungeons, visited, count + 1); // DFS 재귀 호출
                visited[i] = false; // 던전 방문 표시 해제
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(sol.solution(k, dungeons)); // 결과 출력
    }
}
