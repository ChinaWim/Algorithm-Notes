package leetcode.algorithms.medium.leetcode173;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * [二叉搜索树迭代器]
 *
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 *
 * 输入
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 *
 * 解释
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // 返回 3
 * bSTIterator.next();    // 返回 7
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 9
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 15
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 20
 * bSTIterator.hasNext(); // 返回 False
 *
 * 考点：二叉树的4种遍历 前、中、后、层，使用非递归方式实现。
 *
 */
public class BSTIterator {
  Queue<Integer> queue = new LinkedList<>();
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

    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !stack.isEmpty()){
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            if(!stack.isEmpty()){
                TreeNode treeNode = stack.pop();
                queue.add(treeNode.val);
                temp = treeNode.right;
            }
        }
    }

//    解法2
//    public BSTIterator(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode temp = root;
//        while(temp != null || !stack.isEmpty()){
//            if(temp != null){
//                stack.push(temp);
//                temp = temp.left;
//            }else{
//                TreeNode treeNode = stack.pop();
//                queue.add(treeNode.val);
//                temp = treeNode.right;
//            }
//        }
//    }

    public int next() {
        return queue.isEmpty() ? -1 : queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {

    }
}
