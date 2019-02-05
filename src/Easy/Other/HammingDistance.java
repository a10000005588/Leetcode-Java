// 461 Hamming Distance   https://leetcode.com/problems/hamming-distance/

class Solution {
    public int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        
        while(x!=0 || y!=0) {
            if( (x & 1) != (y & 1) ) {
                hammingDistance++;
            }
            x = x>>>1;
            y = y>>>1;
        }
        return  hammingDistance;
    }
}