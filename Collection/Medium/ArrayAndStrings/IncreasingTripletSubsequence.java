// 334 Increasing Triplet Subsequence

// O(n)... reference by https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/discuss/79004/Concise-Java-solution-with-comments.
class Solution {
   public boolean increasingTriplet(int[] nums) {
       
       int small = Integer.MAX_VALUE;
       int big = Integer.MAX_VALUE;
       
       for(int n: nums) {
           if(n <= small) {
               small = n;
           } else if(n <= big) {
               big = n;
           } else return true;
       }
       return false;
    }
}