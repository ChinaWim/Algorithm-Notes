 package leetcode.algorithms.medium;

/**
 * [下标对中的最大距离]
 *
 * 给你两个 非递增 的整数数组 nums1​​​​​​ 和 nums2​​​​​​ ，数组下标均 从 0 开始 计数。
 *
 * 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i​​ 。​​
 *
 * 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
 *
 * 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
 *
 *示例 1：
 *
 * 输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
 * 输出：2
 * 解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
 * 最大距离是 2 ，对应下标对 (2,4) 。
 *
 */
public class Leetcode5751 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int curIndex = -1;
        int maxDistance = 0;
        for(int i = 0; i < nums1.length; i ++){
            if(curIndex != - 1){
                for(int j = curIndex; j < nums2.length; j ++){
                    if(nums2[j]< nums1[i]){
                        break;
                    }else {
                        curIndex = j;
                        maxDistance = Math.max(maxDistance,j - i);
                    }
                }
            }else {
                for(int j = nums2.length - 1; j>=0; j --){
                    if(nums2[j]>=nums1[i]){
                        curIndex = j;
                        maxDistance = Math.max(maxDistance,j - i);
                        break;
                    }
                }
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        Leetcode5751 l = new Leetcode5751();
        System.out.println(l.maxDistance(new int[]{5,4}, new int[]{3,2}));
        System.out.println(l.maxDistance(new int[]{30,29,19,5}, new int[]{25,25,25,25,25}));
        System.out.println(l.maxDistance(new int[]{2,2,2}, new int[]{10,10,1}));
        System.out.println(l.maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));

    }
}
