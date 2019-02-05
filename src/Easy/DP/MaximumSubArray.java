// # 53 https://leetcode.com/problems/maximum-subarray/

// my solution , will occur time limitation exceeded...

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            int sum = 0;
            for(int j=nums.length-1; j>=i; j--) {
               for(int k=i; k<=j; k++) {
                   sum += nums[k];
                   if(sum > max) {
                       max = sum;
                   }
               }
               sum = 0;
            }
        }
        
        return max;
    }
}

// reference by ... https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/566/discuss/20211/Accepted-O(n)-solution-in-java
// this problem was discussed by Jon Bentley (Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885)
// 12ms
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int MaxEndingHere = nums[0];
        int MaxSoFar = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            MaxEndingHere = max(MaxEndingHere+nums[i], nums[i]);
            MaxSoFar = max(MaxEndingHere, MaxSoFar);
        }
        
        return MaxSoFar;
    }
    
    public int max(int a, int b) {
        if(a>b) return a;
        return b;
    }
}