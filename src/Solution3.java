import java.util.HashMap;

public class Solution3 {
    public  int lengthOfLongestSubstring(String s) {
        char arr[] = s.toCharArray();//将字符串转化成数组
        int max = 0;//记录前i个元素中不重复子串长度最大值
        int cur = 0;//记录当前不重复子串长度
        int startIndex = 0;//记录当前不重复子串的起始下标
        HashMap<Character, Integer> c = new HashMap<Character, Integer>();
        //只在出现重复元素和到达数组尾部对max求解
        for (int i = 0; i < arr.length; i++) {
            //如果c中不存在arr[i]或者是当前起始位置在上一个该元素出现之后，就将arr[i]加入c中
            if (!c.containsKey(arr[i]) || c.get(arr[i]) < startIndex) {
                c.put(arr[i], i);
                if (i == arr.length - 1) {//防止从当前起始位置到数组末尾都没有出现重复元素，出现不计算该子串长度的情况
                    cur = i- startIndex + 1;
                    max = (max > cur) ? max : cur;
                }
            } else {//arr[i]在当前起始位置后出现过
                cur = (i - 1 - startIndex) + 1;//计算当前起始位置到该arr[i]出现之前的子串长度
                max = (max > cur) ? max : cur;
                startIndex = c.get(arr[i]) + 1;//起始位置变为上一个该元素的下一个位置，去除重复元素
                c.put(arr[i], i);
            }
        }
        return max;
    }
    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;//记录前i个元素中不重复子串长度最大值
        int cur = 0;//记录当前不重复子串长度
        int startIndex = 0;//记录不重复子串的起始下标
        int length=s.length();
        HashMap<Character, Integer> c = new HashMap<Character, Integer>();//存储元素及其下标，下标动态更新
        for (int i = 0; i < length; i++) {
            if (!c.containsKey(s.charAt(i))|| c.get(s.charAt(i)) < startIndex) {//如果起始位置在上一个该元素出现之后，就加入该元素
                c.put(s.charAt(i), i);
                if (i == length - 1) {//防止最后一个元素不重复，不计算长度
                    int last =length - 1 - startIndex + 1;
                    max = (max > last) ? max : last;
                }
            } else {
                cur = (i - 1 - startIndex) + 1;
                max = (max > cur) ? max : cur;
                startIndex = c.get(s.charAt(i)) + 1;
                c.put(s.charAt(i), i);//动态更新该元素下标
            }
        }
        return max;
    }
    /*
    我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
也就是说，如果 s[j]s 在 [i, j) 范围内有与 j'重复的字符，我们不需要逐渐增加 i 。 我们可以直接跳过 [i，j']范围内的所有元素，并将 i变为 j' + 1。
时间复杂度：O(n)=O(n)，

空间复杂度：O(min(m, n))，与之前的方法相同。滑动窗口法需要 O(k) 的空间，
其中 k表示 Set 的大小。而 Set 的大小取决于字符串 n 的大小以及字符集 / 字母 m 的大小。
     */
    public  int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        //创建map窗口,i为左区间，j为右区间，右边界移动
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            // 如果窗口中包含当前字符，
            if (map.containsKey(s.charAt(j))) {
                //左边界移动到 相同字符的下一个位置和i当前位置中更靠右的位置，这样是为了防止i向左移动
                i = Math.max(map.get(s.charAt(j)), i);//这时候的i值要么不变，要么是该元素上一个相同元素的下一个位置
            }
            //比对当前无重复字段长度和储存的长度，选最大值并替换
            //j-i+1是因为此时i,j索引仍处于不重复的位置，j还没有向后移动，取的[i,j]长度
            ans = Math.max(ans, j - i + 1);
            // 将当前字符为key，下一个索引为value放入map中
            // value为j+1是为了当出现重复字符时，i直接跳到上个相同字符的下一个位置，if中取值就不用+1了
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

}
