package leetcode.algorithms.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * [逆波兰表达式求值]
 *
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 */
public class Leetcode150 {

    public static void main(String[] args) {
        Leetcode150 leetcode150 = new Leetcode150();
        System.out.println(leetcode150.evalRPN(new String[]{"1","2","+","3","4","+","*"}));
    }

    public int evalRPN(String[] tokens) {
        if(tokens.length <= 1){
            return Integer.parseInt(tokens[0]);
        }

        int result = 0;
        List<String> opArrayList = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> value = new Stack<>();
        for (String token : tokens) {
            if (opArrayList.contains(token)) {
               if(value.size() > 1){
                   Integer value1 = value.pop();
                   Integer value2 = value.pop();
                   result = this.op(token, value2, value1);
                   value.push(result);
               }
            } else {
                value.push(Integer.valueOf(token));
            }
        }

        return result;
    }

    private Integer op(String opStr, Integer value1, Integer value2){
        int result = 0;
        switch (opStr){
            case "+":{
                result = value1 + value2;
                break;
            }
            case "-":{
                result = value1 - value2;
                break;
            }
            case "*":{
                result = value1 * value2;
                break;
            }
            case "/":{
                result = value1 / value2;
                break;
            }
        }
        return result;
    }
}
