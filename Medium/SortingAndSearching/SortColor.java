
// Extra space...
class Solution {
    public void sortColors(int[] nums) {
        
        int red = 0;
        int white = 0;
        int blue = 0;
        int counter =0;
        for(int i=0; i<nums.length;i++) {
            if(nums[i] == 0) red++;
            if(nums[i] == 1) white++;
            if(nums[i] == 2) blue++;
        }
        
        for(int i=0; i<red;i++) {
            nums[counter] = 0;
            counter++;
        }
        
        for(int i=0; i<white; i++) {
            nums[counter] = 1;
            counter++;
        }
        
        for(int i=0; i<blue; i++) {
            nums[counter] = 2;
            counter++;
        }
    }
}

// use pivot
// reference: https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/discuss/26472/Share-my-at-most-two-pass-constant-space-10-line-solution
class Solution {
    public void sortColors(int[] nums) {
        int pivotRed = 0;
        int pivotBlue = nums.length-1;

        for(int i=0; i<nums.length; i++) {
            // should check 2 first...0 from the end may swap to the nums[i]
            if(nums[i] == 2) {
                while(nums[i] == 2 && i < pivotBlue){ // swap 2 to the right....
                    // swap the 2 with pivotBlue
                    int temp = nums[pivotBlue];
                    nums[pivotBlue] = 2;
                    nums[i] = temp;
                    pivotBlue--;
                }
            }
            if(nums[i] == 0) {
                // swap the 0 with pivotRed
                int temp = nums[pivotRed];
                nums[pivotRed] = 0;
                nums[i] = temp;
                pivotRed++;
            }
            
           
        }
    }
}