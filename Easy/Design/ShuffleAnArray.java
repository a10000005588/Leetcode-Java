// 384 Shuffle an Array https://leetcode.com/problems/shuffle-an-array/

class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[nums.length];
        Random random = new Random();
        res = this.nums.clone();
        
        int round = 0;
        while(round < this.nums.length) {
            int index =  (int)(Math.random()*(nums.length - round)) + round;;
           
            swap(res, round, index);
            round++;
        }
        
        return res;
    }
    
    private void swap(int[] res, int x, int y) {
        int temp = res[x];
        res[x] = res[y];
        res[y] =temp;
    }
}