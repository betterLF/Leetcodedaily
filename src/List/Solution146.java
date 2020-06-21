package List;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/6/18-7:43
 */
public class Solution146 {
    /*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/
     */
    class LRUCache {//双向链表
        class DListNode{
            int key;//数据的关键字
            int value;//数据的值
            DListNode pre;//数据的前驱结点
            DListNode next;//数据的后继结点
        }
        int capacity;//双向循环链表最大容量
        int count;//当前容量
        HashMap<Integer,DListNode> map;//存放双向链表
        DListNode head;//双向循环链表伪头结点
        DListNode tail;//双向循环链表伪尾结点
        public LRUCache(int capacity) {//初始化
          map=new HashMap<>();
          count=0;
          this.capacity=capacity;
          head=new DListNode();
          tail=new DListNode();
          head.next=tail;
          tail.pre=head;
        }
        public int get(int key) {
            if(map.get(key)==null){
                return -1;
            }else{//将该链表放到队列头部，代表最近被使用过
                DListNode temp=map.get(key);
                removeNode(temp);
                addToHead(temp);
                return temp.value;
            }
        }
        public void put(int key, int value) {
          if(map.containsKey(key)) {//如果有该key值
              DListNode temp = map.get(key);
              removeNode(temp);
              addToHead(temp);
              temp.value = value;
              return;
          }
                if(count<capacity) {//如果没达到存放容量
                    if (!map.containsKey(key)) {///如果没有该key值
                        DListNode cur = new DListNode();
                        cur.key = key;
                        cur.value = value;
                        addToHead(cur);
                        map.put(key,cur);
                        count++;
                    }
                }else{//超过容量
                    DListNode cur=removeTail();
                    map.remove(cur.key);//移除最近没有使用的元素
                    DListNode c= new DListNode();
                    c.key = key;
                    c.value = value;
                    addToHead(c);
                    map.put(key,c);
                }
        }
        public DListNode addToHead(DListNode node){//将该结点加到链表头部，代表近期使用过
            node.next=head.next;
            head.next.pre=node;
            head.next=node;
            node.pre=head;
            return node;
        }
        public  DListNode removeNode(DListNode node){
            node.pre.next=node.next;
            node.next.pre=node.pre;
            return node;
        }
        public DListNode removeTail(){
            DListNode temp=tail.pre;
            removeNode(temp);
            return temp;
        }
    }
}
