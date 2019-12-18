// 有參考過後，寫出來的
class Solution {
  public void merge(int nums1[], int m, int nums2[], int n) {
       int i=m-1;
       int j=n-1;
       int k=m+n-1;
       while(i>-1 && j>-1) {
           if(nums1[i] < nums2[j]) {
               nums1[k] = nums2[j];
               j--;
               k--;
           } else {
               nums1[k] = nums1[i];
               i--;
               k--;
           }
       }
      // 假設nums1[]有值的長度為0...
      while(j>-1) {
          nums1[k] = nums2[j];
          k--;
          j--;
      }
  }
}