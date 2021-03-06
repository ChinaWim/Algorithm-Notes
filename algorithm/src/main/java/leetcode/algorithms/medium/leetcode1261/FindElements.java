package leetcode.algorithms.medium.leetcode1261;
import java.util.ArrayList;

/**
 * [在受污染的二叉树中查找元素]
 *
 * 给出一个满足下述规则的二叉树：
 *
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 *
 * 请你先还原二叉树，然后实现 FindElements 类：
 *
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 *
 * 输入：
 * ["FindElements","find","find"]
 * [[[-1,null,-1]],[1],[2]]
 * 输出：
 * [null,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1]);
 * findElements.find(1); // return False
 * findElements.find(2); // return True
 *
 *
 */
class FindElements {

    private ArrayList<Integer> recoverData = new ArrayList<>();

    public FindElements(TreeNode root) {
        recover(root,0);
    }


    private void recover(TreeNode root,int val){
        if(root != null){
            root.val = val;
            recoverData.add(val);
            recover(root.left,root.val * 2 + 1);
            recover(root.right,root.val * 2 + 2);
        }
    }

    
    public boolean find(int target) {
        return recoverData.contains(target);
    }

}