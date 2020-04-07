import java.util.ArrayList;
import java.util.List;

public class Solution1389 {
    /*
    给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：  目标数组 target 最初为空。
    按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
    重复上一步，直到在 nums 和 index 中都没有要读取的元素。 请你返回目标数组。  题目保证数字插入位置总是存在。
     */
    public int[] createTargetArray(int nums[],int index[]){
        int len=nums.length;
        int res[]=new int[len];
        for(int i=0;i<len;i++){
            res[i]=-1;
        }
        for(int i=0;i<len;i++){
            insert(res,index[i],nums[i]);
        }
        return res;
    }
    private int[] insert(int res[],int index,int num){
        if(res[index]==-1){
            res[index]=num;
        }else{
            int count=index;
            while(res[count]!=-1){
                count++;
            }
            for(;count>index;count--){
                res[count]=res[count-1];
            }
            res[count]=num;
        }
        return res;
    }
    //别人的，速度和我差不多，但是用了系统方法
    public int[] createTargetArray2(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            res.add(index[i], nums[i]);
        }
        int[] target = new int[n];
        for(int i = 0; i < n; i++){
            target[i] = res.get(i);
        }
        return target;
    }
}
