// 118 Pascal's Triangle   https://leetcode.com/problems/pascals-triangle/

// my solution , reference the solution 1...

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        // 宣告一個 可以塞入List<Integer>的List...
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i=0; i<numRows; i++) {
            
            List<Integer> row = new ArrayList<>();
            
            for(int j=0; j<i+1; j++) {
                if(j==0 || j==i) {
                    row.add(1);
                } else {
                    // 取上一個row的值
                    int a = result.get(i-1).get(j-1);
                    int b = result.get(i-1).get(j);
                    
                    row.add(a+b);
                }
            }
            
            result.add(row);
        }
        
        return result;
    }
}

// solution 1, by Shridhish

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0 ; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            
            for(int j = 0; j < i + 1 ; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            result.add(list);
         }
        return result;
      }
}

// solution 2, by rheaxu

public class Solution {
  public List<List<Integer>> generate(int numRows)
  {
    List<List<Integer>> allrows = new ArrayList<List<Integer>>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    for(int i=0;i<numRows;i++)
    {
      row.add(0, 1);
      for(int j=1;j<row.size()-1;j++)
        row.set(j, row.get(j)+row.get(j+1));
      allrows.add(new ArrayList<Integer>(row));
    }
    return allrows;
  }
}

