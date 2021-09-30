package leetcode.algorithms.medium;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 */
public class Leetcode451 {
    class Node implements Comparable{
        private Character value;
        private Integer count;
        Node(Character value,Integer count){
            this.value = value;
            this.count = count;
        }

        public int compareTo(Object o) {
            Node other = (Node) o;
            int integerCompare = Integer.compare(other.count, this.count);
            if( integerCompare == 0){
                return Character.compare(other.value,this.value);
            }
            return integerCompare;
        }
    }

    public String frequencySort(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        TreeMap<Character,Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < s.length(); i ++) {
            Integer count = treeMap.get(s.charAt(i));
            count = count == null ? 0 : count;
            treeMap.put(s.charAt(i),count + 1);
        }
        TreeSet<Node> treeSet = new TreeSet<>();
        treeMap.forEach((k,v)->{
            treeSet.add(new Node(k,v));
        });
        StringBuilder sb = new StringBuilder();
        for (Node node : treeSet) {
            for(int i = 0; i < node.count; i ++){
                sb.append(node.value);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Leetcode451 l = new Leetcode451();
        System.out.println(l.frequencySort("abbaAaA"));

    }
}
