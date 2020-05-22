import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/21-7:29
 */
public class Solution728 {
    /*
    自除数 是指可以被它包含的每一位数除尽的数。
例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
还有，自除数不允许包含 0 。
给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList<>();
        for (int i = left; i <=right ; i++) {
            if(isRight(i,i,true)){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean isRight(int start,int cur,boolean flag){
        if(cur==0){
            return flag;
        }
        if(cur%10!=0&&start%(cur%10)==0){
            return isRight(start,cur/10,flag);
        }else{
            return false;
        }
    }
}
