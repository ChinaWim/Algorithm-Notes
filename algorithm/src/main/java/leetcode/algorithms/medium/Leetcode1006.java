package leetcode.algorithms.medium;

import java.util.Stack;

/**
 * [笨阶乘]
 *
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 *
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 *
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 *
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 *
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 * tags:模拟题
 *
 */
public class Leetcode1006 {

    public static void main(String[] args) {
        Leetcode1006 l = new Leetcode1006();
        System.out.println(l.clumsy(5));
    }

    public int clumsy(int N) {
     if(N == 1){
         return 1;
     }
     int count = 0;
     int sumTemp = 0;
     Stack<Integer> sumStack = new Stack<>();
     for(int i = N - 1; i >= 1; i--){
        if(count == 0){
            sumTemp = i * (i + 1);
        }else if(count == 1){
            sumTemp = sumTemp / i;
        }else if(count == 2){
            if(!sumStack.isEmpty()){
                Integer topSum = sumStack.pop();
                sumTemp = topSum - sumTemp;
            }
            sumTemp = sumTemp + i;
        }else if(count == 3){
            sumStack.push(sumTemp);
            sumTemp = i;
        }
        count = (++count) % 4;
     }
     if(!sumStack.isEmpty()){
         return sumStack.pop() - sumTemp;
     }
     return sumTemp;
    }

}
