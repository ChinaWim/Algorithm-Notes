package leetcode.algorithms.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 *
 *
 **/
public class Leetcode506{

    public class ScoreData{
        private Integer index;
        private Integer score;
        private Integer rank;
        public Integer getScore(){
            return score;
        }
        public Integer getIndex(){
            return index;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        if(score.length == 1){
            result[0] = "Gold Medal";
            return result;
       }
        if(score.length == 2){
            if(score[0] > score[1]){
                result[0] = "Gold Medal";
                result[1] = "Silver Medal";
                return result;
            }else{
                result[0] = "Silver Medal";
                result[1] = "Gold Medal";
                return result;
            }
        }
        List<ScoreData> scoreDataList = new ArrayList<>();
        for(int i = 0 ; i < score.length ; i++){
            ScoreData data = new ScoreData();
            data.index = i;
            data.score = score[i];
            scoreDataList.add(data);
        }

        scoreDataList.sort(Comparator.comparing(ScoreData::getScore).reversed());
        for(int i = 0;i < scoreDataList.size();i++){
            scoreDataList.get(i).rank = i + 1;
        }
        Map<Integer,ScoreData> scoreDataMap = scoreDataList.stream().collect(Collectors.toMap(ScoreData::getIndex,(v -> v),(x,y) -> x));

        for(int i = 0 ; i < score.length ; i++){
            ScoreData scoreData = scoreDataMap.get(i);
            if(scoreData.rank == 1){
                result[i] = "Gold Medal";
            }else if(scoreData.rank == 2){
                result[i] = "Silver Medal";
            }else if(scoreData.rank == 3){
                result[i] = "Bronze Medal";
            }else {
                result[i] = String.valueOf(scoreData.rank);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Leetcode506 l = new Leetcode506();
        System.out.println(Arrays.toString(l.findRelativeRanks(new int[]{5,4,3,2,1})));
    }

}
