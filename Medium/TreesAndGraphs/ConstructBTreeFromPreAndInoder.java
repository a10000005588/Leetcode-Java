// 105  Construct Binary Tree from Preorder and Inorder Traversal


// other solution...  https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/discuss/34538/My-Accepted-Java-Solution

public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}

// 會有 prestart 負責記錄 目前的preorder list中 哪一個index是 該subarray的root....
// inStart, inEnd 定義了 subarray的開頭 和 結尾....
public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0; // Index of current root in inorder
    // 從目前的 sub array中找出 root
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
        }
    }
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;
}