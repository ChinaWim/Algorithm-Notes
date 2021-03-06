package leetcode.algorithms.easy.leetcode226;

/**
 * [翻转二叉树]
 *
 *翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 */
public class Leetcode226 {

    public TreeNode invertTree(TreeNode root) {
       this.invert(root);
       return root;
    }

    private void invert(TreeNode root){
        if(root != null){
            if(root.left != null && root.right != null){
                TreeNode tempNode = root.left;
                root.left = root.right;
                root.right =  tempNode;
            }
            invert(root.left);
            invert(root.right);
        }
    }


    public static void main(String[] args) {
        Leetcode226 leetcode226 = new Leetcode226();
        TreeNode rootNode = new TreeNode(4);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(2);
        rootNode.right = rightNode;
        rootNode.left = leftNode;

        leetcode226.invertTree(rootNode);
        System.out.println(rootNode);
    }

}
