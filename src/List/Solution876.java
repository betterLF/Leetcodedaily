package List;

public class Solution876 {
    /*
    给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
如果有两个中间结点，则返回第二个中间结点。
     */
    public ListNode middleNode(ListNode head) {
        int count=0;
        int t=0;
        ListNode cur=head;
        ListNode res=head;
        while(true){
            if(cur!=null){
                count++;
                cur=cur.next;
            }else{
                if(t!=0){
                    res=res.next;
                    t--;
                    if(t==0){
                        break;
                    }
                }else{
                    t=count/2;
                    if(t==0){//防止链表只有一个元素，就会一直做t=count/2操作
                        break;
                    }
                }
            }
        }
        return res;
    }
}
