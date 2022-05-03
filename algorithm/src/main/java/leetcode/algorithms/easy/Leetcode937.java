package leetcode.algorithms.easy;

import java.util.*;

/**
 * [重新排列日志文件]
 * <p>
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 * <p>
 * 有两种不同类型的日志：
 * <p>
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 * <p>
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 */
public class Leetcode937 {

    private static class Str {
        private String prefix;
        private String content;

        Str(String prefix, String content) {
            this.prefix = prefix;
            this.content = content;
        }
    }


    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        List<String> digitList = new ArrayList<>();
        List<Str> strList = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            String[] logData = log.split(" ");
            String logData1 = logData[1];
            char logDataChar0 = logData1.charAt(0);
            if (Character.isDigit(logDataChar0)) {
                digitList.add(log);
            } else {
                StringBuilder contentBuilder = new StringBuilder();
                for (int j = 1; j < logData.length; j++) {
                    contentBuilder.append(logData[j]);
                    if (j != logData.length - 1) {
                        contentBuilder.append(" ");
                    }
                }
                strList.add(new Str(logData[0], contentBuilder.toString()));
            }
        }
        strList.sort((o1, o2) -> {
            if (o1.content.equals(o2.content)) {
                return o1.prefix.compareTo(o2.prefix);
            } else {
                return o1.content.compareTo(o2.content);
            }
        });

        int p = 0;
        for (Str str : strList) {
            result[p++] = str.prefix.concat(" ") + str.content;
        }
        for (int i = 0; i < digitList.size(); i++) {
            result[p++] = digitList.get(i);
        }
        return result;
    }
}
