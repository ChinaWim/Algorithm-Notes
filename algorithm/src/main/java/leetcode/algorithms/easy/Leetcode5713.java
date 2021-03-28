package leetcode.algorithms.easy;

import java.util.Arrays;

/**
 * [字符串中不同整数的数目]
 *
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 *
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。
 *
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 *
 * 如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。
 *
 * 示例 1：
 *
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 *
 * record：此题wa了3次。。
 */
public class Leetcode5713 {

    public int numDifferentIntegers(String word) {
        String[] numArray = word.replaceAll("[a-z]", " ").split(" ");
        return (int)Arrays.stream(numArray).filter(data -> {return data.length() != 0;}).map(data -> {
            if(data.charAt(0) != '0'){
                return data;
            }else{
                return data.replaceFirst("0+", "");
            }
        }).distinct().count();
    }

    public static void main(String[] args) {
        Leetcode5713 l = new Leetcode5713();
        System.out.println(l.numDifferentIntegers("a1b01c001"));
    }
}
