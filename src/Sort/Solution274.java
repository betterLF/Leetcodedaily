package Sort;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/6/30-6:21
 */
public class Solution274 {
    /*
    给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）
总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数 不超过 h 次。）
例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
     */
    public int hIndex(int[] citations) {
        if(citations.length==0){
            return 0;
        }
        Arrays.sort(citations);
        int len=citations.length;
        int ans=0;
        for (int i = citations.length-1; i >=0 ; i--) {
            if(citations[i]==0){
                break;
            }
            if(len-i>=citations[i]){
                   return Math.max(ans,citations[i]);
            }else{
                ans=Math.max(len-i,ans);
            }

        }
        return ans;
    }
    public int hIndex2(int[] citations) {
        // 排序（注意这里是升序排序，因此下面需要倒序扫描）
        Arrays.sort(citations);
        // 线性扫描找出最大的 i
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }
    public int hIndex3(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        //计数
        for(int c : citations) {//buckets[i]代表引用次数为i次的论文数量(当值大于等于n时，统一为n)
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        //依次判断被引次数大于等于 N 的论文数是否大于等于 N
        for(int i = n; i >= 0; i--) {
            count += buckets[i];//计算此时的论文引用量是否大于此时的文章次数
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
