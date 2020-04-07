package List;

import java.util.ArrayList;
import java.util.List;

public class Solution0201ms {
    /*
    编写代码，移除未排序链表中的重复节点。保留最开始出现的节点
     */
    //速度900+ms
    public ListNode removeDuplicateNodes(ListNode head) {
        List<Integer> res=new ArrayList<>();
        ListNode cur=head;
        ListNode temp=new ListNode(0);
        boolean flag=false;
        while(cur!=null){
            if(!res.contains(cur.val)) {
                if(flag){//如果前面出现了重复元素
                   temp.next=cur; //把前面最后出现的不重复元素与其相连
                   flag=false;
                }
                temp = cur;//记录此时的不重复元素位置
                res.add(cur.val);
            }else {
                flag=true;
            }
            cur=cur.next;//链表后移
        }
        if(flag){
            temp.next=null;
        }
        return head;
    }
    //不用集合，不用add和contains方法，节省大量时间 1ms!
    public ListNode removeDuplicateNodes2(ListNode head) {
        List<Integer> res=new ArrayList<>();
        ListNode cur=head;
        ListNode pre=new ListNode(0);
         int count=0;
         while(cur!=null){
             count++;
             cur=cur.next;
         }
        boolean arr[]=new boolean[count+1];
         boolean flag=false;
         cur=head;
        while(cur!=null){
            if(!arr[cur.val]) {
                if(flag){//如果前面出现了重复元素
                    pre.next=cur; //把前面最后出现的不重复元素与其相连
                    flag=false;
                }
                pre= cur;//记录此时的不重复元素位置
                 arr[cur.val]=true;
            }else {
                flag=true;
            }
            cur=cur.next;//链表后移
        }
        if(flag){
           pre.next=null;
        }
        return head;
    }
}
