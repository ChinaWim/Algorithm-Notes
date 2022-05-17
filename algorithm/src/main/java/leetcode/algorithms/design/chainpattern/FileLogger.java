package leetcode.algorithms.design.chainpattern;

/**
 * @description:
 * @author:
 * @create: 2021-12-14 17:37
 **/
public class FileLogger  extends AbstractLogger{
    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message){
        System.out.println("FileLogger: " + message);
    }
}
