// 

// my code

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<String>();

        char[][] phone = new char[][]{
                {}, // 1
                {'a','b','c'}, // 2
                {'d','e','f'}, // 3
                {'g','h','i'}, // 4
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };

        char[] input = digits.toCharArray();
        char[] ans = new char[input.length];

        if(input.length > 0)
            backtracking(res, phone, ans, input,0);
        return res;
    }

    public void backtracking(List<String> res, char[][] phone, char[] ans,char[] input, int index) {

        // termination condition
        if(index == ans.length) {
            String s = String.copyValueOf(ans);
            res.add(s);
            return;
        }

        int curInputNumber = Character.getNumericValue(input[index]);
        for(int i=0; i<phone[curInputNumber-1].length; i++) {
            // interate 每個number的號碼 並再次呼叫 backtracking function
            ans[index] = phone[curInputNumber-1][i];
            backtracking(res, phone, ans, input,index+1);
        }

        return ;
    }
}