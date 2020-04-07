package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/7-10:24
 */
public class Solution1381 {
    /*
   请你设计一个支持下述操作的栈。
实现自定义栈类 CustomStack ：
CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
     */
 //额外栈解法
    static class  CustomStack {
        private Stack<Integer> res;
        private int count;
        private int maxSize;
        public CustomStack(int maxSize) {
         res=new Stack<>();
          count=0;
          this.maxSize=maxSize;
        }

        public void push(int x) {
          if(count==maxSize){
              return ;
          }else{
              res.push(x);
              count++;
          }
        }

        public int pop() {
            if(count==0){
                return -1;
            }else{
                count--;
                return res.pop();
            }
        }
        public void increment(int k, int val) {
            Stack<Integer> s1=new Stack();//用于＋操作
            Stack<Integer> s2=new Stack();
            int num=count-k;
            int count2=count;
            int count3=count;
            if(num<=0){
                while(count!=0){
                    s1.push(res.pop()+val);
                    count--;
                }
            }else{
                while (num!=0){
                    s1.push(res.pop());
                    num--;
                }
                while (k!=0){
                    s1.push(res.pop()+val);
                    k--;
                }
            }
            while (count2!=0){
                res.push(s1.pop());
                count2--;
            }
            count=count3;
        }

    }
    static class  CustomStack2 {
        private int count;
        private int maxSize;
        private int arr[];
        public CustomStack2(int maxSize) {
            count=0;
            this.maxSize=maxSize;
            arr=new int[maxSize];
        }

        public void push(int x) {
            if(count==maxSize){
                return ;
            }else{
            arr[count]=x;
                count++;
            }
        }

        public int pop() {
            if(count==0){
                return -1;
            }else{
            return arr[--count];
            }
        }
        public void increment(int k, int val) {
            for (int i = 0; i <k&&i<count ; i++) {
                arr[i]+=val;
            }
        }

    }
}
