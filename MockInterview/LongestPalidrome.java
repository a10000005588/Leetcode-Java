
class Solution {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        
        if(str.length == 0) {
            return "";
        }
        // 5 
        for(int i=0; i<str.length; i++) {
            // 5
            for(int j=0; j<=i; j++) {
                String res = s.substring(j, j+(str.length-i));
                if(isPalindrome(res)) {
                    return res;
                }
            }
        }
        return s.substring(1);
    }
    
    public boolean isPalindrome(String str) {
        char[] s = str.toCharArray();
        
        for(int i=0; i<s.length; i++) {
            if(s[i] != s[s.length-i-1]) {
                return false;
            }
        }
        return true;
    }
}
