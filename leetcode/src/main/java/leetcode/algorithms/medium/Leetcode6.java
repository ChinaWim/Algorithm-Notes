package leetcode.algorithms.medium;

/**
 * [Z 字形变换]
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 */
public class Leetcode6 {


    public static void main(String[] args) {
        Leetcode6 leetcode6 = new Leetcode6();
        String leetcodeishiring = leetcode6.convert("ABCDE", 3);
        System.out.println(leetcodeishiring);
    }


    public String convert(String s, int numRows) {
        if(s.length() < numRows){
            return s;
        }
        if(numRows <= 1){
            return s;
        }

        if(numRows == 2){
            StringBuilder row1 = new StringBuilder();
            StringBuilder row2 = new StringBuilder();
           for(int i = 0; i < s.length(); i ++){
               if((i + 1) % 2 == 0){
                   row2.append(s.charAt(i));
               }else {
                   row1.append(s.charAt(i));
               }
           }
            return row1.append(row2).toString();
        }

        Character[][] data = new Character[numRows][s.length() / 2 + 1];
        int maxNum = numRows - 2;

        int numRowsCount = 1;
        int num = 1;

        boolean numRowsCountFlag = true;
        boolean numFlag = false;

        int numRow = 0;
        int column = 0;
        for(int i = 0 ; i < s.length(); i++){
            data[numRow][column] = s.charAt(i);

            if(numRowsCountFlag){
                if(numRowsCount % numRows == 0){
                    numFlag = true;
                    numRowsCountFlag = false;
                    numRow --;
                    column ++;
                    numRowsCount = 1;
                    continue;
                }

                numRow ++;
                numRowsCount ++;
            }
            if(numFlag){
                if(num % maxNum == 0 ){
                    numRowsCountFlag = true;
                    numFlag = false;
                    column ++;
                    numRow --;
                    num = 1;
                    continue;
                }

                column++;
                numRow --;
                num ++;
            }
        }



    StringBuilder result = new StringBuilder();

        for (Character[] datum : data) {
            for (Character c : datum) {
                if(c != null ){
                   result.append(c);
                }
            }

        }
        return result.toString();

    }


}
