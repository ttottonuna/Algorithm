import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
       int n = queue1.length;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long Sumq1 = 0;
        long Sumq2 = 0;
        
        for(int value : queue1) {
            q1.add(value);
             Sumq1 += value;
        }
        for(int value : queue2) {
            q2.add(value);
            Sumq2 += value;
        }
        if((Sumq1 + Sumq2) % 2 == 1) {
            return -1;
        }
        
        for(int i =0; i < 3 * n; i++) {
            if(Sumq1 == Sumq2) {
                return i;
            } else if (Sumq1 > Sumq2) {
                int value = q1.poll();
                q2.add(value);
                
                Sumq1 -= value;
                Sumq2 += value;
            } else if (Sumq1 < Sumq2) {
                int value = q2.poll();
                q1.add(value);
                
                Sumq1 += value;
                Sumq2 -= value;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
