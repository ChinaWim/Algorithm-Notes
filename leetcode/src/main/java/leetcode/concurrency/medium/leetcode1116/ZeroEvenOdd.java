package leetcode.concurrency.medium.leetcode1116;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * [打印零与奇偶数]
 *
 * 假设有这么一个类：
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 *示例 1：
 *
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 *
 *
 *
 */
public class ZeroEvenOdd {
    private volatile int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    private AtomicInteger  atomicX = new AtomicInteger(0);
    private volatile boolean zeroOutFlag = true;
    private volatile boolean oddEvenOutFlag = false;


    // printNumber.accept(x) outputs "x", where x is an integer.
    public  void zero(IntConsumer printNumber) throws InterruptedException {
        while(atomicX.get() <= n){
            if(zeroOutFlag){
                atomicX.incrementAndGet();
                if(atomicX.get() > n){
                    break;
                }
                printNumber.accept(0);
                zeroOutFlag = false;
                oddEvenOutFlag = true;
            }else {
                Thread.yield();
            }

        }
    }

    public  void odd(IntConsumer printNumber) throws InterruptedException {
        while(atomicX.get() <= n){
            if(oddEvenOutFlag && (atomicX.get() & 1) != 0){
                printNumber.accept(atomicX.get());
                zeroOutFlag = true;
                oddEvenOutFlag = false;
            }else {
                Thread.yield();
            }
        }
    }

    public   void even(IntConsumer printNumber) throws InterruptedException {
        while(atomicX.get() <= n){
            if(oddEvenOutFlag && (atomicX.get() & 1) == 0){
                printNumber.accept(atomicX.get());
                zeroOutFlag = true;
                oddEvenOutFlag = false;
            }else {
                Thread.yield();
            }

        }
    }

    public static void main(String[] args) {
//        int a1 = 9 & 1;
//        int a2 = 2 & 1;
//        System.out.println(a1);
//        System.out.println(a2);


        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer intConsumer = new IntConsumer();
        new Thread(() ->{
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
