package leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [二叉搜索树节点最小距离]
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 */
public class Leetcode783 {

    private int min = Integer.MAX_VALUE;
    private int pre = -1;

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

    public static void main(String[] args) {

    }

    /**
     * 我的思路漏一步，边中序遍历边判断
     *
     */
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>();
        this.m(root,values);
        int min = Integer.MAX_VALUE;
       for(int i = 0; i < values.size() - 1; i ++){
           min = Math.min(min,Math.abs(values.get(i) - values.get(i + 1)));
       }
       return min;
    }

    private void m(TreeNode root,ArrayList<Integer> arrayList){
      if(root != null){
          this.m(root.left,arrayList);
          arrayList.add(root.val);
          this.m(root.right,arrayList);
      }
    }

    /**
     * 正确做法
     */
    public int minDiffInBST2(TreeNode root) {
        this.m2(root);
        return min;
    }
    private void m2(TreeNode root){
        if(root != null){
            this.m2(root.left);
            if(pre != -1){
                min = Math.min(Math.abs(root.val - pre),min);
            }
            pre = root.val;
            this.m2(root.right);
        }
    }


}
