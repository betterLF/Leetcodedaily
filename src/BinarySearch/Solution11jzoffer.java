package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/7/22-7:06
 */
public class Solution11jzoffer {
    /*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
    输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     */
    public int ans;
    public boolean flag;
    public int minArray(int[] numbers) {
        ans=numbers[0];
        flag=false;
        fenzhi(numbers,0,numbers.length-1);
        return ans;
    }
    private void fenzhi(int []numbers,int left,int right){
        if(left>right){
            return;
        }
        int mid=left+(right-left)/2;
        if(mid+1<numbers.length&&numbers[mid]>numbers[mid+1]){
            ans=numbers[mid+1];
            flag=true;
            return;
        }
        if(mid-1>=0&&numbers[mid]<numbers[mid-1]){
            ans=numbers[mid-1];
            flag=true;
            return;
        }
        if(!flag){
            fenzhi(numbers,left,mid-1);
        }
        if(!flag){
            fenzhi(numbers, mid+1,right);
        }
    }
    public int minArray2(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;//结果在右边
            else if (numbers[m] < numbers[j]) j = m;//结果在左边
            else j--;//说明两点相同，减去最后一个去重
        }
        return numbers[i];//返回第一个
    }
}
