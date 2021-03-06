package leetcode.algorithms.medium;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * [括号生成]
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 */
public class Leetcode22 {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        Leetcode22 l = new Leetcode22();
        System.out.println(l.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
            dfs(0,0,n,"",resultList);
            return resultList;
    }

    private void dfs(int left,int right,int n,String buffer,List<String> allList){
        if(left+right > 2*n){

            return;
        }
        if(left == n && right == n){
            if(check2(buffer.toCharArray())){
                allList.add(buffer);
            }
            return;
        }
        dfs(left + 1,right,n,buffer+"(",allList);
        dfs(left,right+1,n,buffer+")",allList);



    }

//      private boolean check(char[] source){
//        Stack<String> stack = new Stack<>();
//        for(int i = 0; i < source.length; i ++){
//            if(source[i] == '('){
//                stack.push("(");
//            }else {
//                if(!stack.isEmpty()){
//                    stack. pop();
//                }
//            }
//        }
//        if(stack.isEmpty()){
//            return true;
//        }
//        return false;
//    }

    private boolean check2(char[] source){
        int value = 0;
        for(int i = 0; i < source.length; i ++){
            value = source[i]== '('? ++value:value == 0 ? value:--value;
        }
        return value == 0;
    }




}
