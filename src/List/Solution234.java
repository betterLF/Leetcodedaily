package List;

/**
 * @authtor liFei
 * @date 2020/6/23-7:58
 */
public class Solution234 {
    /*
    请判断一个链表是否为回文链表。
     */
    public boolean isPalindrome(ListNode head) {
               int len=0;
                ListNode cur=head;
                while (cur!=null){
                    cur=cur.next;
                    len++;
                }
                if(len==1||len==0){
                    return true;
                }
                int num=len-len/2;
                cur=head;
                ListNode pre=head;
                while (num!=0){//找到要翻转链表的开始位置
                    pre=cur;
                    cur=cur.next;
                    num--;
                }
                pre.next=null;//两个链表断开
        ListNode reverse = reverse(cur);
                ListNode n1=head;
                ListNode n2=reverse;
                while (n2!=null){//判断是否回文
                    if(n1.val==n2.val){
                        n1=n1.next;
                        n2=n2.next;
                    }else{
                        pre.next=reverse(reverse);
                        return false;
                    }
                }
                pre.next=reverse(reverse);
               return true;
    }
    public ListNode reverse(ListNode curNode){
        ListNode newHead=new ListNode(0);
        ListNode cur=curNode;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=newHead.next;
            newHead.next=cur;
            cur=temp;
        }
        return newHead.next;
    }
}
