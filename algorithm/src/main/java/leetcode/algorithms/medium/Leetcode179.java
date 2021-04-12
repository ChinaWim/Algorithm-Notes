package leetcode.algorithms.medium;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * [最大数]
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 考点：自定义排序，s1+s2 compare s2+s1
 *
 *
 */
public class Leetcode179 {

    public static void main(String[] args) {
        Leetcode179 l = new Leetcode179();
        int[] nums = new int[]{111311, 1113};
        //65440302910
        System.out.println(l.largestNumber2(nums));
    }

    class Num implements Comparable{
        private String num;
        private Integer index;
        private Integer length;
        Num(String num,Integer index,Integer length){
            this.num = num;
            this.index = index;
            this.length = length;
        }
        @Override
        public int compareTo(Object o) {
            Num no = (Num) o;
            int numCompare = no.num.compareTo(this.num);
            if(numCompare == 0){
                String tempNum = this.num;
                String tempNo = no.num;
                if(tempNum.length() != this.length){
                    double times = Math.abs(tempNum.length() - this.length);
                    tempNum = String.valueOf(Integer.parseInt(tempNum) / (int)(Math.pow(10,times)));
                }
                if(tempNo.length() != no.length){
                    double times = Math.abs(tempNo.length() - no.length);
                    tempNo = String.valueOf(Integer.parseInt(tempNo) / (int)(Math.pow(10,times)));
                }
                String newNum1 = tempNo.concat(tempNum);
                String newNum2 = tempNum.concat(tempNo);
                return newNum1.compareTo(newNum2);
            }

            return  numCompare ;
        }
    }

    public String largestNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        int max = nums[0];
        for (int i = 0; i < nums.length; i ++) {
            max = Math.max(nums[i],max);
        }
        Num[] numString = new Num[nums.length];
        int[] indexTimes = new int[nums.length];
        int maxLength = String.valueOf(max).length();
        for(int i = 0; i < nums.length; i ++){
            int indexNum = nums[i];
            String indexNumString = String.valueOf(indexNum);
            int indexLength = indexNumString.length();
            double times = maxLength - indexLength;
            indexTimes[i] = (int) times;
            StringBuilder addIndexNum = new StringBuilder(indexNumString);
            for(int j = 0; j < times; j ++){
                addIndexNum.append(indexNumString.charAt(j % indexLength));
            }
            numString[i] = new Num(addIndexNum.toString(),i,indexLength);
        }
        Arrays.sort(numString);
        for(int i = 0; i < numString.length; i ++){
            Integer num = Integer.valueOf(numString[i].num);
            if(num == 0 && i < nums.length - 1 && result.length() == 0){
                continue;
            }
            int indexTime = indexTimes[numString[i].index];
            if(indexTime > 0){
                num = num / (int)(Math.pow(10,indexTime));
            }
            result.append(num);
        }
        return result.toString();
    }


    //正确做法:
    public String largestNumber2(int[] nums) {
        String[] data = new String[nums.length];
        for(int i = 0; i < nums.length; i ++){
            data[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(data, (o1, o2) -> -(o1+o2).compareTo(o2+o2));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length; i ++){
            if("0".equals(data[i]) && i < data.length - 1 && sb.length() == 0){
                continue;
            }
            sb.append(data[i]);
        }
        return sb.toString();
    }




}
