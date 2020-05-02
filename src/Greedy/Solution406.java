package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/30-13:44
 */
public class Solution406 {
    /*
    假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
    k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
     */
    public int[][] reconstructQueue(int[][] people) {
        //按高度降序排列。
        //在同一高度的人中，按 k 值的升序排列。
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);//按照位置进行插入
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
