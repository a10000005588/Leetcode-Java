class Solution {
  public int searchInsert(int[] nums, int target) {
      int i=0;
      for(int n: nums) {
          if(n >= target) {
              break;
          }
          i++;
      }
      return i;
  }
}