public class Solution1385 {
    /*给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
    「距离值」 定义为符合此描述的元素数目：
    对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
    */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
                int count=0;
                int flag=0;
                for(int i=0;i<arr1.length;i++){
                    int j=0;
                    while (j<arr2.length){
                        if(Math.abs(arr1[i]-arr2[j])<=d){
                            flag=1;
                            break;
                        }
                        j++;
                    }
                    if(flag==0){
                        count++;
                    }else{
                        flag=0;
                    }
                }
                return count;
    }
}
