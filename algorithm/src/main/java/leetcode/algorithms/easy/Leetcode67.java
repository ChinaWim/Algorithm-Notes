package leetcode.algorithms.easy;

/**
 * [二进制求和]
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 *
 */
public class Leetcode67 {

    public static void main(String[] args) {
        Leetcode67 l = new Leetcode67();
        System.out.println(l.addBinary("1010", "1011"));
    }


    public String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        int next = 0;
        int diff = Math.abs(a.length() - b.length());
        StringBuilder zero = new StringBuilder();
        for(int i = 0 ; i < diff ; i++){
            zero.append("0");
        }
        if(a.length() > b.length()){
             b = zero.append(b).toString();
        }else if(a.length() < b.length()){
            a = zero.append(a).toString();
        }

        StringBuilder result = new StringBuilder();
        for(int i = maxLength - 1; i >= 0; i --){
            int aNum =Integer.parseInt(String.valueOf(a.charAt(i)));
            int bNum = Integer.parseInt(String.valueOf(b.charAt(i)));
            int num = (aNum + bNum) + next;
            int m = num % 2;
            next = num / 2;
            result.append(m);
        }
        if(next != 0){
            result.append("1");
        }
        return  result.reverse().toString();
    }
}
