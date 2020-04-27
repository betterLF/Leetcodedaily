package DoublePointer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution0202ms {
    /*
    实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
注意：本题相对原题稍作改动
     */
    //hashmap，key存第几个，value存值
    public int kthToLast(ListNode head, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int count=0;
        ListNode temp=head;
        while(temp.next!=null){
            h.put(count++,temp.val);
            temp=temp.next;
        }
        h.put(count++,temp.val);
        return h.get(count-k);
    }
    //集合，因为是增元素多，只有一步查找，所以用LinkedList
    public int kthToLast2(ListNode head, int k) {
        ListNode temp=head;
        List<Integer> res=new LinkedList<>();
        while(temp.next!=null){
            res.add(temp.val);
            temp=temp.next;
        }
         res.add(temp.val);
        return res.get(res.size()-k);
    }
    //双指针,先让右指针往右移k次，再左右指针同时往后移
    public int kthToLast3(ListNode head, int k) {
        ListNode temp1=head;
        ListNode temp2=head;
        while(temp2!=null){
            temp2=temp2.next;
            if(k>0){
                k--;
            }else{
                temp1=temp1.next;
            }
        }
         return temp1.val;
    }
}
