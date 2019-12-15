/*
(遇到這筆[測資](https://leetcode.com/submissions/detail/285476299/testcase/)會壞掉)
*/

class Solution {
  public int searchInsert(int[] nums, int target) {
      int index= nums.length/2;
      // exclude the special case
      if(target > nums[nums.length-1]) {
          return nums.length;
      }
      if(target < nums[0]) {
          return 0;
      }
      
      while(true) {
          if(target == nums[index]) {
              break;
          }
          
          if(target > nums[index] && target <= nums[index+1]) {
              index++;
              break;
          }
          if(target > nums[index]) {
              index = (index + nums.length) /2;
          } else if(target < nums[index]) {
              index = (0 + index) /2;
          } 
      }
      
      return index;
  }
}