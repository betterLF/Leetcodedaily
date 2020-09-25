package List;

/**
 * @authtor liFei
 * @date 2020/9/22-12:19
 */
public class Solution725 {
    /*
    给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
返回一个符合上述规则的链表的列表。
举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
         ListNode cur=root;
         int count=0;
         while (cur!=null){
             cur=cur.next;
             count++;
         }
         int len=count/k;
         int remain=count%k;
         int index=0;
         ListNode[] ans=new ListNode[k];
         cur=root;
         while (cur!=null){
             ListNode temp=cur;
             int cc=0;
             if(remain>0){
                 remain--;
                 cc=1;
             }
             for (int i = 0; i <len-1+cc; i++) {
                 cur=cur.next;
             }

             ListNode c=cur.next;
             cur.next=null;
             ans[index]=temp;
             index++;
             cur=c;
         }
         return ans;
    }
}
