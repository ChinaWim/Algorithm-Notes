package leetcode.algorithms.easy;

/**
 * [x 的平方根]
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 *
 * 考点：双指针，二分法
 */
public class Leetcode69 {

    public static void main(String[] args) {
        Leetcode69 l = new Leetcode69();
        System.out.println(l.mySqrt(1));
    }

    public int mySqrt(int x) {
        if(x < 1){
            return x;
        }
        long preL = 1;
        long preR = x/2;
        long l = 1;
        long r = x/2;
        while(l < r){
            long lv = l*l;
            long rv = r*r;
            if(lv == x ){
                return (int) l;
            }
            if(rv == x){
                return (int) r;
            }
            if(lv > x){
                return (int) preL;
            }
            if(rv < x){
                return (int) preR;
            }
            preL = l;
            preR = r;
            l++;
            r++;
        }
        return (int) l;
    }
}
