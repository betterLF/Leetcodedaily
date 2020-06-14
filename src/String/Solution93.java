package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/6/12-7:14
 */
public class Solution93 {
    /*
    给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
     */
   static List<String> ans;

    public static void main(String[] args) {
        restoreIpAddresses( "25525511135");
    }
    public static List<String> restoreIpAddresses(String s) {

           ans=new ArrayList<>();
           Stack<String> stack=new Stack<>();
           back(stack,s,0,0);
           return ans;
    }
    private static void back(Stack<String> stack,String s, int count,int startIndex) {
        if(count==4&&startIndex==s.length()){
            StringBuilder cur=new StringBuilder();
            for (int i = 0; i <stack.size()-1 ; i++) {
                cur.append(stack.get(i)).append('.');
            }
            cur.append(stack.get(stack.size()-1));
            ans.add(cur.toString());
            return;
        }
        if (((4 - count) * 3 < s.length() - startIndex) || ((4 - count) * 1 > s.length() - startIndex)) {//剪枝
            return;
        }
        if (s.charAt(startIndex) == '0') {//如果首位为0，只能放单独一个
            stack.push(s.substring(startIndex, startIndex + 1));
            back(stack, s, count + 1, startIndex + 1);
            stack.pop();
        } else {
            stack.push(s.substring(startIndex, startIndex + 1));
            back(stack, s, count + 1, startIndex + 1);
            stack.pop();
            if (startIndex + 1 <= s.length() - 1) {
                stack.push(s.substring(startIndex, startIndex + 2));
                back(stack, s, count + 1, startIndex + 2);
                stack.pop();
            }
            if (startIndex + 2 <= s.length() - 1) {
                String cur = s.substring(startIndex, startIndex + 3);//判断能否放3个
                if (Integer.parseInt(cur) <= 255) {
                    stack.push(cur);
                    back(stack, s, count + 1, startIndex + 3);
                    stack.pop();
                }
            }
        }
    }
}
