package leetcode.algorithms.easy;

/**
 * [实现 strStr()]
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 *示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 *
 */
public class Leetcode28 {

    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack == null || haystack.length() == 0){
            return -1;
        }
        int size = needle.length();
        for(int i = 0; i < haystack.length(); i ++){
            if((i + size) > haystack.length()){
                break;
            }
            boolean allEquals = true;
            int p = 0;
            for(int j = i; j < i+size; j++){
                if(haystack.charAt(j) != needle.charAt(p++)){
                    allEquals = false;
                    break;
                }
            }
            if(allEquals){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode28 demo = new Leetcode28();
        System.out.println(demo.strStr("mississippi", "a"));
    }

}
