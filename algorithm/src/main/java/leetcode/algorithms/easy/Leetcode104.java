package leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [二叉树的最大深度]
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 考点：树的遍历方式，dfs,bfs
 */
public class Leetcode104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Leetcode104 l = new Leetcode104();
        TreeNode root = new Leetcode104().new TreeNode(3);
        TreeNode rootTemp = root;
    }


    /**
     * 无脑递归
     */
    public int maxDepth(TreeNode root) {
        return this.dfs(root,0);
    }
    public int dfs(TreeNode root,int step){
        if(root == null){
            return step;
        }
        return Math.max(dfs(root.left,step+1),dfs(root.right,step+1));
    }

    /**
     * BFS
     */
    public int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            length ++;
        }
        return length;
    }
}
