package Stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/6/22-6:35
 */
public class Solution225 {
    /*

使用队列实现栈的下列操作：
push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空
    */

    class MyStack {
       Queue<Integer> queue1;//中转
       Queue<Integer> queue2;//队列
    /** Initialize your data structure here. */
    public MyStack() {
           queue1=new ArrayDeque<>();
           queue2=new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {//此时空的队列放入加入的元素，然后另外一个队列依次弹出元素加入其中
        if(queue2.isEmpty()) {
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        }else{
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       if(empty()){
           return -1;
       }else {
            if(queue2.isEmpty()){
                return queue1.poll();
            }else{
                return queue2.poll();
            }
       }
    }

    /** Get the top element. */
    public int top() {
            if(empty()){
                return -1;
            }else{
                if(queue2.isEmpty()){
                    return queue1.peek();
                }else{
                    return queue2.peek();
                }
            }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
          if(queue1.isEmpty()&&queue2.isEmpty()){
              return true;
          }else{
              return false;
          }
    }
}


}
