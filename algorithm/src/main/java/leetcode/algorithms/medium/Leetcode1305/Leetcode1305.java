package leetcode.algorithms.medium.Leetcode1305;

import leetcode.algorithms.medium.leetcode173.BSTIterator;

import java.util.*;

/**
 * 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 *
 * Tip:最快的办法：中序遍历+归并排序
 *
 */
public class Leetcode1305 {




    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 2;
        TreeNode left = new TreeNode();
        left.val = 1;
        TreeNode right = new TreeNode();
        right.val = 4;
        root.left = left;
        root.right = right;

        Leetcode1305  demo = new Leetcode1305();
    }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = this.packageList(root1);
        List<Integer> list2 = this.packageList(root2);
        return this.merge(list1,list2);
    }

    /**
     * 归并
     * @param list1
     * @param list2
     * @return
     */
    public List<Integer> merge(List<Integer> list1,List<Integer> list2){
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < list1.size() &&  j < list2.size()){
            Integer leftValue = list1.get(i);
            Integer rightValue = list2.get(j);
            if(leftValue < rightValue){
                result.add(leftValue);
                i++;
            }else if(leftValue.equals(rightValue)){
                result.add(rightValue);
                result.add(leftValue);
                i++;
                j++;
            }else {
                result.add(rightValue);
                j++;
            }

        }
        if(i < list1.size()){
            for (int p = i; p <list1.size(); p++) {
                result.add(list1.get(p));
            }
        }
        if(j < list2.size()){
            for (int p = j; p <list2.size(); p++) {
                result.add(list2.get(p));
            }
        }
        return result;
    }




    /**
     * 中序遍历
     * @param root
     */
    private List<Integer> packageList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !stack.isEmpty()){
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            if(!stack.isEmpty()){
                TreeNode treeNode = stack.pop();
                list.add(treeNode.val);
                temp = treeNode.right;
            }
        }
        return list;
    }

}
