import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
       return dfs(numbers,0,target,0);
    }
    
    public int dfs(int[] numbers,int index, int target, int sum) {
        if(index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        return dfs(numbers,index+1,target,sum + numbers[index]) + 
            dfs(numbers,index+1,target,sum - numbers[index]);
    }
}