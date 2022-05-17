package leetcode.algorithms.design.chainpattern;

/**
 * @description:
 * @author:
 * @create: 2021-12-14 17:35
 **/
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message){
        System.out.println("ConsoleLogger: " + message);
    }
}
