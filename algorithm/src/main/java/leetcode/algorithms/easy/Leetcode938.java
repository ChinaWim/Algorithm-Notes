package leetcode.algorithms.easy;

/**
 * [二叉搜索树的范围和]
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * 示例 1：
 *
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 */
public class Leetcode938 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        for(int i = low; i <= high; i ++){
            sum += this.getValue(root,i);
        }
        return sum;
    }

    private int getValue(TreeNode root,int v){
        if(root != null){
            if(root.val == v){
                return v;
            }
            if(v > root.val){
                return this.getValue(root.right,v);
            }else {
                return this.getValue(root.left,v);
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Leetcode938 l = new Leetcode938();
    }
}
