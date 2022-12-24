package leetcode.algorithms.acwing;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * 给定一个由小写字母组成的字符串，请你统计其中包含的不同小写字母数量。
 *
 * 如果给定字符串中包含奇数个不同小写字母，则输出 odd。
 *
 * 如果给定字符串中包含偶数个不同小写字母，则输出 even。
 *
 */
public class Acwing4785 {

    public static void main(String[] args) {
      Scanner cin = new Scanner(System.in);
        String next = cin.next();
        HashSet<Character> characterSet = new HashSet();
        for(int i = 0; i < next.length(); i ++){
            characterSet.add(next.charAt(i));
        }
        System.out.println(characterSet.size() % 2 == 0 ? "even":"odd");
    }
}
