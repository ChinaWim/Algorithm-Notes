package leetcode.algorithms.easy;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * [有效的括号]
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 输入：s = "()"
 * 输出：true
 *
 *
 */
public class Leetcode20 {


    public boolean isValid(String s) {
        if(StringUtils.isBlank(s)){
            return true;
        }
       Stack<Character> result = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                result.push(s.charAt(i));
            }else {
                if(result.isEmpty()){
                    return false;
                }
                Character pop = result.pop();
                if(!(pop == '(' && s.charAt(i) == ')' ||
                        pop == '{' && s.charAt(i) == '}' ||
                        pop == '[' && s.charAt(i) == ']')){
                    return false;
                }
            }
        }
            return result.isEmpty();
    }


}
