// 326 Power of three https://leetcode.com/problems/power-of-three/

// will occur time limit exceeded ... 2147483647
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) {
            return false;
        } 
    
        if(n == 1) {
            return true;
        }

        if(n > 1162261467) {
          return false;
        }

        // take the length of the integer 
        int length = String.valueOf(n).length();
        int base = 3;
        
        while(base <= n) {
            if(base == n) {
                return true;
            }
            base = base * 3;
        }
        return false;
    }
}

// one line solutin by someone....

class Solution {
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
        return ( n>0 &&  1162261467%n==0);
    }
}