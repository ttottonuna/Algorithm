import java.util.HashSet;
import java.util.Set;

class Solution {
    public Set<Integer> primeNum = new HashSet<>();
    
    public int solution(String numbers) {
        
        char[] digits = numbers.toCharArray();
        boolean[] visited = new boolean[digits.length];
        dfs(digits, visited, "",0 );
        return primeNum.size();
    }
    
    //dfs 만들기
    public void dfs(char[] digits, boolean[] visited, String curr,int length) {
        if(!curr.equals("") && isPrime(Integer.parseInt(curr))) {
            primeNum.add(Integer.parseInt(curr));
        }
        if (length == digits.length) return;
        
        for (int i=0; i <digits.length; i++) {
            if(!visited[i]) {
                visited[i] =true;
                dfs(digits, visited, curr + digits[i],length +1 );
                visited[i] = false;
            }
        }
}
                                             
    // 소수판별
    boolean isPrime(int n) {
        if(n<2) return false;
        for(int i =2; i*i <= n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }
}