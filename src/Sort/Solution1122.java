package Sort;

/**
 * @authtor liFei
 * @date 2020/4/16-10:32
 */
public class Solution1122 {
    /*
    给你两个数组，arr1 和 arr2，
arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
         int tong[]=new int[1001];
         int res[]=new int[arr1.length];
         for(int i=0;i<arr1.length;i++){
             tong[arr1[i]]++;
         }
         int cur=0;
         for(int i=0;i<arr2.length;i++){
             while(tong[arr2[i]]!=0){
                 res[cur++]=arr2[i];
                 tong[arr2[i]]--;
             }
         }
         for(int i=0;i<1001;i++){
             while(tong[i]>0){
                 res[cur++]=i;
                 tong[i]--;
             }
         }
         return res;
    }

}
