// 103  Binary Tree Zigzag Level Order Traversal
// reference: https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/discuss/33815/My-accepted-JAVA-solution
// tip: using List (store the result) and Linkedlist (store each level...)
class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) { 
        // Should not new with ArrayList<List<Integer>> , because we use <LinkedList<Integer>> instead
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }
    
    public void travel(TreeNode node, List<List<Integer>> res, int level) {
        if(node == null) return;
        
        if(res.size() <= level) {
            List<Integer> newList = new LinkedList<Integer>();
            res.add(newList);
        }
        
        List<Integer> currList = res.get(level);
        
        if(level%2==0) {
            currList.add(node.val);
        } else {
            currList.add(0, node.val);
        }
        
        travel(node.left, res, level+1);
        travel(node.right, res, level+1);
    }
    
}