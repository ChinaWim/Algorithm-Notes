package leetcode.algorithms.easy;


/**
 * [合并两个有序链表]
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 考点：引用变量和对象的关系
 *
 */
public class Leetcode21 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Leetcode21 l = new Leetcode21();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode resultTemp = result;
        while(true){
            if(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    ListNode  resultNext = new ListNode(l1.val);
                    result.next = resultNext;
                    result = resultNext;
                    l1 = l1.next;
                }else if(l1.val > l2.val){
                    ListNode  resultNext = new ListNode(l2.val);
                    result.next = resultNext;
                    result = resultNext;
                    l2 = l2.next;
                }else {
                    ListNode l1n = new ListNode(l1.val);
                    ListNode l2n = new ListNode(l2.val);
                    l1n.next = l2n ;
                    result.next = l1n;
                    result = l2n;
                    l2 = l2.next;
                    l1 = l1.next;
                }
            }else {
                if(l1 != null){
                    result.next = l1;
                }
                if(l2 != null){
                    result.next = l2;
                }
                break;
            }
        }
        return resultTemp.next;
    }


}
