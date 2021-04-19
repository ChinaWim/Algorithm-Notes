package leetcode.algorithms.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [相同的树]
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 */
public class Leetcode100 {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(node1.val != node2.val){
                return false;
            }
            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;
            if(left1 != null && left2 == null || left2 != null && left1 == null){
                return false;
            }
            if(right1 != null && right2 == null || right2 != null && right1 == null){
                 return false;
            }

            if(left1 != null){
                queue1.add(left1);
            }
            if(right1 != null){
                queue1.add(right1);
            }
            if(left2 != null){
                queue2.add(left2);
            }
            if(right2 != null){
                queue2.add(right2);
            }
            if(queue1.size() != queue2.size()){
                return false;
            }
        }
        return true;
    }

}
