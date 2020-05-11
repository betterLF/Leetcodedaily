package Competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/10-10:06
 */
public class zhousai188 {
    /*
给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
请使用下述操作来构建目标数组 target ：
Push：从 list 中读取一个新元素， 并将其推入数组中。
Pop：删除数组中的最后一个元素。
如果目标数组构建完成，就停止读取更多元素。
题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
请返回构建目标数组所用的操作序列。
题目数据保证答案是唯一的。
     */
    public List<String> buildArray(int[] target, int n) {
           List<String> ans=new ArrayList<>();
           int count=1;
           for (int i=0;i<target.length;i++){
                 while (count!=target[i]){
                     count++;
                     ans.add("Push");
                     ans.add("Pop");
                 }
                 ans.add("Push");
                 count++;
           }
           return ans;
    }
    /*
给你一个整数数组 arr 。
现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
a 和 b 定义如下：
a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
注意：^ 表示 按位异或 操作。
请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
     */
    public static void main(String[] args) {
        int arr[]={2,3,1,6,7};
        countTriplets(arr);
    }
    public static int countTriplets(int[] arr){
            if(arr.length<2){
                return 0;
            }
            int ans=0;
            for (int i=0;i<arr.length;i++){
                int m=arr[i];
                for (int j=i+1;j<arr.length;j++){
                    m^=arr[j];
                    if(m==0){
                        ans+=j-i;
                    }
                }
            }
            return ans;
        }

    /*
给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，
需要花费 1 秒钟。你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。
除此以外，还有一个布尔数组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
          List<Integer> apple=new ArrayList<>();//存放所有apple所在的位置
          for (int i=0;i<hasApple.size();i++){
              if(hasApple.get(i)==true){
                  apple.add(i);
              }
          }
          if(apple.size()==0){//如果没有apple，就返回0
              return 0;
          }
          int temp[]=new int[n];//下标代表结点，值代表父节点
          int ans=0;//结果
          for (int i=0;i<edges.length;i++){
              temp[edges[i][1]]=edges[i][0];
          }
        ArrayList<String> way=new ArrayList<>();//存放已经走过的结点路径
        int i=0;
        if(apple.get(0)==0){//如果父节点也是苹果，这条路不用走，从第二个苹果位置开始
            i=1;
        }
          for ( ;i<apple.size();i++) {//查找每一个苹果到0的路径
              int c = apple.get(i);
              String c1=""+c;//存放此条路径
              if (!way.contains(c1)) {//如果路径没走过，路径+1，加入路径集合中
                  ans++;
                  way.add(c1);
              }
              if (temp[c] == 0) {//如果此时到达根节点，就遍历下一个苹果，否则继续往前走
                  continue;
              }
              c = temp[c];//苹果到达它的父结点
              while (temp[c] != 0) {//如果此时不为0，就循环往前查找
                  String c2=""+c;//存放当前路径
                  if (!way.contains(c2)) {//如果路径没有走过
                      ans++;
                      way.add(c2);
                  }
                  c = temp[c];
              }
              String c3=""+c;//到达0，记录此时的路径
              if (!way.contains(c3)) {//如果该路径没有走过
                  way.add(c3);
                  ans++;
              }
          }
          return 2*ans;
    }
}
