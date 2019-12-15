class Solution {
  public int maxSubArray(int[] nums) {
      int maxSoFar = nums[0];
      int front, end;
      for(int searchLength=nums.length; searchLength>0; searchLength--) {
          front = 0;
          end = searchLength-1;
          for(int round=0; round <= (nums.length-searchLength); round++) {
              int sum = sumAll(nums, front, end);
              if(sum > maxSoFar) { maxSoFar = sum; }
              
              // if end exceeded the length of nums, end the round
              if(end >= nums.length) { break; }
              front++;
              end++;
          }
      }
      return maxSoFar;
  }
  
  public int sumAll(int[] nums, int front, int end) {
      int sum = 0;
      for(int i=front; i<=end; i++) {
          sum += nums[i];
      }
      return sum;
  }
}