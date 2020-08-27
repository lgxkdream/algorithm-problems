package io.github.lgxkdream.test.unit15;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 332. 重新安排行程
 * @description
 * @since 2020-08-27 10:00
 */
public class ReconstructItinerary {

    public static void main(String[] args) {
        /**
         * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
         * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
         */
        List<List<String>> tickets = Lists.newArrayList();
        tickets.add(Lists.newArrayList("MUC", "LHR"));
        System.out.println(findItinerary(tickets));
        /**
         * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
         * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
         * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
         */
        tickets = new ArrayList<>();
        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        return null;
    }

}
