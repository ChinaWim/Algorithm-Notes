package leetcode.algorithms.design.observer;

import leetcode.algorithms.design.observer.Observer;

import java.util.ArrayList;

/**
 * @description:
 * @author:
 * @create: 2021-12-22 14:12
 **/
public abstract class Subject{

    protected ArrayList<Observer> observerList = new ArrayList<>();
    //表示观察者对目标对象（被观察者）开始观察
    public void registerObserver(Observer obs){
        observerList.add(obs);
    }

    public void unRegisterObserver(Observer obs){
        observerList.remove(obs);
    }

    public void notifyAllObserver(){
        for(Observer observer: observerList){
            observer.update(this);
        }

    }


}
