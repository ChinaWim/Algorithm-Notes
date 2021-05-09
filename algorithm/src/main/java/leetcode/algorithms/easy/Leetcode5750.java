package leetcode.algorithms.easy;

/**
 * [人口最多的年份]
 *
 */
public class Leetcode5750 {
    public int maximumPopulation(int[][] logs) {
        int maxPeople = 1;
        int minYear = Integer.MAX_VALUE;
       for (int i = 0; i < logs.length; ++i) {
           int preI = logs[i][0];
           int curPeople = 1;
           for (int j = 0; j < logs.length; ++j) {
               if(i != j){
                   int preJ = logs[j][0];
                   int endJ = logs[j][1] - 1;
                   if(preJ <= preI && endJ >= preI){
                       curPeople ++;
                   }
               }
           }
           if(curPeople >= maxPeople){
               if(curPeople == maxPeople && preI <= minYear){
                   minYear = preI;
                   maxPeople = curPeople;
               }else if(curPeople > maxPeople){
                   minYear = preI;
                   maxPeople = curPeople;
               }
           }
       }
       return minYear;
    }

    public static void main(String[] args) {
        Leetcode5750 l = new Leetcode5750();
        System.out.println(l.maximumPopulation(new int[][]{{2008,2026},{2004,2008},
            {2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}}));
    }

}
