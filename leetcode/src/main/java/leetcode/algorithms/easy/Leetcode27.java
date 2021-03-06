package leetcode.algorithms.easy;

/**
 * [移除元素]
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 */
public class Leetcode27 {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int count = 0;
        int p = nums.length;
        boolean temp = true;
        while(temp){
            boolean temp2 = false;
            for(int i = 0; i < p ; i ++){
                if(nums [i] == val){
                    int index = p - 1;
                    nums [i] = nums[index];
                    p -- ;
                    count ++;
                    temp2 = true;
                    break;
                }
            }
            if(!temp2){
                break;
            }

        }
        return nums.length - count;
    }


    public static void main(String[] args) {
        Leetcode27 a = new Leetcode27();
        int []nums = new int []{0,1,2,2,3,0,4,2};
        int count = a.removeElement(nums, 0);
        for(int i = 0 ; i < count ; i++){
            System.out.print(nums[i] +" ");
        }
    }
}
