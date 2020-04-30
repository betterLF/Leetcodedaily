package Greedy;

/*
有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，
其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution1282 {
    public static void main(String[] args) {
        int a[] = {3, 3, 3, 3, 1, 3, 3};
        System.out.println(groupThePeople2(a));

    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new LinkedList<>();
        HashMap<Integer, String> h = new HashMap<Integer, String>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!h.containsKey(groupSizes[i])) {
                if (groupSizes[i] == 1) {
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(i);
                    list.add(result);
                } else {
                    h.put(groupSizes[i], String.valueOf(i) + ",");
                }
            } else {
                h.put(groupSizes[i], h.get(groupSizes[i]) + String.valueOf(i) + ",");
                String s[] = h.get(groupSizes[i]).split(",");
                if (s.length == groupSizes[i]) {
                    List<Integer> result = new ArrayList<Integer>();
                    for (int k = 0; k < groupSizes[i]; k++) {
                        result.add(Integer.parseInt(s[k]));
                    }
                    list.add(result);
                    h.remove(groupSizes[i]);
                }
            }

        }
        return list;
    }

    public static List<List<Integer>> groupThePeople2(int[] groupSizes) {
        List<List<Integer>> list = new LinkedList<>();
        HashMap<Integer, List<Integer>> h = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!h.containsKey(groupSizes[i])) {
              h.put(groupSizes[i],new ArrayList<Integer>());
            }
                h.get(groupSizes[i]).add(i);
                List<Integer> s= h.get(groupSizes[i]);
               // h.put(groupSizes[i], s);
                if (s.size()== groupSizes[i]) {
                    list.add(new ArrayList<Integer>(s));
                    //h.remove(groupSizes[i]);
                   s.clear();//防止下次再新建一个键值对
                }
            }
        return list;

    }
    //时间复杂度最低？
    public static List<List<Integer>> groupThePeople3(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            // 如果当前值为0，则继续遍历
            if (groupSizes[i] == 0) {
                continue;
            }
            // 先将当前的序号加入列表
            List<Integer> countList = new ArrayList<>();
            countList.add(i);
            // 如果当前分组为一，则直接将该列表加入结果集
            if (groupSizes[i] == 1) {
                res.add(countList);
                continue;
            }

            // 从i+1 开始遍历，取集合数相等的序号
            for (int j = i + 1; j < groupSizes.length; j++) {

                // 如果所在组元素相等，且当前列表数量还尚未达到目标成员数，则将序号加入列表
                if (groupSizes[i] == groupSizes[j] && countList.size() < groupSizes[i]) {
                    countList.add(j);
                    groupSizes[j] = 0;
                }
                // 如果当前列表数量已经达到目标成员数，则将列表加入结果集
                if (countList.size() == groupSizes[i]) {
                    res.add(countList);
                    break;
                }
            }
        }

        return res;
    }
}
