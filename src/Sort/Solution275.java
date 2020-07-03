package Sort;

/**
 * @authtor liFei
 * @date 2020/6/30-6:50
 */
public class Solution275 {
    /*
    给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有
h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
     */
    public int hIndex(int[] citations) {
          int left=0;
          int right=citations.length-1;
          int len=citations.length;
          int ans=0;
          while (left<=right){
              int mid=left+(right-left)/2;
            if(citations[mid]==len-mid){//如果当前处正好是h篇论文至少引用了h次，则直接返回，因为如果往后走，论文数量减少，往前走，引用h次的h减少，都不是最优的
                return citations[mid];
            }else if (citations[mid]>len-mid){//比如cations[mid]=3，代表引用了三次的论文小于三次，则说明cations[mid]过大
                right=mid-1;
            }else{//同上
                left=mid+1;
            }
          }
          return len-left;
    }
}
