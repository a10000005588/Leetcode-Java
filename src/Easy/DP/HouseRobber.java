// # 198 House Robber https://leetcode.com/problems/house-robber/

//  Reference https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.

// for memo and top
class Solution {
    int[] memo; 
    public int rob(int[] A) {
        memo = new int[A.length+1];
        Arrays.fill(memo, -1);
            
        return rob(A, A.length-1);
    }
    
    public int rob(int[] A, int index) {
        if(index < 0 ) {
            return 0;
        }
        // 如果有測資是 [0,0,0,0,......] 會Time limit exceeded...
        if(memo[index] >= 0) {
            return memo[index];
        }
        int result = Math.max((rob(A, index-2) + A[index]), rob(A, index-1));
        memo[index] = result;

        return result;
    }
}

// Iterative + memo (bottom-up)

public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int[] memo = new int[nums.length + 1];
    memo[0] = 0;
    memo[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int val = nums[i];
        memo[i+1] = Math.max(memo[i-1] + val, memo[i]);
    }
    return memo[nums.length];
}

// Iterative + 2 variables (bottom-up)
/*
We can notice that in the previous step we use only memo[i] and memo[i-1], 
so going just 2 steps back. We can hold them in 2 variables instead. 
This optimization is met in Fibonacci sequence creation and some other problems [to paste links]
*/

/* the order is: prev2, prev1, num  */
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int num : nums) {
        int tmp = prev1;
        prev1 = Math.max(prev2 + num, prev1);
        prev2 = tmp;
    }
    return prev1;
}