package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/6/23-7:46
 */
public class Solution232 {
    /*
    使用栈实现队列的下列操作
push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
     */
    class MyQueue {
         Stack<Integer> stack1;
         Stack<Integer> stack2;
        /** Initialize your data structure here. */
        public MyQueue() {
             stack1=new Stack<>();
             stack2=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            Stack<Integer> cur=new Stack<>();
               if(stack1.empty()){
                   stack1.push(x);
                   while (!stack2.empty()){
                       cur.push(stack2.pop());
                   }
                   while (!cur.empty()){
                       stack1.push(cur.pop());
                   }
               }else{
                   stack2.push(x);
                   while (!stack1.empty()){
                       cur.push(stack1.pop());
                   }
                   while (!cur.empty()){
                       stack2.push(cur.pop());
                   }
               }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
         if(empty()){
             return -1;
         }else{
             if(stack1.empty()){
                 return stack2.pop();
             }else{
                 return stack1.pop();
             }
         }
        }

        /** Get the front element. */
        public int peek() {
            if(empty()){
                return -1;
            }else{
                if(stack1.empty()){
                    return stack2.peek();
                }else{
                    return stack1.peek();
                }
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
          if(stack1.empty()&&stack2.empty()){
              return true;
          }else{
              return false;
          }
        }
    }
}
