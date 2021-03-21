package leetcode.algorithms.medium;

/** todo
 * [有界数组中指定下标处的最大值]
 *
 *  给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 *
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 *
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 *
 * 示例 1：
 *
 * 输入：n = 4, index = 2,  maxSum = 6
 * 输出：2
 * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
 *
 */
public class Leetcode5711 {


    public static void main(String[] args) {
        Leetcode5711 l = new Leetcode5711();
        System.out.println(l.maxValue(3, 2, 18));
    }

    public int maxValue(int n, int index, int maxSum) {
        int firstMod = maxSum / n;
        int firstModNum = maxSum % n;
        if(firstModNum == 0){
            return firstMod;
        }
        while(firstModNum != 1){

            int secondMod = firstModNum / (firstModNum > 3 ? (firstModNum - 1): (firstModNum));
            int secondModNum = firstModNum % (firstModNum - 1);
            firstMod += secondMod;
            if(secondModNum == 0){
                break;
            }
            firstModNum = secondModNum;
            if(firstModNum == 1){
                firstMod += 1;
            }

        }
        return firstMod;
    }


}
