package leetcode.algorithms.design.observer;

import leetcode.algorithms.design.observer.Subject;

/**
 * @description:
 * @author: panweiming panweiming1@shein.com
 * @create: 2021-12-22 14:19
 **/
public class ConcreteSubject extends Subject{
    private int state;
    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
        notifyAllObserver();
    }

}
