// 268 Missing Number https://leetcode.com/problemset/all/?search=Missing%20Number

// my solution...Use Hashmap O(n) Runtime: 23 ms

class Solution {
    public int missingNumber(int[] nums) {
        HashMap map = new HashMap();
        
        int missing = -1;
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        
        for(int i=0; i<=nums.length; i++) {
            if(map.get(i) == null) 
                missing = i;
        }
        
        return missing;
    }
}

// other solution
// 1.XOR
public int missingNumber(int[] nums) { //xor
    int res = nums.length;
    for(int i=0; i<nums.length; i++){
        res ^= i;
        res ^= nums[i];
    }
    return res;
}
// 2.SUM
public int missingNumber(int[] nums) { //sum
    int len = nums.length;
    int sum = (0+len)*(len+1)/2;
    for(int i=0; i<len; i++)
        sum-=nums[i];
    return sum;
}
// 3.Binary Search
public int missingNumber(int[] nums) { //binary search
    Arrays.sort(nums);
    int left = 0, right = nums.length, mid= (left + right)/2;
    while(left<right){
        mid = (left + right)/2;
        if(nums[mid]>mid) right = mid;
        else left = mid+1;
    }
    return left;
}
