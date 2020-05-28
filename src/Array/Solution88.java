package Array;

/**
 * @authtor liFei
 * @date 2020/5/27-7:41
 */
public class Solution88 {
    /*
    给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
                  int []temp=new int[m];
        for (int i = 0; i <m ; i++) {
            temp[i]=nums1[i];
        }
        int i=0;
        int j=0;
        int count=0;
        while (i!=m&&j!=n){
            if(temp[i]<=nums2[j]){
                nums1[count]=temp[i];
                i++;
            }else{
                nums1[count]=nums2[j];
                j++;
            }
            count++;
        }
        if(i==m){
            for (int k = j; k <n ; k++) {
                nums1[count]=nums2[k];
                count++;
            }
        }else{
            for (int k = i; k <m ; k++) {
                nums1[count]=temp[k];
                count++;
            }
        }
    }
}
