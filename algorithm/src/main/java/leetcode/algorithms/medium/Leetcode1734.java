package leetcode.algorithms.medium;

/**
 *  todo
 * [解码异或后的排列]
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 */
public class Leetcode1734 {

    public int[] decode(int[] encoded) {



        return encoded;
    }



    public static void main(String[] args) {
        Leetcode1734 l = new Leetcode1734();
        int[] decode = new int []{3,1};
        System.out.println(l.decode(decode));
    }
}
