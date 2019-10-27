// 15 3Sum  https://leetcode.com/problems/3sum/

// my first solution, but will occur time limited exceeded.
class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
            
        // if nums's length is less than 3. return empty result.
        if(nums.length < 3) {
            return results;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        if(count %3 == 0) {
                            // sorted array.
                            Collections.sort(result); 
                            
                            boolean isDuplicated = false;
                            for(int z=0; z<results.size(); z++) {
                                // if there's duplicated, sorted array.
                                List<Integer> existList = results.get(z);
                                if(result.containsAll(existList) && existList.containsAll(result))
                                    isDuplicated = true;                              
                            }
                            
                            if(!isDuplicated) results.add(result);
                            // reset the result;
                            result = new ArrayList<Integer>();
                        }
                    }
                }
            }
        }
        
        return results;
    }
}

// my another solution....
/*
313 / 313 test cases passed.
Status: Accepted
Runtime: 1012 ms
*/
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumResult = new ArrayList<List<Integer>>();
        // if nums's length is less than 3. return empty result.
        if(nums.length < 3) {
            return threeSumResult;
        }

        Arrays.sort(nums);
        // 將找到組合為0的組合 變成string 並存到 hashmap...
        HashMap<String, Integer> resultHashMap = new HashMap<>();

        int first = 0;
        int second = 1;
        // 只會到值 = 0
        while(nums[first] <= 0 && first < nums.length -2) {
            second = first + 1;
            while(second < nums.length-1) {
                // if found target [0] = 1, else [0] = 0
                // and second [1] put the index
                int[] binaryResult = new int[2];

                int twoSum = nums[first] + nums[second];
                if(twoSum >0) {
                    second++;
                    continue;
                }
                binaryResult = binerySearch(nums ,twoSum, second+1, nums.length-1);

                if(binaryResult[0] == 1) {
                    String a = Integer.toString(nums[first]);
                    String b = Integer.toString(nums[second]);
                    String c = Integer.toString(nums[binaryResult[1]]);

                    String result = a.concat(b).concat(c);

                    if(resultHashMap.get(result) == null) {
                        resultHashMap.put(result, 1);

                        List<Integer> answer = new ArrayList<Integer>();
                        answer.add(nums[first]);
                        answer.add(nums[second]);
                        answer.add(nums[binaryResult[1]]);

                        threeSumResult.add(answer);
                    }

                }
                second++;
            }
            first++;
        }

        return threeSumResult;
    }

    public int[] binerySearch(int[] nums,int twoSum, int first, int last) {
        int[] result = new int[2];

        while(first <= last) {
            int mid = (first + last)/2;

            int sum = twoSum + nums[mid];

            if(mid == first && mid == last) {
                if(sum == 0) {
                    result[0] = 1;
                    result[1] = mid;
                }
                break;
            }

            if(sum == 0) {
                result[0] = 1;
                result[1] = mid;
                break;
            } else if(sum < 0) {
                first = mid+1;
            } else {
                last = mid-1;
            }
        }

        // if no target, return empty array.
        return result;
    }
}
