package leetcode.algorithms.medium;

/**
 * @Description:
 * @Author panweiming Email:panweiming@shein.com
 * @Date create in 2021/5/30 10:59
 */
public class Leetcode5773 {
    public String maxValue(String n, int x) {
        StringBuilder result = new StringBuilder();
        if(n.charAt(0) == '-'){
            result.append("-");
            boolean flag = false;
            for(int i = 1; i < n.length(); i ++){
                Integer indexValue = (int) n.charAt(i) - 48;
                if (indexValue > x && !flag) {
                    result.append(x).append(indexValue);
                    flag = true;
                }else {
                    result.append(indexValue);
                }
            }
            if(!flag){
                result.append(x);
            }
        }else {
            boolean flag = false;
            for (int i = 0; i < n.length(); i ++) {
                Integer indexValue = (int) n.charAt(i) - 48;
                if (indexValue < x && !flag) {
                    result.append(x).append(indexValue);
                    flag = true;
                }else {
                    result.append(indexValue);
                }
            }
            if(!flag){
                result.append(x);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Leetcode5773 l = new Leetcode5773();
        System.out.println(l.maxValue("-132", 3));
    }
}
