package leetcode.algorithms.easy;

/**
 * [回文数]
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 *
 */
public class Leetcode9 {


    public static void main(String[] args) {
     Leetcode9 l = new Leetcode9();
        System.out.println(l.isPalindrome(10));
        System.out.println(l.isPalindrome(101));
        System.out.println(l.isPalindrome(120));
        System.out.println(l.isPalindrome(110));
        System.out.println(l.isPalindrome(20102));


    }


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String strX = String.valueOf(x);
        for (int i = 0; i < strX.length() / 2; i++) {
            if (strX.charAt(i) != strX.charAt(strX.length() -1 - i)) {
                return false;
            }
        }
        return true;
    }


}
