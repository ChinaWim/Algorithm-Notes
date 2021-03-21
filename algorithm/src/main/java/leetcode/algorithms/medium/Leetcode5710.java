package leetcode.algorithms.medium;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * [积压订单中的订单总数]
 *
 * 给你一个二维整数数组 orders ，其中每个 orders[i] = [pricei, amounti, orderTypei] 表示有 amounti 笔类型为 orderTypei 、价格为 pricei 的订单。
 *
 * 订单类型 orderTypei 可以分为两种：
 *
 * 0 表示这是一批采购订单 buy
 * 1 表示这是一批销售订单 sell
 * 注意，orders[i] 表示一批共计 amounti 笔的独立订单，这些订单的价格和类型相同。对于所有有效的 i ，由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单。
 *
 * 存在由未执行订单组成的 积压订单 。积压订单最初是空的。提交订单时，会发生以下情况：
 *
 * 如果该订单是一笔采购订单 buy ，则可以查看积压订单中价格 最低 的销售订单 sell 。如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell 从积压订单中删除。否则，采购订单 buy 将会添加到积压订单中。
 * 反之亦然，如果该订单是一笔销售订单 sell ，则可以查看积压订单中价格 最高 的采购订单 buy 。如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。否则，销售订单 sell 将会添加到积压订单中。
 * 输入所有订单后，返回积压订单中的 订单总数 。由于数字可能很大，所以需要返回对 109 + 7 取余的结果。
 *
 */
public class Leetcode5710 {

    public static void main(String[] args) {
        Leetcode5710 l = new Leetcode5710();
//        [7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]
        int[][] orders = new int [][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}};
        System.out.println(l.getNumberOfBacklogOrders(orders));
    }

    class  Element implements Comparable{
        int prices;
        int amount;
        @Override
        public int compareTo(Object o) {
            if(o instanceof Element){
                return this.prices - ((Element)o).prices;
            }
            return -1;
        }
        Element(int prices,int amount){
            this.prices = prices;
            this.amount = amount;
        }
    }


    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Element> buyQueue = new PriorityQueue<>((o1, o2) -> o2.prices - o1.prices);
        PriorityQueue<Element> sellQueue = new PriorityQueue<>();
        int result = 0;
        for(int i = 0; i < orders.length; i ++){
            int prices = orders[i][0];
            int amount = orders[i][1];
            int orderType = orders[i][2];
            int tempAmount = amount;

            if(orderType == 0){
                if(sellQueue.isEmpty() || sellQueue.peek().prices > prices ){
                    buyQueue.add(new Element(prices,tempAmount));
                }else {
                    while (true){
                        Element sellTop = sellQueue.peek();
                        if(sellTop.amount > tempAmount ){
                            sellTop.amount = sellTop.amount - tempAmount;
                            tempAmount = 0;
                        }else {
                            tempAmount = tempAmount - sellTop.amount;
                            sellQueue.poll();
                        }
                        if(tempAmount == 0 || sellQueue.isEmpty() || sellQueue.peek().prices > prices){
                            break;
                        }
                    }
                    if(tempAmount > 0){
                        buyQueue.add(new Element(prices,tempAmount));
                    }
                }
            }else {
                if(buyQueue.isEmpty() || buyQueue.peek().prices < prices ){
                    sellQueue.add(new Element(prices,tempAmount));
                }else {
                    while (true){
                        Element buyTop = buyQueue.peek();
                        if(buyTop.amount > tempAmount ){
                            buyTop.amount = buyTop.amount - tempAmount;
                            tempAmount = 0;
                        }else {
                            tempAmount = tempAmount - buyTop.amount;
                            buyQueue.poll();
                        }
                        if(tempAmount == 0 || buyQueue.isEmpty() || buyQueue.peek().prices < prices){
                            break;
                        }
                    }
                    if(tempAmount > 0){
                        sellQueue.add(new Element(prices,tempAmount));
                    }
                }
            }
        }
        int mod = 1000000000 + 7;
        while(!buyQueue.isEmpty()){
            result = (result +buyQueue.poll().amount) % mod;
        }

        while(!sellQueue.isEmpty()){
            result = (result + sellQueue.poll().amount) % mod;
        }
        return result % mod;
    }
}
