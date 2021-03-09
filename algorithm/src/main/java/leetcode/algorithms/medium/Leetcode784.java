package leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * [字母大小写全排列]
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *
 * 考点：dfs
 *
 */
public class Leetcode784 {

    public static void main(String[] args) {
        Leetcode784 l = new Leetcode784();
        System.out.println(l.letterCasePermutation("12345"));
    }

    class CharIndex{
        private char c;
        private int i;
        CharIndex(char c,int i){
            this.c = c;
            this.i = i;
        }
    }
    public List<String> letterCasePermutation(String S) {
        ArrayList<CharIndex> charIndexs = new ArrayList<>();
        ArrayList<Character> sChar = new ArrayList<>();
        for(int i = 0; i < S.length(); i ++){
            char charAt = S.charAt(i);
            if((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')){
                CharIndex charIndex = new CharIndex(S.charAt(i),i);
                charIndexs.add(charIndex);
            }
            sChar.add(charAt);
        }
        CharIndex[] array = new CharIndex[charIndexs.size() + 1];
        List<String> result = this.dfs(0, 0, charIndexs, array, sChar);
        result.add(S);
        return result;
    }

    private List<String> dfs(int step, int pos, ArrayList<CharIndex> charIndexs, CharIndex[] array, ArrayList<Character> sChar){
        List<String> result = new ArrayList<>();
        if(step > charIndexs.size()){
            return result;
        }
        if(step > 0){
            HashMap<Integer,CharIndex> indexMap = new HashMap<>();
            for(int i = 0; i < step; i++){
                CharIndex charIndex = array[i];
                indexMap.put(charIndex.i,charIndex);
            }
            StringBuilder newStr = new StringBuilder();
            for(int i = 0; i < sChar.size(); i++){
                Character schar = sChar.get(i);
                if(indexMap.get(i) != null){
                    if((schar >= 'a' && schar <= 'z')){
                        newStr.append(Character.toUpperCase(schar));
                    }else {
                        newStr.append(Character.toLowerCase(schar));
                    }
                }else {
                    newStr.append(schar);
                }
            }
            result.add(newStr.toString());
        }


        for(int i = pos; i < charIndexs.size(); i++){
            array[step] = charIndexs.get(i);
            result.addAll(this.dfs(step + 1,i+1,charIndexs,array,sChar));
        }
        return result;

    }
}
