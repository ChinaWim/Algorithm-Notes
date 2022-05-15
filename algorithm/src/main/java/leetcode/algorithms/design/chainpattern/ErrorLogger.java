package leetcode.algorithms.design.chainpattern;

/**
 * @description:
 * @author: panweiming panweiming1@shein.com
 * @create: 2021-12-14 17:36
 **/
public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message){
        System.out.println("ErrorLogger: " + message);
    }
}
