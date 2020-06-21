package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/6/18-8:19
 */
public class Solution150 {
    /*
    根据 逆波兰表示法，求表达式的值。
有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     */
    //栈 7ms
    public int evalRPN(String[] tokens) {
        Stack<Integer> num=new Stack<>();
        for (int i = 0; i <tokens.length ; i++) {
            String temp=tokens[i];
            if(tokens[i].equals("+")){
                num.push(num.pop()+num.pop());
            }else if(tokens[i].equals("-")){
                int cur=num.pop();
                num.push(num.pop()-cur);
            }else if(tokens[i].equals("*")){
                num.push(num.pop()*num.pop());
            }else if(tokens[i].equals("/")){
                int cur=num.pop();
                num.push(num.pop()/cur);
            }else{
                num.push(Integer.parseInt(temp));
            }
        }
        return num.pop();
    }
    //数组模拟 3ms
    public static int evalRPN2(String[] tokens) {
        int[] numStack = new int[tokens.length / 2 + 1];//最多同时有这么多
        int index = 0;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    numStack[index - 2] += numStack[--index];//--使得到达已经有值的位置
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                default:
                    numStack[index++] = Integer.parseInt(s);//如果为数字，就存入数组，并执行++操作
                    break;
            }
        }
        return numStack[0];
    }
}
