// 94 Binary Tree Inorder Traversal

// my solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
            
        while(!stack.empty() || root != null) {
            // check whether the left tree is null or not;
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
          
            root = stack.pop(); 
            result.add(root.val);

            // 不能加判斷式....
            // if(root.right != null) {
                root = root.right;
            // }
        }
        
        return result;
    }
}