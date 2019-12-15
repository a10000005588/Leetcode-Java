class Solution {
  public int[] plusOne(int[] digits) {
      int[] ans = convertArrayToInt(digits);
      return ans;
  }
  
  public int[] convertArrayToInt(int[] digits) {
      int sum =0;
      int times = 0; // 次方
      // 從個位數
      for(int i=digits.length-1; i>=0; i--) {
          int rate = pow(times, 10);
          sum += digits[i] * rate;
          times++;
      }
      
      // plus one;
      sum += 1;
      // 計算有幾位
      int x = sum;
      int y = 0;
      while(x != 0) {
          x /= 10;
          y++;
      }
      
      int[] ans = new int[y];
      int index=ans.length-1; // 從最後面開始填入
      while(sum!=0) {
          int remainder = sum % 10;
          ans[index] = remainder;
          
          index--;
          sum /= 10;
      }
      
      return ans;
  }
  
  public int pow(int times, int base) {
      int res = base;
      if(times==0) {
          return 1;
      }
      for(int i=1; i<times; i++) {
          res = res * base;
      }
      
      return res;
  }
}