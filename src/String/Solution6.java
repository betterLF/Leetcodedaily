package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/2-19:03
 */
public class Solution6 {
    /*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
     */
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<List<Character>> ans=new ArrayList<>();
        for (int i = 0; i <numRows ; i++) {
            ans.add(new ArrayList<>());
        }
        int curRow=0;//此时走到的行号
        boolean flag=true;//为true代表往下走，为false代表往上走
        for (char c:s.toCharArray()){
            ans.get(curRow).add(c);
            if(curRow==numRows-1){//走到末尾
                curRow--;
                flag=false;//往上走
            }else if(curRow==0){
                curRow++;
                flag=true;//往下走
            }else{
//                if(flag==false){
//                    curRow--;
//                }else{
//                    curRow++;
//                }
                curRow+=(flag==true?1:-1);
            }
        }
        StringBuilder res=new StringBuilder();
        for (int i = 0; i <ans.size() ; i++) {
            int len=ans.get(i).size();
            List<Character> cur=ans.get(i);
            for (int j = 0; j <len ; j++) {
                res.append(cur.get(j));
            }
        }
        return res.toString();
    }
    public String convert2(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<StringBuilder> ans=new ArrayList<>();
        for (int i = 0; i <numRows ; i++) {
            ans.add(new StringBuilder());
        }
        int curRow=0;//此时走到的行号
        boolean flag=true;//为true代表往下走，为false代表往上走
        for (char c:s.toCharArray()){
            ans.get(curRow).append(c);
            if(curRow==numRows-1){//走到末尾
                curRow--;
                flag=false;//往上走
            }else if(curRow==0){
                curRow++;
                flag=true;//往下走
            }else{
                if(flag==false){
                    curRow--;
                }else{
                    curRow++;
                }
            }
        }
        StringBuilder res=new StringBuilder();
        for (int i = 0; i <ans.size() ; i++) {
          res.append(ans.get(i));
        }
        return res.toString();
    }
}
