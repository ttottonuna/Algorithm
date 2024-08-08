import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Deque<int[]> queue = new ArrayDeque<>(); 
        boolean[][] visited = new boolean[n][m];
            
        // 큐에 add 방문 표시
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
            
        // 방향 백터 설정
        int[] dr = {0,1,0,-1};
        int[] dc = {-1,0,1,0};
            
        // 큐 반복 시작
            //r값 선언후, dist리턴값 계산 만들기
        while(!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            
            if(r==n-1 && c==m-1) {
                return dist;
            }
            
            //for문 벡터 4개 돌면서 다음 예약값 큐에 넣어주기
            for(int d=0; d<4; d++) {
                int nr = r +dr[d];
                int nc = c +dc[d];
            
                if(nr>=0 && nr<n && nc>=0 && nc<m && maps[nr][nc] ==1) {
                    if(visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr,nc,dist+1});
                }
            }
        }
        //while 리턴 -1
        return -1;
    }
}