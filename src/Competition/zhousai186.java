package Competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @authtor liFei
 * @date 2020/4/26-10:25
 */
public class zhousai186 {
    /*
给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个
非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
     */
    public int maxScore(String s) {
      char ans[]=s.toCharArray();
       int max=max(ans,1);
       for(int i=2;i<ans.length;i++){
           int cur=max(ans,i);
           max=max>cur?max:cur;
       }
       return max;
    }
     private int max(char c[],int index){
        int count1=0;
        int count2=0;
        for(int i=0;i<index;i++){
            if(c[i]=='0'){
                count1++;
            }
        }
        for (int i=index;i<c.length;i++){
            if(c[i]=='1'){
                count2++;
            }
        }
        return count1+count2;
     }
    public int maxScore2(String s) {
        char ans[]=s.toCharArray();
        int count0[]=new int[s.length()];
        int count1[]=new int[s.length()];
        if(ans[0]=='0'){
            count0[0]=1;
        }else{
            count1[0]=1;
        }
        for(int i=1;i<ans.length;i++){
            if (ans[i]=='0'){
                count0[i]=count0[i-1]+1;
                count1[i]=count1[i-1];
            }else{
                count1[i]=count1[i-1]+1;
                count0[i]=count0[i-1];
            }
        }
        int max=0;
        for (int i=0;i<ans.length-1;i++){
            max=Math.max(max,count0[i]+count1[ans.length-1]-count1[i]);
        }
        return max;
    }
     /*
     几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
你的点数就是你拿到手中的所有卡牌的点数之和。
给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
      */
     public static void main(String[] args) {
         int a[]={2,2,2};
         maxScore(a,2);
     }
     public static int maxScore(int[] cardPoints, int k) {
         int len=cardPoints.length;
         int preSum[]=new int[len+1];
         for (int i = 0; i <cardPoints.length ; i++) {
             preSum[i+1]=cardPoints[i]+preSum[i];
         }
         int max=0;
         for (int i=0;i<=k;i++){
             max=Math.max(max,preSum[i]+preSum[len]-preSum[len-k+i]);
         }
         return max;
     }
     /*
     给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
     根据矩形的特点，设行的标号为i，列的标号为j。则对于每一条对角线而言，i + j的值是唯一的。
（可以参考 LeetCode探索 中 “哈希表” 的部分）
知道这一点之后，就可以按照对角线对nums中的值进行聚类。聚类完毕后，将所有的数值生成一个数组即可。

      */
         public int[] findDiagonalOrder(List<List<Integer>> nums) {
             int len = 0;
             Map<Integer,List<Integer>> map = new TreeMap<>();
             for(int i = 0;i < nums.size();i++) {
                 len += nums.get(i).size(); // 获取最后要返回的数组的长度，即元素个数
                 for(int j = 0;j < nums.get(i).size();j++) {
                     if(map.containsKey(i + j)) {
                         map.get(i + j).add(nums.get(i).get(j));
                     }
                     else {
                         List<Integer> list = new ArrayList<>();
                         list.add(nums.get(i).get(j));
                         map.put(i + j, list);
                     }
                 }
             }
             int[] ans = new int[len];
             int index = 0;
             for(int key : map.keySet()) { // 遍历map
                 List<Integer> list = map.get(key);
                 for(int j = list.size() - 1;j >= 0;j--) { // 根据题目的输出要求确定生成数组中元素的顺序
                     ans[index] = list.get(j);
                     index++;
                 }
             }
             return ans;
         }
}
