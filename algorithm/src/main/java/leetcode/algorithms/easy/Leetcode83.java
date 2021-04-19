package leetcode.algorithms.easy;

/**
 * [删除排序链表中的重复元素]
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class Leetcode83 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        int pre = head.val;
        ListNode newHead = new ListNode(pre);
        ListNode newHeadTemp = newHead;
        while(head != null){
            if(head.val != pre){
                ListNode nextListNode = new ListNode(head.val);
                newHead.next = nextListNode;
                newHead = nextListNode;
            }
            pre = head.val;
            head = head.next;
        }
        return newHeadTemp;
    }

    public static void main(String[] args) {

    }

}
