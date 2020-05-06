package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/5-7:24
 */
public class Solution1200 {
    /*
    给你个整数数组 arr，其中每个元素都 不相同。
请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
          List<List<Integer>> ans=new ArrayList<>();
         Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for (int i=1;i<arr.length;i++){
            if(min<arr[i]-arr[i-1]){
                continue;
            }else if(min==arr[i]-arr[i-1]){
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
            }else{
                ans.clear();
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
                min=arr[i]-arr[i-1];
            }
        }
        return ans;
    }
}
