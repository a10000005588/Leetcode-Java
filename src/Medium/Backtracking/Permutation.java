

// my solution ...but has bug (cannot deal with negitive number)...


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        // here's the proble... "-1" will covert to the ['-','1']
        String numsString = Arrays.toString(nums).replaceAll("\\[|\\]|,|\\s", "");
        
        doPermute(ans, set, numsString, 0);
        return ans;
    }

    public void doPermute(List<List<Integer>> res,List<Integer> set, String nums, int index) {

        for(int i=0; i<nums.length(); i++) {

            char numChar = nums.charAt(i);
            int num = Integer.parseInt(String.valueOf(numChar));
            List<Integer> newSet = new ArrayList<Integer>(set);
            newSet.add(num);

            String s = nums.substring(0,i) + nums.substring(i+1,nums.length());

            if(nums.length() == 1) {
                res.add(newSet);
                return ;
            }

            doPermute(res, newSet, s,index+1);
        }
    }
}

// other's...
// https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/discuss/18436/Java-Clean-Code-Two-recursive-solutions

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();

        doPermute(ans, set, nums, 0);
        return ans;
    }

    public void doPermute(List<List<Integer>> res,List<Integer> set, int[] nums, int index) {

        if(set.size() == nums.length) {
            res.add(set);
            return;
        }

        for(int i=0; i<=set.size(); i++) {
            List<Integer> newSet = new ArrayList<>(set);
            newSet.add(i, nums[index]);

            doPermute(res, newSet, nums,index+1);
        }
    }
}