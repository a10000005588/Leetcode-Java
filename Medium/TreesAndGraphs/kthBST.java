// 230 Kth Smallest Element in a BST    

// my solution

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        int count = 0; // count kth smallest...
        while(!stack.empty() || root != null) {
            
            if(root != null) {
                stack.push(root);
                root = root.left;
                continue;
            }
            
            TreeNode cur = stack.pop();
            count++;
            if(count == k) return cur.val;
            
            root = cur.right;
            
        }
        return 0;
        
    }
}