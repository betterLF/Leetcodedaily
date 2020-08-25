package Competition;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/8/23-7:09
 */
public class zhousai203 {
    /*

     */
    public List<Integer> mostVisited(int n, int[] rounds) {
        int []count=new int[n+1];
        for (int i = 0; i <rounds.length-1 ; i++) {
            if(rounds[i]<=rounds[i+1]){
                for (int j = rounds[i]; j <rounds[i+1] ; j++) {
                    count[j]++;
                }
            }else{
                for (int j = rounds[i]; j <=n ; j++) {
                    count[j]++;
                }
                for (int j = 1; j <rounds[i+1] ; j++) {
                    count[j]++;
                }
            }
        }
        count[rounds[rounds.length-1]]++;
        int temp[]= Arrays.copyOf(count,count.length);
        Arrays.sort(temp);
        int max=temp[temp.length-1];
        List<Integer> ans=new ArrayList<>();
        for (int i = 1; i <count.length ; i++) {
            if(count[i]==max){
                ans.add(i);
            }
        }
        return ans;
    }


    /*
有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：

每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
Alice 将会取走硬币数量最多的那一堆。
你将会取走硬币数量第二多的那一堆。
Bob 将会取走最后一堆。
重复这个过程，直到没有更多硬币。
给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。

返回你可以获得的最大硬币数目。
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count=piles.length/3;
        int cur=piles.length-2;
        int ans=0;
        while (count>0){
            ans+=piles[cur];
            cur-=2;
            count--;
        }
        return ans;
    }



    /*
给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。
在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），二进制字符串上位于位置 arr[i] 的位将会设为 1 。
给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。
返回存在长度 恰好 为 m 的 一组 1  的最后步骤。如果不存在这样的步骤，请返回 -1 。
     */
//    public int findLatestStep(int[] arr, int m) {
//           if(m==arr.length){
//               return m;
//           }
//           LinkedList<int []> list=new LinkedList<>();
//           list.add(new int[]{0,arr.length-1});
//           int i=arr.length-1;
//           while (i>=0){
//               int cur=arr[i]-1;
//               int index=-1;
//               for (int j = 0; j <list.size() ; j++) {
//                   int []temp=list.get(j);
//                   if(temp[0]<=cur&&temp[1]>=cur){
//                           index=j;
//                           break;
//                   }
//               }
//               int []temp=list.get(index);
//               if(temp[1]-cur==m||cur-temp[0]==m){
//                   return i+1;
//               }else{
//                   list.set(index,new int[]{temp[0],cur-1});
//                   list.add(index+1,new int[]{cur+1,temp[1]});
//               }
//               i--;
//           }
//           return -1;
//    }
    public int findLatestStep(int[] arr, int m) {
        if(m==arr.length){
            return m;
        }
        TreeMap<Integer,Integer> tree=new TreeMap<>();
        tree.put(0,arr.length-1);
        int i=arr.length-1;
        while (i>=0){
            int cur=arr[i]-1;
            Integer integer = tree.floorKey(cur);
            int start=integer;
            int end=tree.get(start);
            if(end-cur==m||cur-start==m){
                return i;
            }else{
                tree.remove(start);
                tree.put(start,cur-1);
                tree.put(cur+1,end);
            }
            i--;
        }
        return -1;
    }

}
