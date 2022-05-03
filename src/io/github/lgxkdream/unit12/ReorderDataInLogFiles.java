package io.github.lgxkdream.unit12;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 937. 重新排列日志文件
 * @description https://leetcode-cn.com/problems/reorder-data-in-log-files/
 * @since 5/3/22 8:50 PM
 */
public class ReorderDataInLogFiles {

    public static void main(String[] args) {
        /**
         * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
         * 解释：
         * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
         * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
         */
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        /**
         * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
         */
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isLog1Letter = Character.isLetter(split1[1].charAt(0));
            boolean isLog2Letter = Character.isLetter(split2[1].charAt(0));
            if (isLog1Letter && isLog2Letter) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp == 0) {
                    return split1[0].compareTo(split2[0]);
                }
                return cmp;
            }
            return !isLog1Letter ? (!isLog2Letter ? 0 : 1) : -1;
        });
        return logs;
    }

}
