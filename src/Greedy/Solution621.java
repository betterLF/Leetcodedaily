package Greedy;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/4/9-16:27
 */
public class Solution621 {
    /*
    给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
    任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
    CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
你需要计算完成所有任务所需要的最短时间。
     */
//1:排序
    public static int leastInterval(char[] tasks, int n) {
            int arr[]=new int[26];
            int len1=tasks.length;
            for(int i=0;i<len1;i++){
                arr[tasks[i]-'A']++;
            }
        Arrays.sort(arr);
            int len=26;
            int count=0;
        while(arr[len-1]!=0) {
              int i=0;
              while(i<=n){//每一组有n+1个，则只要元素不为0，就占据每组一个位置
                  if(arr[25]==0){
                      break;
                  }
                  if(i<26&&arr[25-i]>0){
                      arr[25-i]--;
                  }
                  i++;
                  count++;
              }
               Arrays.sort(arr);
           }
        return count;
    }
    //2设计：
    public static int leastInterval2(char[] tasks, int n) {
        int arr[]=new int[26];
        int len1=tasks.length;
        for(int i=0;i<len1;i++){
            arr[tasks[i]-'A']++;
        }
        Arrays.sort(arr);
        int max=arr[25]-1;
        int vacant=max*n;
        for(int i=24;i>=0;i--){
            vacant-=Math.min(arr[i],max);
        }
        return vacant>0?tasks.length+vacant:tasks.length;
    }

}
