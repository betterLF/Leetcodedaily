package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/7/14-6:34
 */
public class Solution390 {
    /*
    给定一个从1 到 n 排序的整数列表。
首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
返回长度为 n 的列表中，最后剩下的数字。
     */
    public int lastRemaining(int n) {
         return n==1?1:2*(n/2+1-lastRemaining(n/2));
    }
    public int lastRemaining2(int n) {
      if(n==1){
          return 1;
      }
      int start=2;
      int mul=2;
      int sign=1;
      int end=n;
      while (n/2!=1){//记录次数
          int temp=start;
          start=(end-start)%(mul*sign)==0?end:end-(mul*sign)/2;
          start+=-(mul*sign);
          end=temp;
          sign=-sign;//下一轮方差变为负数
          mul*=2;//下一轮方差绝对值变成原先两倍
         n/=2;
      }
      return start;
    }
}
