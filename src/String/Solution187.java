package String;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/6/19-10:14
 */
public class Solution187 {
    /*
   所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，
   识别 DNA 中的重复序列有时会对研究非常有帮助。
编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
     */
    public List<String> findRepeatedDnaSequences(String s) {
         List<String> ans=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        if(s.length()<=10){
            return ans;
        }
        for (int i = 0; i <s.length()-9 ; i++) {
            String cur=s.substring(i,i+10);
            if(set.contains(cur)&&!ans.contains(cur)){
                ans.add(cur);
            }else{
                set.add(cur);
            }
        }
        return ans;
    }
    public List<String> findRepeatedDnaSequences2(String s) {
        int L = 10, n = s.length();
        if (n <= L) return new ArrayList();
        Map<Character, Integer> toInt = new
                HashMap() {{
                    put('A', 0);
                    put('C', 1);
                    put('G', 2);
                    put('T', 3);
                }};//将每个字符都转成对应的整数
        int[] nums = new int[n];//得到对应的数字数组
        for (int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));
        int bitmask = 0;
        Set<Integer> seen = new HashSet();
        Set<String> output = new HashSet();
        for (int start = 0; start < n - L + 1; ++start) {
            if (start != 0) {
                //添加一个数到末尾
                bitmask <<= 2;//将前一个数代表的两位二进制数移出，用两个0补齐
                bitmask |= nums[start + L - 1];//两个0转成下一个数的二进制码
                //删除前导的一位数，其中3<<2L指的是一个数与对应前导位对应的下标位变为11，在将其取反得到001111111，这样与原来相与，前两位置01，即删除，后面不变
                bitmask &= ~(3 << 2 * L);
            } else {//得到第一个10位数的二进制对应码数
                for (int i = 0; i < L; ++i) {
                    bitmask <<= 2;
                    bitmask |= nums[i];
                }
            }
            if (seen.contains(bitmask)) output.add(s.substring(start, start + L));//如果该二进制对应码数已经出现过，结果集就加入该元素
            seen.add(bitmask);//将此码数加入出现的码数集合中
        }
        return new ArrayList<String>(output);
    }
    }

