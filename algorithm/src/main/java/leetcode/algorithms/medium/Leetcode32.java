package leetcode.algorithms.medium;

import java.util.*;

/**
 *剑指 Offer 32 - III. 从上到下打印二叉树 III
 *请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class Leetcode32 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int rootVal = root.val;
        List<Integer> rootRow = new ArrayList<Integer>();
        rootRow.add(rootVal);
        result.add(rootRow);
        int level = 2;
        while(!queue.isEmpty()){
            List<TreeNode> listTemp = new ArrayList<TreeNode>();
            List<Integer> resultRow = new ArrayList<Integer>();
            while(!queue.isEmpty()){
                TreeNode top = queue.poll();
                TreeNode left = top.left;
                TreeNode right = top.right;
                if(left != null){
                    listTemp.add(left);
                }
                if(right != null){
                    listTemp.add(right);
                }
            }

            if(level  % 2 == 0){
                for (int i = listTemp.size() - 1; i >= 0 ; i--) {
                    resultRow.add(listTemp.get(i).val);
                    queue.addFirst(listTemp.get(i));
                }
            }else {
                for (int i = 0; i < listTemp.size(); i++) {
                    resultRow.add(listTemp.get(i).val);
                    queue.add(listTemp.get(i));
                }
            }


            if(resultRow.size() > 0){
                result.add(resultRow);
            }
            level ++;
        }
        return result;
    }
}
