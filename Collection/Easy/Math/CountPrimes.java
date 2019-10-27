
// my solution ...

class Solution {
    public int countPrimes(int n) {
        
        if(n <= 2) {
            return 0;
        }
        if(n <= 3) { // 2,3 is prime
            return 1;
        }
        
        int count = 2;  // 2,3 is prime

        for(int i=4; i<n; i++) {
            boolean isNotPrime = false;
           
            // even number should only consider to its sqrt...
            for(int j=2; j<= (int)Math.sqrt(i)+1; j++) {
                if(i%2== 0) {
                    isNotPrime = true;
                    break;
                }
                if(i%j == 0) {
                    isNotPrime = true;
                    break;
                }
            }
            if(!isNotPrime) {
                count++;
            }
        }
        return count;
    }
}