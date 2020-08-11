package Competition;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/8/9-9:32
 */
public class zhousai201 {
    /*
给你一个由大小写英文字母组成的字符串 s 。
一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
0 <= i <= s.length - 2
s[i] 是小写字符，但 s[i + 1] 是对应的大写字符；反之亦然 。
请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
     */
    public String makeGood(String s) {
         char []c=s.toCharArray();
        LinkedList<Character> list=new LinkedList<>();
        for (int i = 0; i <c.length; i++) {
            list.add(c[i]);
        }
         while (true){
             int i=0;
             boolean flag=false;
             for (; i <list.size()-1 ; i++) {
                 if ((Math.abs(list.get(i)-list.get(i+1))==32)) {
                     flag = true;
                     break;
                 }
             }
                 if(flag){
                     list.remove(i);
                     list.remove(i);
                 }else{
                     break;
                 }
         }
             StringBuilder ans=new StringBuilder();
             for (Character cur:list){
                 ans.append(cur);
             }
         return ans.toString();
    }


    /*
给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
S1 = "0"
当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）
例如，符合上述描述的序列的前 4 个字符串依次是：
S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
     */
    public char findKthBit(int n, int k) {
        String []ans=new String[20];
        ans[0] = "0";
        ans[1] = "011";
        ans[2]= "0111001";
        ans[3]= "011100110110001";
        if(n<=4){
            return ans[n-1].charAt(k-1);
        }
        for (int i = 4; i <n ; i++) {
            ans[i]=get(ans[i-1]);
        }
        return ans[n-1].charAt(k-1);
    }
    private String get(String temp){
        StringBuilder ans=new StringBuilder();
        ans.append(temp).append('1');
        for (int i=temp.length()-1;i>=0;i--){
           if(temp.charAt(i)=='0'){
               ans.append('1');
           }else{
               ans.append('0');
           }
        }
        return ans.toString();

    }


    /*
给你一个数组 nums 和一个整数 target 。
请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
     */
    public int maxNonOverlapping(int[] nums, int target) {
       List<int []> arr=new ArrayList<>();
       HashMap<Long,ArrayList<Integer>> map=new HashMap();
         long ans=0;
        ArrayList<Integer> t=new ArrayList<>();
        t.add(-1);
        map.put((long)0,t);
        for (int i = 0; i <nums.length ; i++) {
                ans+=nums[i];
                if(map.containsKey(ans)){
                    map.get(ans).add(i);
                }else{
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    map.put(ans,temp);
                }
        }
            for (Long key:map.keySet()){
                if(map.containsKey(key+target)){
                    ArrayList<Integer> c1=map.get(key);
                    ArrayList<Integer> c2=map.get(key+target);
                    for (int i = 0; i <c1.size() ; i++) {
                        for (int j = 0; j <c2.size() ; j++) {
                            if(c1.get(i)<c2.get(j)){
                                arr.add(new int[]{c1.get(i)+1,c2.get(j)});
                                break;
                            }
                        }
                    }
                }
            }
        if (arr.size() == 0) return 0;
        // 按 end 升序排序
        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
        }
    });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = arr.get(0)[1];
        for (int[] interval : arr) {
            int start = interval[0];
            if (start > x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }

}
