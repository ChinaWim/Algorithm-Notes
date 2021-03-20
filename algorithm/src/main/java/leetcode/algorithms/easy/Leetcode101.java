package leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [对称二叉树]
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *   1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *  解题思路：递归或迭代
 */

public class Leetcode101 {

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

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return this.dg(root.left,root.right);
    }
    private boolean isHuiWen(ArrayList<Integer> valueList){
        for(int i = 0; i < valueList.size() / 2; i ++){
            if(!valueList.get(i).equals(valueList.get(valueList.size() - 1 - i))){
                return false;
            }
        }
        return true;
    }

    //错误解法1
    private ArrayList<Integer> midForEach(TreeNode root){
        ArrayList<Integer> valueList = new ArrayList<>();
        if(root.left == null && root.right == null){
           return valueList;
        }
        if(root.left == null){
            root.left = new TreeNode(-1);
        }
        if(root.right == null){
            root.right = new TreeNode(-1);
        }


        valueList.addAll(midForEach(root.left));
        valueList.add(root.val);
        valueList.addAll(midForEach(root.right));
        return valueList;
    }

    //错误解法2
    private boolean bfs(TreeNode root){
        ArrayList<Integer> valueList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root== null){
            return true;
        }
        int p = 3;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                valueList.add(node.val);
                if(valueList.size() == p){
                    valueList.remove(0);
                    if(p == 3){
                        p = p - 1;
                    }
                    boolean huiWen = this.isHuiWen(valueList);
                    if(!huiWen){
                        return false;
                    }
                    valueList = new ArrayList<>();
                    p = p*p;
                }

                if(node.left == null && node.right != null){
                    node.left = new TreeNode(-1);
                }
                if(node.right == null && node.left != null){
                    node.right = new TreeNode(-1);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return true;
    }


    //递归 正确解法
    private boolean dg(TreeNode root1,TreeNode root2){
            if(root1 == null && root2 == null){
                return true;
            }
            if(!(root1 != null && root2 != null) || root1.val != root2.val){
                return false;
            }
            return dg(root1.left, root2.right) && dg(root1.right,root2.left);
    }

    //非递归解法 正确解法
    private boolean queue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null ||  right == null || left.val != right.val ){
                    return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }




}
