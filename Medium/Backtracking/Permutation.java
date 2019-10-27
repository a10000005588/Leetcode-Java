

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
            // add nums[index] to position i, the original value in pos i will move to position i+1.
            newSet.add(i, nums[index]);

            doPermute(res, newSet, nums,index+1);
        }
    }
}

// String version

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String words = "abcde";
        ans = permute(words);

        System.out.println("Done");
    }

    public static List<String> permute(String words) {
        List<String> ans = new ArrayList<>();
        List<Character> set = new ArrayList<>();
        doPermute(ans, set, words, 0, words.length());
        return ans;
    }

    public static void doPermute(List<String> ans, List<Character> set, String words, int index, int length) {
       if(set.size() == length) {
           String setString = getStringRepresentation(set);
           if(ans.contains(setString) == false) {
               ans.add(setString);
           }
           return;
       }

       char[] wordArr = words.toCharArray();


       for(int i=0; i<words.length(); i++) {
           List<Character> newSet = new ArrayList<>(set);

           newSet.add(wordArr[i]);
           // convert words
           String newWords = words.substring(0, i) + words.substring(i+1);
           doPermute(ans, newSet, newWords, index+1, length);
       }
    }

    public static String getStringRepresentation(List<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
}

