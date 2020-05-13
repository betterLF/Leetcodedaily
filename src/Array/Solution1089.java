package Array;

/**
 * @authtor liFei
 * @date 2020/5/11-19:32
 */
public class Solution1089 {
    /*
    给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
    注意：请不要在超过该数组长度的位置写入元素。
    要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
    */
    public void duplicateZeros(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if (arr[i] == 0) {
                move(arr, i + 1);
                if(i+1<arr.length) {
                    arr[i + 1] = 0;
                }
                i++;
            }
        }
    }
    private void move(int []arr,int startIndex){
        for (int i=arr.length-1;i>startIndex;i--){
            arr[i]=arr[i-1];
        }
    }
    public void duplicateZeros2(int[] arr) {
        int[] copyArr = arr.clone();//复制原函数
        int cIndex = 0;
        for(int aIndex = 0; aIndex < arr.length; aIndex++) {
            arr[aIndex] = copyArr[cIndex];//令此时的arr数组=赋值数组值
            if(copyArr[cIndex] == 0 && aIndex != arr.length - 1) {//如果此时值为0并且原数组未到末尾
                aIndex++;
                arr[aIndex] = 0;//给其下一个元素也赋值为0
            }
            cIndex++;//将arr数组的下一个元素变成复制数组的下一个元素，实现了右移。
        }
    }
}
