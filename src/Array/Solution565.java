package Array;

/**
 * @authtor liFei
 * @date 2020/5/12-12:35
 */
public class Solution565 {
    /*
    索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
     */
    public int arrayNesting(int[] nums) {
         int len=nums.length;
         boolean isVisited[]=new boolean[len];
         int ansMax=0;
         for (int i=0;i<len;i++){
             if(isVisited[i]!=true){
                 int count=1;
                 int index=nums[i];
                 isVisited[i]=true;
                 while (isVisited[index]!=true){
                     count++;
                     isVisited[index]=true;
                     index=nums[index];
                 }
                 ansMax=Math.max(count,ansMax);
             }
         }
         return ansMax;
    }
}
