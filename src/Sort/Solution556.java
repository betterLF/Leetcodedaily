package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/8/20-6:38
 */
public class Solution556 {
    /*
    给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
     */
    public int nextGreaterElement(int n) {
        String count=Integer.toString(n);
        char []c=count.toCharArray();
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(c[c.length-1]-'0');
        for (int i = c.length-2; i>=0 ; i--) {
            if(c[i]<c[i+1]){
              long curAns = getCount(arr, c[i]-'0');
              if(curAns>Integer.MAX_VALUE){
                  return -1;
              }
                long ans=0;
                System.out.println(ans);
                for (int j = 0; j <i ; j++) {
                    ans=ans*10+(c[j]-'0');
                }
               ans=ans*(int)Math.pow(10,Integer.toString((int)curAns).length())+curAns;
             return ans>Integer.MAX_VALUE?-1:(int)ans;
            }else{
                arr.add(c[i]-'0');
            }
        }
            return -1;
    }
    private long getCount(List<Integer> list,int curCount){
        long ans=0;
        int index=-1;
        for (int i =0; i<list.size() ; i++) {
            if(list.get(i)>curCount){
                ans=list.get(i);
                index=i;
                break;
            }
        }
        list.set(index,curCount);
        for (int i =0; i<list.size() ; i++) {
            ans=ans*10+list.get(i);
        }
        return ans;
    }

}
