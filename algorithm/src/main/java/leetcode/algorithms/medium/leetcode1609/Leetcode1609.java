package leetcode.algorithms.medium.leetcode1609;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * <p>
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 */
public class Leetcode1609 {


    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while(true){
            index ++;
            ArrayList<TreeNode> childList = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                childList.add(node);
            }
            if(childList.size() == 0){
                break;
            }
            int pre = -1;
            for (TreeNode child : childList) {
                int value = child.val;
                if(index % 2 != 0){
                    if (value % 2 != 0 || (pre != -1 && value >= pre)) {
                        return false;
                    }
                }else{
                    if (value % 2 == 0 || (pre != -1 && value <= pre)) {
                        return false;
                    }
                }
                pre = value;
                if(child.left != null){
                    queue.offer(child.left);
                }
                if(child.right != null){
                    queue.offer(child.right);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {


    }
}
