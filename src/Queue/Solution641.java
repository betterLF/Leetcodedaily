package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/9-9:58
 */
public class Solution641 {
    /*
    设计实现双端队列。
你的实现需要支持以下操作：
MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。
     */
    class MyCircularDeque {
        private ArrayDeque<Integer> q1;
        private ArrayDeque<Integer> q2;
        private int maxSize;
        public MyCircularDeque(int k) {
            q1=new ArrayDeque<>();
            q2=new ArrayDeque<>();
               maxSize=k;
        }
        public boolean insertFront(int value) {
            if(!isFull()){
                q1.add(value);
                return true;
            }
            return false;
        }
        public boolean insertLast(int value) {
            if(!isFull()){
                q2.add(value);
                return true;
            }
            return false;
        }
        public boolean deleteFront() {
           if(isEmpty()){
               return false;
           }else{
               if(q1.size()!=0){
                   q1.pollLast();
               }else{
                   q2.pollFirst();
               }
               return true;
           }
        }
        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }else{
                if(q2.size()!=0){
                    q2.pollLast();
                }else{
                    q1.pollFirst();
                }
                return true;
            }
        }
        public int getFront() {
            if(isEmpty()){
                return -1;
            }else{
                if(q1.size()!=0){
                  return   q1.peekLast();
                }else{
                 return    q2.peekFirst();
                }
            }
        }
        public int getRear() {
            if(isEmpty()){
                return -1;
            }else{
                if(q2.size()!=0){
                    return  q2.peekLast();
                }else{
                    return  q1.peekFirst();
                }
            }
        }
        public boolean isEmpty() {
           if(q1.size()+q2.size()==0){
               return true;
           }
           return false;
        }
        public boolean isFull() {
                if(q1.size()+q2.size()==maxSize){
                    return true;
                }
                return false;
        }
    }
}
