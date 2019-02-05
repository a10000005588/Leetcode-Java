// 794 Generate the parenthese

// reference... 
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/discuss/10100/Easy-to-understand-Java-backtracking-solution
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        
        
        backtrack(res,"", 0, 0, n);
        return res;
    }
    
    public void backtrack(List<String> res,String str, int open, int close, int max){
        if(str.length() == max*2) {
            res.add(str);
            return;
        }
        
        if(open<max) 
            backtrack(res, str+"(",open+1, close, max);
        if(close<open)
            backtrack(res, str+")",open, close+1, max);
    }
}