import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/*
给出两个 非空 的链表用来表示两个非负的整数。其中,它们各自的位数是按照逆序的方式存储的，
并且它们的每个节点只能存储一位数字。如果,我们将这两个数相加起来，
则会返回一个新的链表来表示它们的和。您可以假设除了数字0之外，这两个数都不会以0开头。
 */
public class Solution2 {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //统计链表元素个数
        ListNode p1 = l1;
        ListNode p2 = l2;
        int count1 = 1;
        while (p1.next != null) {
            count1++;
            p1 = p1.next;
        }
        int count2 = 1;
        while (p2.next != null) {
            count2++;
            p2 = p2.next;
        }
        int count = count1 > count2 ? count1 : count2;
        int num1[] = new int[count];
        int num2[] = new int[count];
        //链表元素存入数组
        for (int i = 0; i < count1; i++) {
            num1[i] = l1.val;
            l1 = l1.next;
        }
        for (int i = 0; i < count2; i++) {
            num2[i] = l2.val;
            l2 = l2.next;
        }
        //逆序存入StringBuilder中
        StringBuilder s = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < count; i++) {
            if (num1[i] + num2[i] + carry < 10) {
                s.append((num1[i] + num2[i] + carry));
                carry = 0;
            } else {
                s.append((num1[i] + num2[i] + carry) - 10);
                carry = 1;
                if (i == count - 1) {
                    s.append(carry);
                }
            }

        }
        //将结果顺序存入数组
        String ss = s.toString();
        int num = s.length();
        int arr[] = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) s.charAt(i) - 48;
        }
        ListNode result = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(arr[i]);
        }
        return result;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        StringBuilder s = new StringBuilder();
        int carry = 0;
        while ((temp1 != null || temp2 != null)) {
            int m = temp1.val + temp2.val + carry;
            if (m < 10) {
                s.append(m);
                carry = 0;
                temp1 = temp1.next;
                temp2 = temp2.next;
                if (temp1 != null && temp2 == null) {
                    temp2 = new ListNode(0);
                } else if (temp2 != null && temp1 == null) {
                    temp1 = new ListNode(0);
                } else if (temp1 == null && temp2 == null) {
                    break;
                }
            } else {
                s.append(m - 10);
                carry = 1;
                temp1 = temp1.next;
                temp2 = temp2.next;
                if (temp1 != null && temp2 == null) {
                    temp2 = new ListNode(0);
                } else if (temp2 != null && temp1 == null) {
                    temp1 = new ListNode(0);
                } else if (temp1 == null && temp2 == null) {
                    s.append(1);
                    break;
                }
            }
        }
        //将结果顺序存入数组
        String ss = s.toString();
        int num = s.length();
        int arr[] = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) s.charAt(i) - 48;
        }
        ListNode result = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(arr[i]);
        }
        return result;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0;
        while ((temp1 != null || temp2 != null)) {
            int m = temp1.val + temp2.val + carry;
            ListNode temp3 = temp;
            if (m < 10) {
                temp3.val = m;
                if (!(temp1.next == null && temp2.next == null)) {
                    temp.next = new ListNode(0);
                    temp = temp.next;
                }
                carry = 0;
                temp1 = temp1.next;
                temp2 = temp2.next;
                if (temp1 != null && temp2 == null) {
                    temp2 = new ListNode(0);
                } else if (temp2 != null && temp1 == null) {
                    temp1 = new ListNode(0);
                } else if (temp1 == null && temp2 == null) {
                    break;
                }
            } else {
                temp3.val = m - 10;
                if (!(temp1.next == null && temp2.next == null)) {
                    temp.next = new ListNode(0);
                    temp = temp.next;
                }
                carry = 1;
                temp1 = temp1.next;
                temp2 = temp2.next;
                if (temp1 != null && temp2 == null) {
                    temp2 = new ListNode(0);
                } else if (temp2 != null && temp1 == null) {
                    temp1 = new ListNode(0);
                } else if (temp1 == null && temp2 == null) {
                    temp3.next = new ListNode(1);
                    break;
                }
            }
        }

        return result;
    }

    //官方解法
    /*
 时间复杂度：O(max(m,n))，假设 m和 n 分别表示temp1 和 temp2 的长度，上面的算法最多重复 max(m, n) 次。
空间复杂度：O(\max(m, n))O(max(m,n))， 新列表的长度最多为 \max(m,n) + 1max(m,n)+1。
     */
    public static ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = new ListNode(0);
        ListNode result = head;
        int carry = 0;
        while ((temp1 != null || temp2 != null)) {
            int m1 = (temp1 != null) ? temp1.val : 0;
            int m2 = (temp2 != null) ? temp2.val : 0;
            int m = m1 + m2 + carry;
            result.next = new ListNode(m % 10);
            result = result.next;
            carry = m / 10;
            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }
        if (carry == 1) {
            result.next = new ListNode(1);
        }
        return head.next;
    }
}
