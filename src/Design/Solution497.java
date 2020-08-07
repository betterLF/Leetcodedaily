package Design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * @authtor liFei
 * @date 2020/8/4-6:38
 */
public class Solution497 {
    /*
    给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。
提示：
整数点是具有整数坐标的点。
矩形周边上的点包含在矩形覆盖的空间中。
第 i 个矩形 rects [i] = [x1，y1，x2，y2]，其中 [x1，y1] 是左下角的整数坐标，[x2，y2] 是右上角的整数坐标。
每个矩形的长度和宽度不超过 2000。
1 <= rects.length <= 100
pick 以整数坐标数组 [p_x, p_y] 的形式返回一个点。
pick 最多被调用10000次。
     */
    /*
    [[[[82918473, -57180867, 82918476, -57180863], [83793579, 18088559, 83793580, 18088560],
    [66574245, 26243152, 66574246, 26243153], [72983930, 11921716, 72983934, 11921720]]]
     */
    class Solution {
           public List<int[]> arr;
           Random r=new Random();
           TreeMap<Integer,Integer> map;
           int sum=0;
        public Solution(int[][] rects) {
              arr=new ArrayList<>();
              map=new TreeMap<>();
              int count=0;
                for (int []cur:rects){
                    arr.add(cur);
                    sum+=(cur[2]-cur[0]+1)*(cur[3]-cur[1]+1);
                    map.put(sum,count);
                    count++;
                }
        }

        public int[] pick() {
            int c=map.ceilingKey(r.nextInt(sum)+1);
               int []cur=arr.get(map.get(c));
               long cur_x=r.nextInt(cur[2]-cur[0]+1)+cur[0];
               long cur_y=r.nextInt(cur[3]-cur[1]+1)+cur[1];
               return new int[]{(int)cur_x,(int)cur_y};
        }
    }
}
