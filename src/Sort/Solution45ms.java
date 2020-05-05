package Sort;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/3-8:33
 */
public class Solution45ms {
    /*
    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     */
    public String minNumber(int[] nums) {
        String s[]=new String[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            s[i]=String.valueOf(nums[i]);
        }
//        Arrays.sort(s, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if((o1+o2).compareTo(o2+o1)<0){
//                    return -1;
//                }
//                return 1;
//            }
//        });
        Arrays.sort(s, (o1,o2)->((o1+o2).compareTo(o2+o1)));
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <s.length ; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    }
}
