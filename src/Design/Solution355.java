package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/7/9-7:53
 */
public class Solution355 {
    /*

设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，
能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
postTweet(userId, tweetId): 创建一条新的推文
getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
follow(followerId, followeeId): 关注一个用户
unfollow(followerId, followeeId): 取消关注一个用户
示例:
     */
    class Twitter {
           HashMap<Integer, HashSet<Integer>> map;
           ArrayList<int[]> list;
        /** Initialize your data structure here. */
        public Twitter() {
            map=new HashMap<>();//key存放用户，value存放关注者
            list=new ArrayList<>();//第一个元素存放用户，第二个用户存放推文
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
                 int []cur={userId,tweetId};
                 list.add(cur);
                 if(!map.containsKey(userId)){
                     HashSet<Integer> set=new HashSet<>();
                     map.put(userId,set);
                 }
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> ans=new ArrayList<>();
            if(!map.containsKey(userId)){
                return ans;
            }
            HashSet<Integer> curSet=map.get(userId);
            int count=0;
            for (int i=list.size()-1;i>=0;i--){
                int temp=list.get(i)[0];
                if(curSet.contains(temp)||temp==userId){
                    ans.add(list.get(i)[1]);
                    count++;
                }
                if(count==10){
                    break;
                }
            }
            return ans;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {//k的value加入该名字
                     if(!map.containsKey(followerId)){//如果map中没有此用户
                         HashSet<Integer> set=new HashSet<>();
                         set.add(followeeId);
                         map.put(followerId,set);
                         return;
                     }
                         map.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {//key的value移除该名字
                      if(!map.containsKey(followerId)){
                          return;
                      }
                      if(map.get(followerId).contains(followeeId)){
                          map.get(followerId).remove((Integer)followeeId);
                      }
        }
    }

}
