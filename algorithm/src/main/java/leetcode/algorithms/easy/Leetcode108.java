package leetcode.algorithms.easy;

/**
 * [将有序数组转换为二叉搜索树]
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 示例 1：
 *
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 *
 */
public class Leetcode108 {

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
        Leetcode108 l = new Leetcode108();
        System.out.println(l.sortedArrayToBST(new int[]{0,1,2,3,4,5}));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }
        int length = nums.length;
        int mid = length / 2;

        TreeNode root = new TreeNode(nums[mid]);
        TreeNode rootResult = root;
        this.dfs(root,nums,true,0,mid - 1);
        this.dfs(root,nums,false,mid + 1,length - 1);
        return rootResult;
    }

    private void dfs(TreeNode root,int[] nums,boolean left,int l, int r){
        if(l > r){
            return;
        }
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if(left){
            root.left = node;
        }else{
            root.right = node;
        }
        this.dfs(node,nums,true,l,mid - 1);
        this.dfs(node,nums,false,mid + 1,r);
    }
}
