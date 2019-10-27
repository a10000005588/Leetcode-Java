// 3. Longest Substring Without Repeating Characters

// my solution...
// 252 ms
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charArr = s.toCharArray();

        if(charArr.length == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int max = -100;
        int count = 0;
        for(int i=0; i<charArr.length; i++) {
            if(!map.containsKey(charArr[i])){
                map.put(charArr[i], i);
                count++;
                if(count > max) max = count;
            } else {
                // from the last same character to count...
                i = map.get(charArr[i]);
                i++;
                // reset the map
                map = new HashMap<Character, Integer>();
                map.put(charArr[i], i);
                count = 1;
            }
        }

        return max;
    }
}

// other solution

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charCounts = new int[256];
        int start = 0;
        int end = 0;
        int ans = 0;
        for(start=0, end=0; end<s.length();){
            if(charCounts[s.charAt(end)]==0){
                charCounts[s.charAt(end)]++;
                end++;
                ans = Math.max(ans, end-start);
            }
            else{
                charCounts[s.charAt(start)]--;
                start++;
            }
        }
        return ans;
    }
}