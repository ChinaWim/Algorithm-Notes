package leetcode.algorithms.medium;
import java.util.HashSet;
import java.util.Set;


/**
 * [活字印刷]
 *
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 * 注意：本题中，每个活字字模只能使用一次。
 *
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 *
 */
public class Leetcode1079 {

    static int[] box = new int[500];
    static char[] value = new char[500];

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        dfs(0, tiles, set);
        return set.size();
    }




    public void dfs(int step, String tiles, Set<String> set) {
        if (step > 0) {
            StringBuilder valueBuffer = new StringBuilder();
            for (int i = 0; i < step; i++) {
                valueBuffer.append(value[i]);
            }
            set.add(valueBuffer.toString());

        }
        for (int i = 0; i < tiles.length(); i++) {
            if (box[i] == 0) {
                box[i] = 1;
                value[step] = tiles.charAt(i);
                dfs(step + 1, tiles, set);
                box[i] = 0;
            }
        }
    }

}
