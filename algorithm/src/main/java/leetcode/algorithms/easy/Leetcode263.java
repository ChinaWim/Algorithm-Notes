package leetcode.algorithms.easy;

/**
 * [丑数]
 *
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数
 *
 * 示例 1:
 *
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 *
 */
public class Leetcode263 {
    public static void main(String[] args) {
        Leetcode263 a = new Leetcode263();
        System.out.println(a.isUgly(6));
    }
    public boolean isUgly(int num) {
        if(num < 1){
            return false;
        }
        if(num == 1){
            return true;
        }
        int temp = num;
        while(temp != 1){
            boolean has = false;
            for(int i = 2; i <= 5; i ++){
                if(temp % i == 0){
                    temp = temp / i;
                    if(i == 4){
                        return false;
                    }
                    has = true;
                    break;
                }
            }
            if(!has){
                return false;
            }
        }
        return true;
    }
}
