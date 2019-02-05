// 13 Roman to Integer https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        
    /*
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

        I can be placed before V (5) and X (10) to make 4 and 9. 
        X can be placed before L (50) and C (100) to make 40 and 90. 
        C can be placed before D (500) and M (1000) to make 400 and 900.
        
        Special Case: IV=4, IX=9, XL=40, XC=90, CD=400, CM=900
        
        Input: "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
        
    */
        int romanNumber = 0;
        
        for(int i=0; i<arr.length; i++) {                
            if(i<arr.length-1) {
                if(arr[i] == 'C' && arr[i+1] == 'M') {
                    romanNumber += 900; 
                    i++;
                    continue;
                }

                if(arr[i] == 'C' && arr[i+1] == 'D') {
                    romanNumber += 400; 
                    i++;
                    continue;
                } 

                if(arr[i] == 'X' && arr[i+1] == 'C') {
                    romanNumber += 90; 
                    i++;
                    continue;
                }

                if(arr[i] == 'X' && arr[i+1] == 'L'){
                    romanNumber += 40; 
                    i++;
                    continue;
                } 

                if(arr[i] == 'I' && arr[i+1] == 'X') {
                    romanNumber += 9; 
                    i++; 
                    continue;
                }

                if(arr[i] == 'I' && arr[i+1] == 'V') {
                    romanNumber += 4; 
                    i++; 
                    continue;
                } 
            }
            
            if(arr[i] == 'M') romanNumber += 1000;
            if(arr[i] == 'D') romanNumber += 500;
            if(arr[i] == 'C') romanNumber += 100;
            if(arr[i] == 'L') romanNumber += 50;
            if(arr[i] == 'X') romanNumber += 10;
            if(arr[i] == 'V') romanNumber += 5;
            if(arr[i] == 'I') romanNumber += 1;
        }
        
        return romanNumber;
    }
}