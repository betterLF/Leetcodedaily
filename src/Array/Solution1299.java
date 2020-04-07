public class Solution1299 {
    /*
    给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
     完成所有替换操作后，请你返回这个数组。
     */
    public int[] replaceElements(int[] arr) {
        int max=-1;
        int len=arr.length;
        int c=0;//存储修改之前的元素
        c=arr[len-1];
        arr[len-1]=-1;
        max=max>c?max:c;
        for(int i=arr.length-2;i>=0;i--){
            c=arr[i];
            arr[i]=max;
            max=max>c?max:c;
        }
        return arr;
    }
}
