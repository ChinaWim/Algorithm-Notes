package leetcode.algorithms.medium;


import java.util.ArrayList;

/**
 * [旋转链表]
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 考点：简单模运算
 */
public class Leetcode61 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode result = new ListNode();
        ListNode resultTemp = result;
        ArrayList<Integer> sourceList = new ArrayList<>();
        while(head != null){
            sourceList.add(head.val);
            head = head.next;
        }
        int[] newArray = new int[sourceList.size()];
        for(int i = 0 ; i < sourceList.size(); i ++){
            int newIndex = (i+1+k)%sourceList.size();
            newIndex = newIndex == 0 ? sourceList.size() - 1 : newIndex - 1;
            newArray[newIndex] = sourceList.get(i);
        }
        for(int i = 0; i < newArray.length; i ++){
            resultTemp.val = newArray[i];
            if(i != newArray.length - 1){
                resultTemp.next = new ListNode();
                resultTemp = resultTemp.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode61 leetcode = new Leetcode61();
    }
}
