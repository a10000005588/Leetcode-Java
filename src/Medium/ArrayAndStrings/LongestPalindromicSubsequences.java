// 5 Longest Palindromic Substring  https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        String result = new String();
        // 從最大的長度開始切割
        for(int i=0; i<s.length(); i++){

            for(int j=0; j<s.length(); j++) {
                int len = s.length() - i;
                int head = j;
                int tail = len + j;

                if(tail> s.length()) break;

                String sub = s.substring(head, tail);

                if (isPalidrome(sub)) {
                    if(sub.length() >= result.length())
                        result = sub;
                    break;
                }
            }
        }

        return result;
    }

    public boolean isPalidrome(String s) {
        char[] charArr = s.toCharArray();

        int i = 0;
        while(i < (s.length())/2) {
            if(charArr[i] != charArr[(s.length()-1)-i]) {
                return false;
            }
            i++;
        }
        return true;
    }
}