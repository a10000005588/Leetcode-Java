class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], 0);
            }
            int value = map.get(nums[i]);
            value++;
            map.put(nums[i], value);
            
            if(value > (nums.length)/3) {
                if(!result.contains(nums[i])) {
                    result.add(nums[i]);
                }
            }
        }
        return result;
    }
}
