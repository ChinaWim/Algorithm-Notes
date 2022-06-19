package leetcode.algorithms.medium.leetcode508;

import java.util.*;

/**
 * @description: 出现次数最多的子树元素和
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * @author:    TIP:经典树形DP
 * @create: 2022-06-19 16:09
 **/
public class Leetcode508{


    public static void main(String[] args){
        Leetcode508 l = new Leetcode508();
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        TreeNode left2 = new TreeNode(6);

        root.left = left;
        root.right = right;
        left.left = left2;
        System.out.println(Arrays.toString(l.findFrequentTreeSum(root)));
    }

    int maxCount = 0;
    Map<Integer,Integer> countMap = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> valueList = new ArrayList<>();
        this.dfs(root);
        for(Map.Entry<Integer,Integer> entry: countMap.entrySet()){
            if(entry.getValue() == maxCount){
                valueList.add(entry.getKey());
            }
        }
        return valueList.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftValue = this.dfs(root.left);
        int rightValue = this.dfs(root.right);

        int sumValue = leftValue + rightValue + root.val;
        int sumValueCount = countMap.getOrDefault(sumValue,0) + 1;
        countMap.put(sumValue,sumValueCount);
        maxCount = Math.max(maxCount,sumValueCount);
        return sumValue;
    }

}
