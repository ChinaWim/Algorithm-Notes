package leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * [面试题 02.01. 移除重复节点]
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 *
 *  提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class Leetcode02_01 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        while(head != null){
            linkedHashSet.add(head.val);
            head = head.next;
        }
        List<Integer> arrayList = new ArrayList<>(linkedHashSet);
        ListNode result = new ListNode(arrayList.get(0));
        ListNode temp = result;
        for (int i = 1; i < arrayList.size(); i++) {
            temp.next = new ListNode(arrayList.get(i));
            temp = temp.next;
        }
       return result;
    }

    /**
     *不使用临时缓存区
     */
    public ListNode removeDuplicateNodes2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode res = head;
        HashSet<Integer> hashSet = new HashSet<>();
        while(head.next != null){
            ListNode next = head.next;
            if(!hashSet.contains(next.val)){
                hashSet.add(next.val);
                head = head.next;
            }else {
                head.next = head.next.next;
            }
        }
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        Leetcode02_01 l = new Leetcode02_01();
//        [1, 2, 3, 3, 2, 1]


    }
}
