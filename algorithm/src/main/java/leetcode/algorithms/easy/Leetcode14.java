package leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * [最长公共前缀]
 *
 *编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 *
 */
public class Leetcode14 {

    public static void main(String[] args) {

        Leetcode14 l = new Leetcode14();
        System.out.println(l.longestCommonPrefix(new String[]{"aca","cba"}));
    }


    public String longestCommonPrefix(String[] strs) {
        String result = "";
        String minStr = "";
        int min = Integer.MAX_VALUE;
        List<String> stringList = new ArrayList<>();
        for (String str : strs) {
            if ("".endsWith(str)) {
                return "";
            }
            if (str.length() < min) {
                min = str.length();
                minStr = str;
            }
            stringList.add(str);
        }
        stringList.remove(minStr);
        int maxLength = 0;
            for (int j = 0; j < minStr.length(); j++) {
                String subStr = minStr.substring(0, j + 1);
                boolean isWith = true;
                for (String str : stringList) {
                    if (!str.startsWith(subStr)) {
                        isWith = false;
                        break;
                    }
                }
                if(isWith && subStr.length() > maxLength){
                    maxLength = subStr.length();
                    result = subStr;
                }
            }
       return result;
    }
}
