package leetcode.algorithms.easy;

/**
 * @Description:
 * @Author panweiming Email:panweiming@shein.com
 * @Date create in 2021/5/30 10:44
 */
public class Leetcode5772 {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        StringBuilder target = new StringBuilder();
        int maxLength = Math.max(Math.max(firstWord.length(),secondWord.length()),targetWord.length());
        for(int i = 0; i < maxLength; i ++){
            if(i <= firstWord.length() - 1){
                first.append(firstWord.charAt(i) - 97);
            }
            if(i <= secondWord.length() - 1){
                second.append(secondWord.charAt(i) - 97);
            }
            if(i <= targetWord.length() - 1){
                target.append(targetWord.charAt(i) - 97);
            }
        }
        Integer firstInteger = Integer.valueOf(first.toString());
        Integer secondInteger = Integer.valueOf(second.toString());
        Integer targetInteger = Integer.valueOf(target.toString());
       return firstInteger + secondInteger == targetInteger;
    }
    public static void main(String[] args) {

        Leetcode5772 l = new Leetcode5772();
        System.out.println(l.isSumEqual("acb", "cba", "cdb"));
    }

}
