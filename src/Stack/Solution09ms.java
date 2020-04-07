package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/7-18:23
 */
public class Solution09ms {
    /*
    用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
    分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     */
    class CQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        public CQueue() {
            s1=new Stack<>();
            s2=new Stack<>();
        }
        public void appendTail(int value) {
               if(s1.empty()){
                   while(!s2.empty()){
                       s1.push(s2.pop());
                   }
                   s1.push(value);
                   while(!s1.empty()){
                       s2.push(s1.pop());
                   }
               }else{
                   while(!s1.empty()){
                       s2.push(s1.pop());
                   }
                   s2.push(value);
                   while(!s2.empty()){
                       s1.push(s2.pop());
                   }
               }
        }

        public int deleteHead() {
            if(s1.empty()&&s2.empty()){
                return -1;
            }else if(s1.empty()){
                return s2.pop();
            }else{
                return s1.pop();
            }
        }
    }
}
