// 190. Reverse Bits  https://leetcode.com/problems/reverse-bits/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1; // 看n的第一位是否為1，若是的話則result+1
            n >>>= 1;   // 將n往右移一位
            
            if (i < 31) // 最後一位不用往左移
                // 往左移一位
                result <<= 1;
        }
        return result;
    }
}