package Math;

import java.util.ArrayList;

/**
 * @authtor liFei
 * @date 2020/5/25-6:46
 */
public class Solution9 {
    /*
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(2147483647));
        System.out.println(isPalindrome(123404321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if(x<10){
            return true;
        }
        ArrayList<Integer> ans=new ArrayList<>();
     while (x!=0){
            ans.add( x % 10);
            x /= 10;
        }
        int i = 0;
        int j =ans.size()-1;
        while (i < j) {
            if (ans.get(i) != ans.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
