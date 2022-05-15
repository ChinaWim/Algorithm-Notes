package leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * @author: panweiming panweiming1@shein.com
 * @create: 2021-12-03 15:03
 **/
public class Leetcode25{

    public class ListNode{
        int val;
        ListNode next;

        ListNode(){
        }

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1,ListNode l2){

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        this.buildList(l1,stack1);
        this.buildList(l2,stack2);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(!stack1.isEmpty()){
            list1.add(stack1.pop());
        }
        while(!stack2.isEmpty()){
            list2.add(stack2.pop());
        }
        int maxLength = Math.max(list1.size(), list2.size());
        List<Integer> result = new ArrayList<>();
        int nextVal = 0;
        for(int i = 0;i < maxLength;i++){
            int add1 = i > list1.size() - 1?0:list1.get(i);
            int add2 = i > list2.size() - 1?0:list2.get(i);
            int addV = nextVal + add1 + add2;
            int curNum = addV % 10;
            nextVal = addV / 10;
            result.add(curNum);
        }
        if(nextVal != 0){
            result.add(nextVal);
        }

        return this.buildResult(result);
    }

    private ListNode buildResult(List<Integer> result){
        ListNode root = new ListNode();
        ListNode rootTemp = root;
        for(int i = result.size() - 1; i >= 0 ; i --){
            rootTemp.val = result.get(i);
            if(i != 0){
                rootTemp.next = new ListNode();
                rootTemp = rootTemp.next;
            }
        }
        return root;
    }

    private void buildList(ListNode l1,Stack<Integer> target){
        if(l1 == null){
            return;
        }
        while(l1 != null){
            target.push(l1.val);
            l1 = l1.next;
        }
    }

    public static void main(String[] args){


    }
}
