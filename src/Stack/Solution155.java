package Stack;

/**
 * @authtor liFei
 * @date 2020/5/12-6:27
 */
public class Solution155 {
    /*
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
     */
//    Stack<Integer> ans;
//    Queue<Integer> minVal;
//    public Solution155() {
//           ans=new Stack<>();
//           minVal=new PriorityQueue<>();
//    }
//
//    public void push(int x) {
//      ans.add(x);
//      minVal.add(x);
//    }
//
//    public void pop() {
//     if(!ans.empty()){
//         minVal.remove(ans.peek());
//         ans.pop();
//     }
//    }
//
//    public int top() {
//        if(!ans.empty()) {
//            return ans.peek();
//        }else{
//            return -1;
//        }
//    }
//
//    public int getMin() {
//        if(!ans.empty()){
//           return minVal.peek();
//        }else{
//            return -1;
//        }
//    }
    int[] val;
    int[] minVal;
    int capacity=10;
    int size=0;
    public Solution155() {
         val=new int[capacity];
         minVal=new int[capacity];
    }

    public void push(int x) {
        if (size > capacity) {
            resize();
        } else {
            val[size] = x;
            if (size!=0) {
                minVal[size] = Math.min(minVal[size - 1], x);//获得当前元素个数时的最小值
            }else{
                minVal[size]=x;
            }
            size++;//指向下一个要添加元素的下标
        }
    }
    public void pop() {
        if(size!=0){
           size--;//最小值和值都往前移一格
        }
    }

    public int top() {
        if(size!=0) {
            return val[size-1];
        }else{
            return -1;
        }
    }

    public int getMin() {
        if(size!=0) {
            return minVal[size - 1];
        }else{
            return -1;
        }
    }
    public void resize(){//动态扩容
        capacity*=1.5;
        int[] copyValue = new int[capacity];
        int[] copyMinValue = new int[capacity];
        System.arraycopy(val, 0, copyValue, 0, size);
        System.arraycopy(minVal, 0, copyMinValue, 0, size);
        val = copyValue;
        minVal= copyMinValue;
    }
}
