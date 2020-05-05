package Competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/3-10:28
 */
public class zhousai187 {
    /*
    给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi]
    表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
     */
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> ans = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            String s1 = paths.get(i).get(0);
            String s2 = paths.get(i).get(1);
            ans.put(s1, ans.getOrDefault(s1, 0) + 1);
            ans.put(s2, ans.getOrDefault(s2, 0) + 1);
        }
        String a[] = new String[2];
        int count = 0;
        for (String key : ans.keySet()) {
            if (ans.get(key) == 1) {
                a[count] = key;
                count++;
            }
        }
        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).get(1) == a[0]) {
                return a[0];
            }
        }
        return a[1];
    }

    /*
    给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
     */
    public boolean kLengthApart(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ans.add(i);
            }
        }
        if (ans.size() < 2) {
            return true;
        }
        int min = ans.get(1) - ans.get(0) - 1;
        for (int i = 2; i < ans.size(); i++) {
            min = Math.min(min, ans.get(i) - ans.get(i - 1) - 1);
        }
        if (min >= k) {
            return true;
        }
        return false;
    }

    /*
    给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，
    该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
如果不存在满足条件的子数组，则返回 0 。
     */


    public static int longestSubarray(int[] nums, int limit) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            int right = nums[i];
            int j = i + 1;
            boolean flag = true;
            for (; j < nums.length; j++) {
                left = Math.min(left, nums[j]);
                right = Math.max(right, nums[j]);
                if (right - left > limit) {
                    max = Math.max(max, j - i);
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                max = Math.max(max, nums.length - i);
            }
            if (max >= nums.length - i - 1) {
                return max;
            }
        }
        return max;
    }

    /*
    给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
     */   public static int count;
        public static int kthSmallest(int[][] mat, int k) {
            int max = 0;
            int min = 0;
            int n = mat[0].length;
            for (int i = 0; i < mat.length; i++) {
                max += mat[i][n - 1];
                min += mat[i][0];
            }
            int cur=min;
            while (min < max) {
                int mid = (max + min) / 2;
                count = 1;
                dfs(mat, cur, mid, 0,k);
                if (count >= k) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }
        private static void dfs(int mat[][], int sum, int mid, int index,int k) {
            if (index == mat.length||sum>mid||count>k) {
                return;
            }
              dfs(mat, sum , mid, index + 1,k);//当前层不变
                for (int i = 1; i < mat[0].length; i++) {//当前层变化
                    if (sum + mat[index][i]-mat[index][0] <= mid) {
                        count++;
                        dfs(mat, sum + mat[index][i]-mat[index][0], mid, index + 1,k);
                    } else {
                        break;
                    }
                }
            }
    }


