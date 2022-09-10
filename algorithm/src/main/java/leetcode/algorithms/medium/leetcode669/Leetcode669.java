package leetcode.algorithms.medium.leetcode669;



/**
 *
 * [修剪二叉搜索树]
 *
 * <p>
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 */
public class Leetcode669 {




    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        TreeNode result = root;
        if(root.val < low  || root.val > high){
            TreeNode left = trimBST(root.left, low, high);
            TreeNode right = trimBST(root.right, low, high);
            if(left == null && right == null){
                result = null;
            }else {
                result = left == null ? right:left;
            }
        }else {
            result.left = trimBST(root.left, low, high);
            result.right = trimBST(root.right, low, high);
        }
        return result;
    }


    public static void main(String[] args) {
        Leetcode669 l = new Leetcode669();
        TreeNode treeNode = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        treeNode.right = r;
        System.out.println(l.trimBST(treeNode, 2, 4));
    }
}
