package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/7-7:29
 */
public class Solution0304ms {
    /*
实现一个MyQueue类，该类用两个栈来实现一个队列。
MyQueue queue = new MyQueue();
queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false
     */
    class MyQueue {
        public Stack<Integer>  s1;
       public Stack<Integer> s2;
        public MyQueue() {
            s1=new Stack<>();
            s2=new Stack<>();
        }
        public void push(int x) {
         if(s1.empty()){
             while(!s2.empty()){
                 s1.push(s2.pop());
             }
             s2.push(x);
             while (!s1.empty()){
                 s2.push(s1.pop());
             }
         }else{
             while (!s1.empty()){
                 s2.push(s1.pop());
             }
             s1.push(x);
             while (!s2.empty()){
                 s1.push(s2.pop());
             }
         }
        }

        public int pop() {
            if(empty()){
                return -1;
            }
             if(!s1.empty()){
               return   s1.pop();
             }else{
                return s2.pop();
             }
        }
        public int peek() {
            if(empty()){
                return -1;
            }
           if(!s1.empty()){
               return s1.peek();
           }else{
               return s2.peek();
           }
        }

        public boolean empty() {
             return s1.empty()&&s2.empty();
        }
    }
}
