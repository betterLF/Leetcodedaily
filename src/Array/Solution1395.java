public class Solution1395 {
    /*
    n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
    每 3 个士兵可以组成一个作战单位，分组规则如下：  从队伍中选出下标分别为 i、j、k 的 3 名士兵，
    他们的评分分别为 rating[i]、rating[j]、rating[k] 作战单位需满足：
    rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，
    其中  0 <= i < j < k < n 请你返回按上述条件可以组建的作战单位数量。
    每个士兵都可以是多个作战单位的一部分。
     */
    public int numTeams(int rating[]){
        int count=0;
        int count1=0;//计算存入递增数组的元素个数
        int count2=0;//计算存入递减数组的元素个数
        int ins[]=new int[rating.length*rating.length];
        int dec[]=new int[rating.length*rating.length];
        //第一回递增，递减比较（作战单位第一，二个士兵有序）
         for(int i=0;i<rating.length;i++){
             for(int j=i+1;j<rating.length;j++){
                 if(rating[i]<rating[j]){
                    ins[count1++]=j;//递增数组存放j的下标
                 }else if(rating[i]>rating[j]){
                     dec[count2++]=j;//递减数组存放j的下标
                 }
             }
         }
         //第二回递增递减比较
         for(int i=0;i<count1;i++){
             for(int k=ins[i]+1;k<rating.length;k++){//此时比较应该从ins[i](即第二个士兵）的下个士兵开始
                 // 与第二个士兵的rating值进行比较，大于第二个士兵，count就++
                 if(rating[k]>rating[ins[i]]){
                     count++;
                 }
             }
         }
        for(int i=0;i<count2;i++){
            for(int k=dec[i]+1;k<rating.length;k++){
                if(rating[k]<rating[dec[i]]){
                    count++;
                }
            }
        }
        return count;
    }
    //别人答案，厉害
    public int numTeams2(int[] rating) {
        int n = rating.length;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            int[] left = count(rating, 0, i, rating[i]);
            int[] right = count(rating, i, n, rating[i]);
            result += left[0] * right[1] + left[1] * right[0];
        }
        return result;
    }

    private int[] count(int[] rating, int from, int to, int key) {
        int[] results = new int[2];
        for (int i = from; i < to; ++i) {
            if (rating[i] < key) {
                ++results[0];
            } else if (rating[i] > key) {
                ++results[1];
            }
        }
        return results;
    }

}
