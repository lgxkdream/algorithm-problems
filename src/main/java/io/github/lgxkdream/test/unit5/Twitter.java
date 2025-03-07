package io.github.lgxkdream.test.unit5;

import java.util.*;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 设计推特
 * @description https://leetcode-cn.com/problems/design-twitter/
 * @since 2020-04-13 09:50
 */
public class Twitter {

    private int timeStamp = 0;
    private Map<Integer, Set<Integer>> followerMap;
    private Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followerMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = tweetMap.get(userId);
        tweetMap.compute(userId, (k, v) -> new Tweet(++timeStamp, tweetId)).next = tweet;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        follow(userId, userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.timeStamp - a.timeStamp);
        followerMap.get(userId).forEach(follower -> Optional.ofNullable(tweetMap.get(follower)).ifPresent(tweetId -> pq.offer(tweetId)));
        while (!pq.isEmpty() && newsFeed.size() < 10) {
            Tweet poll = pq.poll();
            newsFeed.add(poll.tweetId);
            if (poll.next != null) {
                pq.offer(poll.next);
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, HashSet::new).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Optional.ofNullable(followerMap.get(followerId)).ifPresent(followers -> followers.remove(followeeId));
    }

    class Tweet {
        int timeStamp;
        int tweetId;
        Tweet next;

        public Tweet(int timeStamp, int tweetId) {
            this.timeStamp = timeStamp;
            this.tweetId = tweetId;
        }
    }

    public static void main(String[] args) {
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
