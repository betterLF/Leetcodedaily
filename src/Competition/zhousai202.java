package Competition;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/8/16-7:44
 */
public class zhousai202 {
    /*
给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
     */
    public boolean threeConsecutiveOdds(int[] arr) {
              int count=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]%2==1){
                count++;
            }else{
                count=0;
            }
            if(count==3){
                return true;
            }
        }
        return false;
    }
    /*
存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x] 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。最终的目标是使数组中的所有元素都 相等 。
题目测试用例将会 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数 。
     */
    public int minOperations(int n) {
       int target=n;
       int count=(n+1)/2;
       return -count*count+count*n;

    }
    /*
在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
     */
    int[] pos;
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        pos = position;
        int n = pos.length;
        if(m == 2) return pos[n - 1] - pos[0];
        int mid = 0, lo = 0, hi = pos[n - 1];
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int res = f(mid);
            if(res >= m)//说明差值大于mid的连续子序列超过m，则差值mid应该变大
                lo = mid + 1;
            else//差值m应该减小
                hi = mid - 1;
        }
        return hi;
    }
    int f(int gap){//找到差值大于等于gap的连续子序列长度
        int res = 1, last = pos[0];
        for(int i : pos)
        {
            if(i - last >= gap)
            {
                res++;
                last = i;
            }
        }
        return res;
    }

//    public int minDays(int n) {
//        HashSet <Integer> seen = new HashSet();
//        ArrayList<Integer> list = new ArrayList();
//        list.add(n);
//        int res = 1;
//        while(true){
//            ArrayList <Integer> next = new ArrayList();
//            for(int i = list.size() - 1; i >= 0; i--)
//            {
//                int cur = list.get(i);
//                if(seen.contains(cur)) continue;
//                if(cur == 1)
//                    return res;
//                seen.add(cur);
//                if(cur % 2 == 0)
//                    next.add(cur / 2);
//                if(cur % 3 == 0)
//                    next.add(cur / 3);
//                next.add(cur - 1);
//            }
//            list = next;
//            res++;
//        }
//    }
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public int minDays(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 1) {
            return 1;
        } else if (n <= 3) {
            return 2;
        } else if (!map.containsKey(n)) {
            int res = Integer.MAX_VALUE;
            res = Math.min(res, helper((n - n % 2) / 2) + 1 + n % 2);
            res = Math.min(res, helper((n - n % 3) / 3) + 1 + n % 3);
            map.put(n, res);
        }
        return map.get(n);
    }

}
