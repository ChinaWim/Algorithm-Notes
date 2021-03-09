package leetcode.algorithms.easy;

import java.util.Stack;

/**
 * [删除字符串中的所有相邻重复项]
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 */
public class Leetcode1047 {

    public static void main(String[] args) {
        Leetcode1047 leet = new Leetcode1047();
        System.out.println(leet.removeDuplicates("aaacccbbb"));

    }

    public String removeDuplicates(String S) {
        if(S.length() == 1){
            return S;
        }
        do{
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < S.length(); i++){
                if(stack.isEmpty() || !stack.peek().equals(S.charAt(i))){
                    stack.push(S.charAt(i));
                }else {
                    stack.pop();
                }
            }
            if(stack.size() == S.length()){
                break;
            }
            StringBuilder newString = new StringBuilder();
            while(!stack.isEmpty()){
                newString.append(stack.pop());
            }
            S = newString.reverse().toString();
        }while (true);
        return S;
    }
}
