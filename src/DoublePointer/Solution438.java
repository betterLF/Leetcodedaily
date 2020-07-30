package DoublePointer;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/7/27-6:25
 */
public class Solution438 {
    /*
    给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
说明：
字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
     */
    public List<Integer> findAnagrams(String s, String p) {
          List<Integer> ans=new ArrayList<>();
          int []num=new int[26];
        HashSet<Character> set=new HashSet<>();
        for (int i = 0; i <p.length() ; i++) {
            num[p.charAt(i)-'a']++;
            set.add(p.charAt(i));
        }
        int []copy= Arrays.copyOf(num,26);
        int curlen=0;
        int len=p.length();
        char []ss=s.toCharArray();
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = 0; i <ss.length; i++) {
              int curIndex=ss[i]-'a';
              if(copy[curIndex]!=0){//如果当前字母出现在p中并且还有剩余
                  copy[curIndex]--;
                  curlen++;
                 list.add(i);//将在p中出现过的单词索引加入集合中
              }else{
                    if(set.contains(ss[i])){//如果当前点出现在子字符串中，则要把上一个出现的该字符删掉
                        while (ss[list.get(0)]!=ss[i]){//只要不是该字符
                            Integer remove = list.remove(0);//将该点移除集合
                            copy[ss[remove]-'a']++;//该位置加1复原
                            curlen--;
                        }
                        //找到第一个重合的字符后将其移除
                        Integer remove = list.remove(0);//将该点移除集合
                        //将当前字符加入
                        list.add(i);
                    }else{//如果该字符不存在,重置
                        curlen=0;
                        copy= Arrays.copyOf(num,26);
                        list.clear();
                    }
              }
              if(curlen==len){//当前找到一组结果
                  Integer remove = list.remove(0);//找到起点并移除集合
                  ans.add(remove);
                  copy[ss[remove]-'a']++;//该位置加1复原
                  curlen--;//当前得到的数组长度-1
              }
        }
        return ans;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        //转化为char array
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        List<Integer> list = new ArrayList<>();

        //定义两个hash数组
        char[] s_letter = new char[26]; // 滑动窗口hash
        char[] p_letter = new char[26]; //目标数组hash
        //hash p数组
        for(int i = 0; i < p_arr.length;i++){
            p_letter[p_arr[i] - 'a']++;
        }

        //滑动窗口
        int left = 0;
        int right = 0;

        //当窗口右边出界 则退出
        while (right < s_arr.length){
            //获取当前最右边的字符的hash值
            int current_char_index = s_arr[right++] - 'a';
            //当前最优字符加入hash
            s_letter[current_char_index]++;
            //当前字符的hash值 大于 目标数组（溢出） 1.当前字符不在目标数组中 2.当前字符有重复数组 左边界右移缩小窗口
            //主要技巧点 可以进行手动验证
            while (p_letter[current_char_index] < s_letter[current_char_index]){//如果当前该位置的元素出现个数大于p字符串
                //则窗口右移
                s_letter[s_arr[left] - 'a']--;
                left++;
            }
            //当出现窗口大小等于目标数组的大小的时候 匹配成功+1
            if(right - left == p_arr.length){
                list.add(left);
            }
        }
        return list;
    }
}
