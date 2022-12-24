package leetcode.algorithms.acwing;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/***
 *
 * 某综艺频道推出了一个闯关活动。
 *
 * 活动一共包含 n 个关卡（编号 1∼n），其中 m 个关卡为特殊关卡。
 *
 * 每个关卡都有一个通关分数，其中第 i 个关卡的通关分数为 ai。
 *
 * 挑战者可以自由决定所有关卡的具体挑战顺序，并且每通过一个关卡就可以获得该关卡的通关分数。
 *
 * 值得注意的是，当挑战者即将挑战的关卡是特殊关卡时，如果挑战者当前已经获得的总分数大于该特殊关卡的通关分数，则挑战者可以对该关卡的通关分数进行一次修改，修改后的新分数不能小于原分数，也不能大于挑战者当前已经获得的总分数。
 *
 * 请你计算并输出挑战者通过所有关卡获得的总分数的最大可能值。
 */
public class Acwing4786 {

    /**
     * 1.优先选非特殊
     * 2.当前分数小于特殊最大，第一个特殊优选最大后，sum * 2 * m - 1
     * 3.当前分数大于特殊最大，sum * 2 * m
     * @param args
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n  = cin.nextInt();
        int m = cin.nextInt();
        int[] nArray = new int[n];

        HashSet<Integer> mSet = new HashSet<>();
        int nP = 0;
        int nTemp = n;
        while(nTemp -- > 0){
            nArray[nP ++] = cin.nextInt();
        }
        int mTemp = m;
        while(mTemp -- > 0){
            int mK = cin.nextInt();
            mSet.add(mK);
        }
        long sum = 0;
        if(m <= 0){
            for(int i = 0; i < nArray.length; i++){
                sum += nArray[i];
            }
        }else {
            int[] mKarray = new int[m];
            int mP = 0;
            for(int i = 0; i <nArray.length; i ++){
                int key = i + 1;
                if(!mSet.contains(key)){
                    sum += nArray[i];
                }else {
                    mKarray[mP ++] = nArray[i];
                }
            }
            Arrays.sort(mKarray);
            if (sum > mKarray[mKarray.length - 1]) {
                for (int i = 0; i < mKarray.length; i++) {
                    if (sum > mKarray[i]) {
                        sum += sum;
                    }
                }
            } else {
                sum += mKarray[mKarray.length - 1];
                for (int i = 0; i < mKarray.length - 1; i++) {
                    if (sum > mKarray[i]) {
                        sum += sum;
                    } else {
                        sum += mKarray[i];
                    }
                }
            }
        }
        System.out.println(sum);
    }

}
