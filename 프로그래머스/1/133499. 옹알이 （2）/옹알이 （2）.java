class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling) {
            //단어가 연속될 경우
            if (word.contains("ayaaya") || 
                word.contains("yeye") || 
                word.contains("woowoo") || 
                word.contains("mama")) {
                continue;
            }
            
            // 단어를 빈칸으로 치환하고 남은 문자열이 있는지 확인
            String temp = word.replace("aya", " ")
                              .replace("ye", " ")
                              .replace("woo", " ")
                              .replace("ma", " ")
                             .replace(" ", "");


            //공백을 포함시켜주어야 하는 이유 : 단어를 빼고 남았을 때 발음이 되는 경우가 있을 수도 있기 때문
            if (temp.length()==0) {
              answer++;
            } 
        }
        
        return answer;
    }
}