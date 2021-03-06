package leetcode.algorithms.medium.leetcode2;
import java.math.BigDecimal;

/**
 * [两数相加]
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 */
public class Leetcode2 {

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String number1 = sum(l1);
        String number2 = sum(l2);
        BigDecimal bigDecimal1 = new BigDecimal(number1);
        BigDecimal bigDecimal2 = new BigDecimal(number2);
        BigDecimal bigDecimal3 = bigDecimal1.add(bigDecimal2);
        String total = bigDecimal3.toString();
        ListNode totalNodeHead = new ListNode(0);
        ListNode totalNodeTemp = new ListNode(0);

        for (int i = total.length() - 1; i >= 0 ; i--) {
            int pos = Integer.parseInt(total.charAt(i)+"");
            if(i == total.length() - 1){
                totalNodeHead.val = pos;
                if(i != 0){
                    totalNodeHead.next = totalNodeTemp;
                }

            }else {
                totalNodeTemp.val = pos;
                if(i != 0){
                    totalNodeTemp.next = new ListNode(0);
                    totalNodeTemp = totalNodeTemp.next;
                }
            }
        }
        return totalNodeHead;
    }

    private  String sum(ListNode l) {
        ListNode temp = l;
        long sum = 0;
        StringBuilder number = new StringBuilder();
        while (temp != null) {
            number.append(temp.val);
            temp = temp.next;
        }
        return number.reverse().toString();
    }
}
