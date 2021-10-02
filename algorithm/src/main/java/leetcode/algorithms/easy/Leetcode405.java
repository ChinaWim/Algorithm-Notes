package leetcode.algorithms.easy;

import java.util.HashMap;

/**
 * [数字转换为十六进制数]
 * <p>
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * <p>
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 *
 * 【笔记】核心思想，使用位运算，每4位，对应1位16进制数字。
 *
 * 使用0xf(00...01111b)获取num的低4位。
 * >>算数位移，其中正数右移左边补0，负数右移左边补1。
 * 位移运算并不能保证num==0，需要使用32位int保证（对应16进制小于等于8位）。
 * 使用string直接进行字符串拼接....
 *
 * string toHex(int num) {
 *     if (num == 0) return "0";
 *     string hex = "0123456789abcdef", ans = "";
 *     while(num && ans.size() < 8){
 *         ans = hex[num & 0xf] + ans;
 *         num >>=  4;
 *     }
 *     return ans;
 * }
 *
 */
public class Leetcode405 {

    public static void main(String[] args) {
        Leetcode405 leetcode405 = new Leetcode405();
        System.out.println(leetcode405.toHex(-2147483648));

    }

    public String toHex(int num) {
        HashMap<Long, Character> charData = new HashMap<>(6);
        charData.put(10L, 'a');
        charData.put(11L, 'b');
        charData.put(12L, 'c');
        charData.put(13L, 'd');
        charData.put(14L, 'e');
        charData.put(15L, 'f');
        long temp = num;
        if (num < 0) {
            //得到原码
            temp = (long) (Math.pow(2, 32) - Math.abs((long) num));
        }
        StringBuilder result = new StringBuilder();

        while (temp > 0) {
            long a1 = temp / 16;
            long a2 = temp % 16;
            result.append(this.getNumberStr(charData, a2));
            temp = a1;
        }
        return result.reverse().toString();
    }

    private String getNumberStr(HashMap<Long, Character> charData, long num) {
        Character getCharData = charData.get(num);
        if (getCharData != null) {
            return getCharData.toString();
        }
        return String.valueOf(num);
    }

}
