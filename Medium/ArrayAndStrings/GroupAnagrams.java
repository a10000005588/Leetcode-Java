# 49
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        Map<String, Integer> map = new HashMap<String, Integer>();

        if(strs.length == 0) {
            return result;
        }
        // 將str 拆開來 並且依照 char的ascii code進行排序
        // 創造一個 hashmap, 若hashmap內沒有該值，創建一個 List<String> 存進去
        // 並且給予 List<String> 對應的編號
        // 若hashmap有值，那根據hashmap回傳出來的編號 存進去
        int numberOfList = 0;
        for(int i=0; i<strs.length; i++) {
            char[] cArr = strs[i].toCharArray();

            Arrays.sort(cArr);
            String sortedString = String.copyValueOf(cArr);

            if(map.containsKey(sortedString)) {
                int listEntry = map.get(sortedString);
                result.get(listEntry).add(strs[i]);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                result.add(list);
                map.put(sortedString, numberOfList);
                numberOfList++;
            }
        }

        return result;
    }
}

