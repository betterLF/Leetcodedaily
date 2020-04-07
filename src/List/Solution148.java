package List;

import jdk.swing.interop.SwingInterOpUtils;
public class Solution148 {
    /*
    在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     */
    public  ListNode sortList(ListNode head) {
        if(head==null||head.next==null){//如果只有一个结点或者没有结点，直接返回
            return head;
        }
            ListNode newHead=new ListNode(0);//头结点，傀儡结点
            newHead.next=head;
            int len=getLength(head);//求链表长度，决定合并几次
            for(int i=1;i<len;i*=2){//合并次数
                ListNode cur=newHead.next;//设置当前结点为傀儡结点的下一个
                ListNode pre=new ListNode(0);
                pre=newHead;//使得前一个结点指向真正开始的结点(pre用于合并后的部分链表与其前面部分连起来)
                for(int j=0;j<len;j+=2*i){
                    int k=i;//左分结点的长度
                    ListNode t1=new ListNode(0);
                    ListNode L=t1;
                    while(cur!=null&&k!=0){
                        k--;
                        t1.next=cur;
                        cur=cur.next;
                        t1=t1.next;
                    }
                    t1.next=null;//使得左分结点的下一个结点置空，断开与之后结点的联系
                    k=i;//右分结点的长度，可能小于k，取决于当前的cur剩余长度
                    ListNode t2=new ListNode(0);
                    ListNode R=t2;
                    ListNode p=new ListNode(0);
                    while(cur!=null&&k!=0){
                        k--;
                        t2.next=cur;
                        cur=cur.next;
                        t2=t2.next;
                    }
                    p=cur;//记录此时右分完的下一个结点指向，到下面会让合成的链表的next域指向它
                    t2.next=null;
                    ListNode newH=merge(L.next,R.next);//合并左分和右分结点
                    pre.next=newH;//合并的新子链表与前面连接起来
                    ListNode last=newH;
                    while(last.next!=null){
                        last=last.next;
                    }
                    last.next=p;//使得新子链表的next域指向下一个结点
                    pre=last;//新子链表的尾部是下一个新子链表的前驱
                    cur=p;//将下个新子结点的值赋值给cur，进行下一次循环
                }
               }
            return newHead.next;
    }
    private  int getLength(ListNode head){
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            count++;
          cur=cur.next;
        }
        return count;
    }
    private  ListNode merge(ListNode L,ListNode R){
         ListNode cur=new ListNode(0);
        ListNode res=cur;
           while (L!=null&&R!=null){
               if(L.val<=R.val){
                 cur.next=L;
                 L=L.next;
               }else{
                   cur.next=R;
                   R=R.next;
               }
               cur=cur.next;
           }
           if(L==null){
               cur.next=R;
           }else {
               cur.next=L;
           }
           return res.next;
    }
}
