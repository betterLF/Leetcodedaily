package Bitwise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/11-9:02
 */
public class Solution89 {
    /*
    格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
格雷编码序列必须以 0 开头。
     */
    List<Integer> ans;
    public List<Integer> grayCode(int n) {
        List<Integer> ans=new ArrayList<>();
        HashSet<Integer> curAns=new HashSet<>();
         int preNum=0;
         curAns.add(0);
         ans.add(0);
        for (int i = 1; i <Math.pow(2,n) ; i++) {
            preNum=choice(curAns,preNum);
            ans.add(preNum);
        }
        return ans;
    }
    private int choice(HashSet<Integer> curAns,int preNum){
        for (int i = 0; i <32 ; i++) {
            int temp=preNum^(1<<i);
            if(!curAns.contains(temp)){
                curAns.add(temp);
                return temp;
            }
        }
        return 0;
    }
}
