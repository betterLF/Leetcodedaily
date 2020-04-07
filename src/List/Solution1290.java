package List;
/*
给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
请你返回该链表所表示数字的 十进制值 。
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
public class Solution1290 {
    //方法1
    public int getDecimalValue(ListNode head) {
          StringBuilder res=new StringBuilder();
          ListNode temp=head;
          while(temp!=null){
              res.append(temp.val);
              temp=temp.next;
          }
          int count=res.length()-1;
          int i=0;
          int ans=0;
          while(count>=0){
             ans+=(res.charAt(count)-'0')*Math.pow(2,i);
             i++;
             count--;
          }
          return ans;
    }
    //方法2
    public int getDecimalValue2(ListNode head){
        int res=0;
        ListNode temp=head;
        while(temp!=null){
            res=res*2+temp.val;
            temp=temp.next;
        }
        return res;
    }

}
