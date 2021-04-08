package leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * [合并两个有序数组]
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 */
public class Leetcode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < m; i ++){
            queue.add(nums1[i]);
        }
        for(int i = 0; i < n; i ++){
            queue.add(nums2[i]);
        }
        int p = 0;
        while(!queue.isEmpty()){
            nums1[p++] =  queue.poll();
        }
    }

}
