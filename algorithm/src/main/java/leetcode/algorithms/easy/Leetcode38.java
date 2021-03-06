package leetcode.algorithms.easy;
import java.util.*;

/**
 *
 * [外观数列]
 *
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 *
 *
 *示例 1：
 *
 * 输入：n = 1
 * 输出："1"
 * 解释：这是一个基本样例。
 *
 */
public class Leetcode38 {

    public String countAndSay(int n) {
        ArrayList<String> answer = new ArrayList<>();
        String answer1 = "1";
        answer.add(answer1);
        for(int i = 1; i < n ; i++){
            String preAnswerStr = answer.get(i - 1);
            StringBuilder preFinalAnswerStr = new StringBuilder();
            char preChar = preAnswerStr.charAt(0);
            for(int l = 0; l < preAnswerStr.length(); l ++){
                char data = preAnswerStr.charAt(l);
                if(l != 0 && preChar == data){
                   continue;
                }
                preFinalAnswerStr.append(data);
                preChar = data;
            }
            String preFinalAnswerFinalStr = preFinalAnswerStr.toString();
            StringBuilder finalAnswer = new StringBuilder();
            int index = 0;
            for(int j = 0; j < preFinalAnswerFinalStr.length(); j++){
                int count = 0;
                for(int k = index; k < preAnswerStr.length() ; k++){
                    if(preFinalAnswerFinalStr.charAt(j) != preAnswerStr.charAt(k)){
                        index = k;
                       break;
                    }
                    count++;
                }
                finalAnswer.append(count).append(preFinalAnswerFinalStr.charAt(j));
            }
            answer.add(finalAnswer.toString());
        }
        return answer.get(n);
    }


    /**
     * 第二种做法
     * @param n
     * @return
     */
    public String countAndSay2(int n) {
        ArrayList<String> answer = new ArrayList<>();
        String answer1 = "1";
        answer.add(answer1);
        for(int i = 1; i < n ; i++){
            String preAnswerStr = answer.get(i - 1);
            char pre = preAnswerStr.charAt(0);
            StringBuilder finalAnswer = new StringBuilder();
            for(int j = 0 ; j < preAnswerStr.length(); j++){
                if(j != 0 && pre == preAnswerStr.charAt(j)){
                    continue;
                }
                int count = 0;
                for(int k = j ; k < preAnswerStr.length(); k++){
                    if(preAnswerStr.charAt(k) != preAnswerStr.charAt(j)){
                        break;
                    }
                    count ++;
                }
                pre = preAnswerStr.charAt(j);
                finalAnswer.append(count).append(pre);
            }
            System.out.println(answer);
            answer.add(finalAnswer.toString());
        }
        return answer.get(n - 1);
    }



    public static void main(String[] args) {
        Leetcode38 demo = new Leetcode38();
//        111221
        System.out.println(demo.countAndSay(5));

    }
}
