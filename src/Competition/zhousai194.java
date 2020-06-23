package Competition;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/6/21-9:49
 */
public class zhousai194 {
    /*
给你两个整数，n 和 start 。
数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     */
    public int xorOperation(int n, int start) {
        int j = start;
        int ans = j;
        for (int i = 1; i < n; i++) {
            j += 2;
            ans ^= j;
        }
        return ans;
    }

    /*
给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，
其中 k 是能保证文件名唯一的 最小正整数 。
返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
     */
    public String[] getFolderNames(String[] names) {
        int len = names.length;
        String[] ans = new String[len];
        HashMap<String, Integer> set = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!set.containsKey(names[i])) {
                ans[i] = names[i];
                set.put(names[i], 0);
            } else {
                int temp = set.get(names[i]) + 1;
                StringBuilder cur = new StringBuilder(names[i]);
                cur.append('(');
                while (true) {
                    StringBuilder tt = new StringBuilder(cur);
                    tt.append(temp).append(')');
                    if (!set.containsKey(tt.toString())) {
                        set.put(tt.toString(), 0);
                        set.put(names[i], temp);
                        ans[i] = tt.toString();
                        break;
                    } else {
                        temp++;
                    }
                }

            }
        }
        return ans;
    }

    /*
你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨的时候，如果第 n 个湖泊是空的，那么它就会装满水
，否则这个湖泊会发生洪水。你的目标是避免任意一个湖泊发生洪水。
给你一个整数数组 rains ，其中：
rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
请返回一个数组 ans ，满足：
ans.length == rains.length
如果 rains[i] > 0 ，那么ans[i] == -1 。
如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生（详情请看示例 4）。
     */
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] ans = new int[len];
        HashMap<Integer, Integer> river = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (rains[i] > 0) {
                ans[i] = -1;
                if (river.containsKey(rains[i])) {
                    return new int[0];
                }
                river.put(rains[i], 0);//将已经满的湖泊加入到该集合中
            } else {//选择一个湖泊抽干
                if (river.size() == 0) {//湖水都已经抽干
                    ans[i] = 1;
                    continue;
                } else {//贪心
                    int j = i + 1;
                    boolean flag = false;
                    for (; j < len; j++) {//如果找到下一个最快要下雨的湖泊
                        if (river.containsKey(rains[j])) {
                            river.remove(rains[j]);
                            ans[i] = rains[j];
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {//如果都没找到
                        for (Integer key : river.keySet()) {
                            ans[i] = key;
                            river.remove(key);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 0, 1, 2};
        avoidFlood2(a);
    }

    public static int[] avoidFlood2(int[] rains) {
        int len = rains.length;
        int[] ans = new int[len];
        ArrayList<Integer> river = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> set = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {//将每个要下雨的湖泊其对应的天数加入hashmap的value值中
            if (rains[i] == 0) {
                continue;
            }
            if (!set.containsKey(rains[i])) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                set.put(rains[i], temp);
            } else {
                set.get(rains[i]).add(i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (rains[i] > 0) {//如果当前下雨
                ans[i] = -1;//值置为1
                if (river.contains(rains[i])) {//如果已经出现过
                    return new int[0];
                }
                river.add(rains[i]);//将已经满的湖泊加入到该集合中
                set.get(rains[i]).remove(0);//将该下雨的湖泊开头元素移除，代表该天结束
            } else {//选择一个湖泊抽干
                if (river.size() == 0) {//湖水都已经抽干
                    ans[i] = 1;//随机选择一个抽干
                    continue;
                } else {//贪心
                    int num = 65535;
                    int min = 65535;
                    for (int j = 0; j < river.size(); j++) {
                        ArrayList<Integer> cur = set.get(river.get(j));
                        if (cur.size() == 0) {
                            continue;
                        } else {
                            if (cur.get(0) < min) {//如果当前点的下一次出现日期小于最小值
                                min = cur.get(0);
                                num = river.get(j);
                            }
                        }
                    }
                    if (min != 65535) {//如果后面出现该些湖泊
                        ans[i] = num;
                        river.remove((Integer) num);//将该值移除
                    } else {//如果后面未出现该湖泊
                        ans[i] = river.get(0);
                        river.remove(0);
                    }
                }
            }
        }
        return ans;
    }
class Rain{
        int index;
        int day;
    }
    public int[] avoidFlood3(int[] rains) {
        int len = rains.length;
        int[] ans = new int[len];
        int[]next=new int[len];//存放下一次该湖泊下雨的时间，0代表没有或者其不下雨
        HashMap<Integer,Integer> temp=new HashMap<>();//key存放当前下雨的湖泊，value存放下雨的天数
        for (int i = len-1; i >=0 ; i--) {
                    next[i]=temp.getOrDefault(rains[i],len);//得到其下一次下雨的天数
                    temp.put(rains[i],i);//更新该湖泊下次下雨的时间
            }
        PriorityQueue<Rain> queue=new PriorityQueue<>((n1,n2)->n1.day-n2.day);//按照其下次出现的先后顺序来排
        for (int i = 0; i < len; i++) {
            if (rains[i] > 0) {
                    ans[i] = -1;
                    Rain rain = new Rain();
                    rain.index = rains[i];
                    rain.day = next[i];
                    queue.add(rain);
                }
            else {//选择一个湖泊抽干
                if (queue.size() == 0) {//湖水都已经抽干
                    ans[i] = 1;
                } else {
                ans[i]=queue.poll().index;//删除最先要删除的一个元素
                }
            }
            if(!queue.isEmpty()&&queue.peek().day<=i){//如果队列顶部应该出来的元素天数小于当前天数，说明会泛滥
                return new int[0];
            }
        }
        return ans;
    }
}



