package Math;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/6/20-7:58
 */
public class Solution202 {
    /*
    编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
如果 n 是快乐数就返回 True ；不是，则返回 False 。
     */
    public static void main(String[] args) {
        isHappy(19);
    }
    public static boolean isHappy(int n) {
        int ans=0;
        int curNum=n;
        HashSet<Integer> set=new HashSet<>();
        while (!set.contains(curNum)) {
            set.add(curNum);
        while (curNum>=10){
            ans+=(curNum%10)*(curNum%10);
            curNum=(curNum-curNum%10)/10;
        }
        ans+=curNum*curNum;
        if(ans==1){
            return true;
        }else{
            curNum=ans;
            ans=0;
        }
        }
        return false;
    }
}
