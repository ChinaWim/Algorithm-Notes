package leetcode.algorithms.medium;
import java.util.ArrayList;
import java.util.List;

/**
 * [划分字母区间]
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 */
public class Leetcode763 {
    public static void main(String[] args) {
        Leetcode763 leetcode763 = new Leetcode763();
        System.out.println(leetcode763.partitionLabels("qiejxqfnqceocmy"));
    }

    public List<Integer> partitionLabels(String S) {
        int[] sIndex = new int [S.length()];
        for(int i = 0; i < S.length(); i++){
            char curChar = S.charAt(i);
            int lastIndex = S.lastIndexOf(curChar);
            sIndex[i] = lastIndex == -1 ? i:lastIndex;
        }
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i< sIndex.length){
            char curChar = S.charAt(sIndex[i]);
            int lastIndex = S.lastIndexOf(curChar);

            int maxIndex = lastIndex;
            for(int j = i; j <= lastIndex; j ++){
                maxIndex = Math.max(maxIndex,sIndex[j]);
            }
            while(true){
                int secondMax = maxIndex;
                for(int k = lastIndex + 1; k <= maxIndex;k ++){
                    secondMax = Math.max(secondMax, sIndex[k]);
                }
                if(secondMax == maxIndex){
                    break;
                }
                int temp = maxIndex;
                maxIndex = secondMax;
                lastIndex = temp;
            }

            int size = (maxIndex - i) + 1;
            result.add(size);
            i = i + size;
        }
        return result;
    }

}
