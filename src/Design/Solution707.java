package Design;

/**
 * @authtor liFei
 * @date 2020/9/19-7:32
 */
public class Solution707 {
    /*
    设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，
    next 是指向下一个节点的指针/引用。如果要使用双向链表，
    则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
在链表类中实现这些功能：
get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，
则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     */
    class DoubleList{
        DoubleList next;
        DoubleList pre;
        int val;
        public DoubleList(){

        }
        public DoubleList(int val){
            this.val=val;
        }
    }
    class MyLinkedList {
            int size;
            DoubleList head;
            DoubleList last;
        /** Initialize your data structure here. */
        public MyLinkedList() {
             head=new DoubleList();//虚头结点
             last=new DoubleList();//虚尾结点
             head.next=last;
             last.pre=head;
             size=0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
               if(index>=size||index<0){
                   return -1;
               }
                  return targetNode(index).val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
                    DoubleList newHead=new DoubleList(val);
                    DoubleList cur=head.next;
                    head.next=newHead;
                    newHead.next=cur;
                    newHead.pre=head;
                    cur.pre=newHead;
                    size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            DoubleList newLast=new DoubleList(val);
            DoubleList cur=last.pre;
            last.pre=newLast;
            newLast.pre=cur;
            newLast.next=last;
            cur.next=newLast;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
              if(index<=0){
                  addAtHead(val);
              }else if(index==size){
                  addAtTail(val);
              }else{
                  DoubleList c=new DoubleList(val);
                  DoubleList cur=targetNode(index);
                  DoubleList h=cur.pre;
                  h.next=c;
                  c.pre=h;
                  c.next=cur;
                  cur.pre=c;
                  size++;
              }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
                   if(index<0||index>=size){
                       return;
                   }
                  if(index==0){
                      DoubleList cur=head.next.next;
                      head.next=cur;
                      cur.pre=head;
                      size--;
                  }else if(index==size-1){
                              DoubleList cur = last.pre.pre;
                              last.pre=cur;
                              cur.next=last;
                          size--;
                  }else if(0<index&&index<size-1){
                      DoubleList target = targetNode(index);
                      DoubleList pre=target.pre;
                      DoubleList next=target.next;
                      pre.next=next;
                      next.pre=pre;
                      size--;
                  }
        }
        private DoubleList targetNode(int index){
            DoubleList cur;
            if(index>=size/2){
                cur=last;
                index=size-index-1;
                while (index!=-1){
                    cur=cur.pre;
                    index--;
                }
                return cur;
            }else{
                cur=head;
                while (index!=-1){
                    cur=cur.next;
                    index--;
                }
                return cur;
            }
        }
    }
}
