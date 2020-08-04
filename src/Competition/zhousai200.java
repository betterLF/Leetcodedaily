package Competition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/8/2-10:05
 */
public class zhousai200 {
    /*
给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
其中 |x| 表示 x 的绝对值。
返回 好三元组的数量 。
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                   if(Math.abs(arr[j] - arr[k]) <= b&&Math.abs(arr[i] - arr[k]) <= c){
                       ans++;
                   }
                    }
                }
            }
        }
        return ans;
    }
    /*
给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，
较大的整数将会取得这一回合的胜利并保留在位置 0 ，
较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
返回赢得比赛的整数。
题目数据 保证 游戏存在赢家。
     */
    public int getWinner(int[] arr, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            list.add(arr[i]);
        }
        int curCount=0;
        int curIndex=0;
        int curNum=0;
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(list.get(0));
        queue.add(list.get(1));
        HashSet<Integer> set=new HashSet<>();
        set.add(queue.peek());
        list.add(queue.poll());//将小数放到末尾
        curNum=queue.peek();//得到当前较大数
        curCount=1;
        curIndex=2;
        while (curCount!=k){
             queue.add(list.get(curIndex));
             if(queue.peek()==curNum){//如果小的数是前面一轮大的数
                 set.clear();
                 set.add(queue.peek());
                 list.add(queue.poll());//将小数放到末尾
                 curNum=queue.peek();//得到当前较大数
                 curCount=1;
             }else{
                 int curMin=queue.poll();
                 if(set.contains(curMin)){
                     return curNum;
                 }else{
                     set.add(curMin);
                 }
                 list.add(curMin);
                 curCount++;
             }
             curIndex++;
        }
        return curNum;

    }
    /*
给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。
一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。
请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。
主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。
     */
    public int minSwaps(int[][] grid) {
           int []arr=new int[grid.length];//arr[i]表示第i行末尾0的个数
        for (int i = 0; i <grid.length ; i++) {
                  arr[i]=-1;
            for (int j = grid[0].length-1; j>=0 ; j--) {
                if(grid[i][j]==1){
                    arr[i]=grid[0].length-1-j;
                    break;
                }
            }
            if(arr[i]==-1){
                arr[i]=grid[0].length;
            }
        }
        //数组长度为n时前n-1个数分别至少为n-1,n-2，n-3.....1
        int ans=0;
        int len=arr.length;
        for (int i = 0; i <arr.length ; i++) {
          if(arr[i]<len-1-i){//如果该点不满足条件，找到后面最近的满足条件的点
              for (int j = i+1; j <arr.length ; j++) {
                     if(arr[j]>=len-1-i){//如果找到了
                         for (int k = j; k>i ; k--) {
                             swap(arr,k,k-1);
                             ans++;
                         }
                         break;
                     }
              }
              if(arr[i]<len-1-i){//如果没找到
                  return -1;
              }
          }
        }
        return ans;
    }
    private void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
