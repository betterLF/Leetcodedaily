package List;

/**
 * @authtor liFei
 * @date 2020/6/9-6:43
 */
public class Solution61 {
    /*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     */
    public int totalCount;
    //方法一：类似数组翻转
    public ListNode rotateRight(ListNode head, int k){
        if(head==null||head.next==null||k==0){
            return head;
        }
        totalCount=0;
        ListNode newHead=new ListNode(0);
        ListNode reverseNode = reverse(head);
        newHead.next=reverseNode;
        int leftCount=k%totalCount;//判断左边几个结点要翻转。
        return reverse(reverseNode, leftCount);
    }
    private ListNode reverse(ListNode head){//翻转整个链表并且记录链表长度。
        ListNode newHead=new ListNode(0);
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=newHead.next;
            newHead.next=cur;
            cur=temp;
            totalCount++;
        }
        return newHead.next;
    }
    private ListNode reverse(ListNode head,int count){
        if(count==0){//如果左边要翻转的长度为0，那就是直接翻转整个链表，调用第一个即可。但此时totalCount值会改变
           return reverse(head);
        }
        ListNode newHead=new ListNode(0);
        ListNode cur=head;
        ListNode temp=cur;
        while (cur!=null&&count!=0){
            temp=cur.next;
            cur.next=newHead.next;
            newHead.next=cur;
            cur=temp;
            count--;
        }
        //此时的temp就是右边要翻转的链表头部，而左边链表的尾部就是head
        while (temp!=null){
            ListNode temp2=temp.next;
            temp.next=head.next;
            head.next=temp;
            temp=temp2;
        }
        return newHead.next;
    }
    //方法二：利用链表特性
    public ListNode rotateRight2(ListNode head, int k){
        if(head==null||head.next==null||k==0){
            return head;
        }
        ListNode cur=head;
        int count=1;
        while (cur.next!=null){//结束后得出链表长度和末尾结点
            cur=cur.next;
            count++;
        }
        int ansCount=k%count;
        if(ansCount==0){//不需要翻转
            return head;
        }
        ListNode newCur=head;
        while (count!=ansCount+1){//此时的newCur就是翻转后放在末尾的元素
            newCur=newCur.next;
            count--;
        }
          ListNode newHead=newCur.next;
          newCur.next=null;
          cur.next=head;
          return newHead;
    }
}
