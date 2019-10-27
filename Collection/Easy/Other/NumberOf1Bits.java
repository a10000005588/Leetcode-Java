// 191 Number of 1 Bits  https://leetcode.com/problems/number-of-1-bits/

public class Solution {
    // you need to treat n as an unsigned value
   public static int hammingWeight(int n) {
	    int ones = 0;
    	while(n!=0) {
            // 將n的第一位與1做 and 運算
            // 若n的第一位為1會得到1, 第一位為0則and運算得到 0
    		ones = ones + (n & 1);
            // 將n往右邊無條件移動一位
    		n = n>>>1;
    	}
    	return ones;
  }
}