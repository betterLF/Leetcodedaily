package Queue;

import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/10-7:34
 */
public class Solution622 {
    /*
 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
 它也被称为“环形缓冲器”。
循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，
我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
你的实现应该支持如下操作：
MyCircularQueue(k): 构造器，设置队列长度为 k 。
Front: 从队首获取元素。如果队列为空，返回 -1 。
Rear: 获取队尾元素。如果队列为空，返回 -1 。
enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
isEmpty(): 检查循环队列是否为空。
isFull(): 检查循环队列是否已满。
     */
    class MyCircularQueue {
         List<Integer> queue;
         int count;//判断队列空满情况
         int maxSize;
         int front;//队首
         int rear;//队尾
        public MyCircularQueue(int k) {
           queue=new LinkedList<>();
           count=0;
           maxSize=k;
        }
        public boolean enQueue(int value) {
              if(isFull()){
                  return false;
              }else {
                  if (rear < front) {
                      queue.set(rear, value);
                  }else{
                      queue.add(value);
                  }
              }
                  rear=rear+1>maxSize-1?0:rear+1;
                  count++;
                  return true;
              }
        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }
            queue.set(front,-1);
            front=front+1>maxSize-1?0:front+1;
            count--;
            return true;
        }
        public int Front() {
          return isEmpty()?-1:queue.get(front);
        }
        public int Rear() {
         if(isEmpty()){
             return -1;
         }else{
             return rear-1>=0?queue.get(rear-1):queue.get(maxSize-1);
         }
        }
        public boolean isEmpty() {

             return count==0?true:false;
        }
        public boolean isFull() {
              return  count==maxSize?true:false;
        }
    }
}
