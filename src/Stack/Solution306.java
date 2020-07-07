package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/7/4-7:45
 */
public class Solution306 {
    /*
    累加数是一个字符串，组成它的数字可以形成累加序列。
一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
     */
    public  static boolean  flag;

    public static void main(String[] args) {
        isAdditiveNumber("199001200");
        System.out.println();
    }
    public static boolean isAdditiveNumber(String num) {
        Stack<Long>stack=new Stack<>();
        flag=false;
        back(stack,num,0);
        if(flag){
            return true;
        }else{
            return false;
        }
    }
    private static void back(Stack<Long>stack,String num,int startIndex){
        if(flag==true){//如果找到一个满足条件的直接返回
            return;
        }
        if(stack.size()>=3&&startIndex==num.length()){
            flag=true;
            return;
        }
        if(startIndex==num.length()){
            return;
        }
        if(num.charAt(startIndex)=='0') {//如果当前开头为0
            if (stack.size() >= 2) {
                Long temp=stack.pop();
                Long temp2=stack.peek();
                stack.push(temp);
                Long curTarget=temp+temp2;
                if(curTarget.equals((long)0)){
                    stack.push((long)0);
                    back(stack, num, startIndex + 1);
                    stack.pop();
                    return;
                }
                return;
            } else {
                stack.push((long) 0);
               // System.out.println(stack.size() + "," + stack.peek());
                back(stack, num, startIndex + 1);
                stack.pop();
                return;
            }
        }
        if(stack.size()<2){
            for (int i = startIndex+1; i <=startIndex+num.length()/2 ; i++) {
                stack.push(Long.parseLong(num.substring(startIndex,i)));
                //System.out.println(stack.size()+","+stack.peek());
                back(stack,num,i);
                stack.pop();
            }
        }else{
            Long temp=stack.pop();
            Long temp2=stack.peek();
            stack.push(temp);
            Long curTarget=temp+temp2;
            for (int i = startIndex+1; i <=num.length() ; i++) {
               Long cur=Long.parseLong(num.substring(startIndex,i));
               if(cur.equals(curTarget)){
                   stack.push(cur);
                   //System.out.println(stack.size()+","+stack.peek());
                   back(stack, num, i);
                   stack.pop();
                   break;
               }else if(cur>curTarget){
                   break;
               }
            }
        }
    }
    public boolean isAdditiveNumber2(String num) {
        if (num.length() < 3)
            return false;
        char[] array = num.toCharArray();
        // i作为第二数的起始索引，j作为第三个数的起始索引。（第一个数的位数不应超过整个字符串的一半，否则计算和必定不满足）
        for (int i=1; i<=array.length/2; i++) {
            for (int j=i+1; j<=array.length-i; j++) {
                if (add(array, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    /**
     * @param array 原始数组
     * @param i 第一个数的起始索引
     * @param j 第二个数的起始索引
     * @param k 第三个数的起始索引
     * @return true表示成功遍历到尾部，外层调用方也可直接返回true；false表示查找失败
     */
    public boolean add(char[] array, int i, int j, int k) {
        long sum = 0;
        long ten = 1;
        // c用于记录和的位数
        int c = 0;
        int n1 = j-1;
        int n2 = k-1;

        // 排除非0的，但以0开头的数
        if ((array[i]=='0' && j-i>1) || (array[j]=='0' && k-j>1))
            return false;

        // 从个位开始计算两个数的和
        while (n1>=i && n2>=j) {
            sum += ((array[n1--]-'0') + (array[n2--]-'0')) * ten;
            ten *= 10;
            c++;
        }
        // 计算剩余高位的和
        while (n1>=i) {
            sum += (array[n1--]-'0') * ten;
            ten *= 10;
            c++;
        }
        // 计算剩余高位的和
        while (n2>=j) {
            sum += (array[n2--]-'0') * ten;
            ten *= 10;
            c++;
        }

        // 和的位数
        int size = k+c;
        // 和的位数超出数组大小，则返回失败
        if (array.length < size)
            return false;

        if (ten > sum) {
            // ten大于和的情况，例如sum=19=9+10，ten=100
            // ten除以10，用于后续比较第三个数
            ten /= 10;
        } else {
            // ten小等于和的情况，例如sum=10=9+1，ten=10
            // 有进位，和的位数需要补充加一
            size++;
        }

        // 和与数组中接下来的字符比较
        for (int l=k; l<size; l++) {
            int n = (int) (sum / ten);
            // 有一个字符不相等，即返回失败
            if (array[l]-'0' != n) return false;
            sum %= ten;
            ten /= 10;
        }
        // 执行到这里说明第三个数匹配成功

        // 第三个数刚好抵达数组尾部，则返回true，否则继续回溯递归
        return array.length == size || add(array, j, k, size);
    }

    long[] path;
    public boolean isAdditiveNumber3(String num) {
        char[] chars = num.toCharArray();
        path = new long[1000];
        return dfs(chars, 0, 0);
    }

    public boolean dfs(char[] chars, int start, int index) {
        if (start == chars.length) {
            //到达终点，判断是否有至少 3 个数
            return index > 2;
        }
        long num = 0;
        //用 len 来判断是否存在 01 这种情况
        int len = 0;
        for (int i = start; i < chars.length; i++) {
            num *= 10;
            num += chars[i] - '0';
            len++;
            if (String.valueOf(num).length() < len) {
                //出现了 01 这种情况，是不允许的，直接返回 false
                return false;
            }
            path[index] = num;
            //如果当前的累加数个数小于 3 个，就不用判断是否满足构成累加数的要求
            if (index < 2) {
                if (dfs(chars, i + 1, index + 1)) {
                    return true;
                }
                continue;
            }
            //当前的累加数个数大于等于 3 个，需要判断是否满足条件
            if (path[index] == path[index - 1] + path[index - 2]) {
                if (dfs(chars, i + 1, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}


