package leetcode.algorithms.design.chainpattern;

/**
 * @description:
 * @author:
 * @create: 2021-12-14 17:38
 **/
public class ChainPatternDemo{


    public static void main(String[] args){
        AbstractLogger errorChain = getChainOfLoggers();
        errorChain.logMessage(AbstractLogger.INFO, "info");
//        errorChain.logMessage(AbstractLogger.DEBUG,"debug");
//        errorChain.logMessage(AbstractLogger.ERROR,"error");
    }


    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
}

