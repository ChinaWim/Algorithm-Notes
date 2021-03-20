package leetcode.algorithms.easy;

/**
 * [设计停车系统]
 *
 *请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 *
 * 请你实现 ParkingSystem 类：
 *
 * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
 * bool addCar(int carType) 检查是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 *
 *
 * 输入：
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * 输出：
 * [null, true, true, false, false]
 *
 */
public class Leetcode1603 {
    private int big;
    private int medium;
    private int small;

    public static void main(String[] args) {

    }

    public Leetcode1603(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
            switch (carType){
                case 1 : {
                    if(big > 0){
                        big --;
                        return true;
                    }{
                        return false;
                    }
                }
                case 2: {
                    if(medium > 0){
                        medium --;
                        return true;
                    }else {
                        return false;
                    }
                }
                case 3: {
                    if(small > 0){
                        small --;
                        return true;
                    }else {
                        return false;
                    }
                }
            }
            return false;
    }
}
