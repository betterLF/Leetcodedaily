package Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @authtor liFei
 * @date 2020/5/27-6:38
 */
public class Solution974 {
    /*
给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
     */

    public int subarraysDivByK(int[] A, int K) {
            int ans=0;
            int len=A.length;
         int []sum=new int[len];
            sum[0]=A[0];
            int max=sum[0];
            int min=sum[0];
        for (int i = 1; i <len ; i++) {//得到前i项的和数组以及最大和最小值
           sum[i]=sum[i-1]+A[i];
           max=Math.max(max,sum[i]);
           min=Math.min(min,sum[i]);
        }
        int []count=new int[max-min+1];
        for (int i = 0; i <len ; i++) {//求出每个和出现的次数
            count[sum[i]-min]++;
        }
        for (int i = 0; i <max-min+1 ; i++) {
            if(count[i]==0){
                continue;
            }
            if((min+i)%K==0){
                ans+=count[i];
            }
            if(count[i]>1){
                ans+=(count[i]*(count[i]-1))/2;
            }
            int temp=K;
            int mul=count[i];
            while (i+temp<count.length){
                ans+=mul*count[i+temp];
                temp+=K;
            }
        }
        return ans;
    }
    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();//k存放模值，如K为5时，A[0]=1,key存放1，value+1
        record.put(0, 1);
        int sum = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            record.put(modulus, record.getOrDefault(modulus, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry: record.entrySet()) {
            ans += entry.getValue() * (entry.getValue() - 1) / 2;//该模出现的次数，排列组合求解
        }
        return ans;
    }
    public int subarraysDivByK3(int[] A, int K) {
        int result = 0;
        //计算前缀和
        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                arr[i] = A[i];
            } else {
                arr[i] = A[i] + arr[i - 1];
            }
        }
        //同余定理，取所有前缀和与k的余数
        //(P[j] - P[i-1])%K == 0，根据 同余定理 ，只要 P[j]%K == P[i-1]%K，就可以保证上面的式子成立。
        //要考虑取模为负值的情况
        int[] yu = new int[K];
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i] % K;
            if (a < 0) a = K + a;
            yu[a]++;
        }

        //先处理不是0的情况
        for (int i = 0; i < K; i++) {
            if (yu[i] > 1) {
                int a = yu[i];
//                for (int n = 1; n < a; n++) {
//                    result = result + n;
//                }
                result+=a*(a-1)/2;
            }
        }
        //0的情况需要加上
        result = result + yu[0];
        return result;
    }
}
