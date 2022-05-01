package leetcode.algorithms.week.week68;


/**
 * 一个 句子 由一些 单词 以及它们之间的单个空格组成，句子的开头和结尾不会有多余空格。
 *
 * 给你一个字符串数组 sentences ，其中 sentences[i] 表示单个 句子 。
 *
 * 请你返回单个句子里 单词的最多数目 。
 */
public class Leetcode5946 {


    public int mostWordsFound(String[] sentences) {
        int max = 1;
        for (String sentence : sentences) {
            int count  = 1;
            for(int i = 0; i < sentence.length(); i ++){
                if(sentence.charAt(i) == ' '){
                    count++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }



    public static void main(String[] args) {
        Leetcode5946 l = new Leetcode5946();
        System.out.println(l.mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"}));
    }
}
