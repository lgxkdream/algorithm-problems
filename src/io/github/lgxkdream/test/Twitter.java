package io.github.lgxkdream.test;

import java.util.*;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-05-11 19:20
 */
public class Twitter {

    int timestamp = 0;
    private Map<Integer, Set<Integer>> followeeMap;
    private Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followeeMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = tweetMap.get(userId);
        tweetMap.compute(userId, (k, v) -> new Tweet(++timestamp, tweetId)).next = tweet;
    }

    public List<Integer> getNewsFeed(int userId) {
        follow(userId, userId);
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        followeeMap.get(userId).forEach(followeeId -> Optional.of(tweetMap.get(followeeId)).ifPresent(tweet -> queue.add(tweet)));
        while (!queue.isEmpty() && newsFeed.size() < 10) {
            Tweet poll = queue.poll();
            newsFeed.add(poll.tweetId);
            if (poll.next != null) {
                queue.add(poll.next);
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        followeeMap.computeIfAbsent(followerId, HashSet::new).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Optional.ofNullable(followeeMap.get(followerId)).ifPresent(followee -> followee.remove(followeeId));
    }

    class Tweet {
        int timestamp;
        int tweetId;
        Tweet next;

        public Tweet(int timestamp, int tweetId) {
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(1, new HashSet<>());
        boolean present = Optional.ofNullable(map.get(1)).isPresent();
        System.out.println(present);

        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));

        // 用户1关注了用户2.
        twitter.follow(1, 2);

        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        System.out.println(twitter.getNewsFeed(1));

        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        System.out.println(twitter.getNewsFeed(1));
    }

}
