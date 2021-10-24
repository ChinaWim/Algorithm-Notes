package leetcode.algorithms.easy;

import java.util.Arrays;

/**
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 *
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 *
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 *
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 * 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
 *
 * 示例：
 *
 * 输入: 4
 * 输出: [2, 2]
 * 解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
 * 但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
 *
 */
public class Leetcode492 {

    /**
     * 笨比方法
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int[] result = new int[]{area,1};
        int hand = (int)Math.ceil(area / 2.0);
        int min = Integer.MAX_VALUE;
        for(int i = hand; i>=1; i--){
            for(int j = 1; j <= i; j++){
                if(i*j > area){
                    break;
                }
                if(i * j == area){
                    int diff = (Math.abs(i - j));
                    if(diff < min){
                        min = diff;
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }

    /**
     *
     * @param area
     * @return
     */
    public int[] constructRectangle2(int area) {
        int max = (int)Math.sqrt(area);
        int x = 1;
        for(int i = max; i >= 1; --i){
            if(area % i == 0){
                x = i;
                break;
            }
        }
        return new int[]{area/x,x};
    }

    public static void main(String[] args) {
        Leetcode492 data = new Leetcode492();
//        System.out.println(Arrays.toString(data.constructRectangle(10000000)));
        System.out.println(Arrays.toString(data.constructRectangle2(1000000000)));


    }
}
