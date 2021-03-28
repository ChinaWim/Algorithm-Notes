package leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

/**
 * [替换字符串中的括号内容]
 *
 * 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
 *
 * 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
 * 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
 *
 * 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
 *
 * 将 keyi 和括号用对应的值 valuei 替换。
 * 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
 * knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
 *
 * 请你返回替换 所有 括号对后的结果字符串。
 *
 * 示例 1：
 *
 * 输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
 * 输出："bobistwoyearsold"
 * 解释：
 * 键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。
 * 键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
 *
 * 考点：o(n)，不能使用java自带的replace方法
 */
public class Leetcode5714 {

    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> dataMap = new HashMap<>();
        for (List<String> kl : knowledge) {
            String key = kl.get(0);
            String value = kl.get(1);
            dataMap.put(key,value);
        }
        boolean start = false;
        StringBuilder keyBuilder = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                start = false;
                String key = keyBuilder.toString();
                String value = dataMap.get(key);
                resultBuilder.append(value == null ? "?" : value);
            }
            if(start){
                keyBuilder.append(s.charAt(i));
            }else if(s.charAt(i) != ')'){
                resultBuilder.append(s.charAt(i));
            }
            if(s.charAt(i) == '('){
                keyBuilder = new StringBuilder();
                start = true;
            }
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {

    }

}
