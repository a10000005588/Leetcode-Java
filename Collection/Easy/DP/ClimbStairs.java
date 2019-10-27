// my solution ...
// there's a problem, cannot dynamically assign the size of the array.
class Solution {
    
    int[] result = new int[1000];;
    public int climbStairs(int n) {
        result[1] = 1;
        result[2] = 2;
        return doClimbStairs(n);
        
    }
    
    public int doClimbStairs(int n) {
        if(n == 1) {
            return result[1];
        } else if (n == 2) {
            return result[2];
        }
        
        if(result[n] != 0) {
            return result[n];
        }     
        result[n] = climbStairs(n-2) + climbStairs(n-1);

        return result[n];
    }
}

// space time O(3) version...bottom up.

class Solution {
    
    public int climbStairs(int n) {
        if(n<=0) {
            return 0;
        } else if(n==1) {
            return 1;
        } else if(n==2) {
            return 2;
        }
        
        int oneStepBefore = 2;
        int twoStepBefore = 1;
        int allWays = 0;
        
        for(int i=3; i<=n; i++) {
            allWays = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        return allWays;
    }
}