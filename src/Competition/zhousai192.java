package Competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/7-9:49
 */
public class zhousai192 {
    /*
给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     */
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            ans[count++] = nums[i];
            ans[count++] = nums[n + i];
        }
        return ans;
    }

    /*
给你一个整数数组 arr 和一个整数 k 。
设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：
 |arr[i] - m| > |arr[j] - m|
 |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
请返回由数组中最强的 k 个值组成的列表。答案可以以 任意顺序 返回。
中位数 是一个有序整数列表中处于中间位置的值。形式上，如果列表的长度为 n ，那么中位数就是该有序列表（下标从 0 开始）中位于 ((n - 1) / 2) 的元素。
例如 arr = [6, -3, 7, 2, 11]，n = 5：数组排序后得到 arr = [-3, 2, 6, 7, 11] ，数组的中间位置为 m = ((5 - 1) / 2) = 2 ，中位数 arr[m] 的值为 6 。
例如 arr = [-7, 22, 17, 3]，n = 4：数组排序后得到 arr = [-7, 3, 17, 22] ，数组的中间位置为 m = ((4 - 1) / 2) = 1 ，中位数 arr[m] 的值
     */
    public int[] getStrongest(int[] arr, int k) {
        int mid = 0;
        Arrays.sort(arr);
        mid = arr[(arr.length - 1) / 2];
        int i = 0;
        int j =arr.length-1;
        int m=(arr.length - 1) / 2;
        int[] ans = new int[k];
        int count = 0;
        if(k==arr.length){
            return arr;
        }
        while (count != k) {
            if (i <m && j>m) {
                int temp1 = Math.abs(arr[i] - mid);
                int temp2 = Math.abs(arr[j] - mid);
                if (temp1 > temp2) {
                    ans[count] = arr[i];
                    i++;
                } else if (temp1 < temp2) {
                    ans[count] = arr[j];
                    j--;
                } else {
                        ans[count] = arr[j];
                        j--;
                }
            } else if (i >=m) {
                ans[count] = arr[j];
                j--;
            } else {
                ans[count] = arr[i];
                i++;
            }
            count++;
        }
        return ans;
    }
/*
你有一个只支持单个标签页的 浏览器 ，最开始你浏览的网页是 homepage ，你可以访问其他的网站 url ，也可以在浏览历史中后退 steps 步或前进 steps 步。
请你实现 BrowserHistory 类：
BrowserHistory(string homepage) ，用 homepage 初始化浏览器类。
void visit(string url) 从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的记录全部删除。
string back(int steps) 在浏览历史中后退 steps 步。如果你只能在浏览历史中后退至多 x 步且 steps > x ，那么你只后退 x 步。请返回后退 至多 steps 步以后的 url 。
string forward(int steps) 在浏览历史中前进 steps 步。如果你只能在浏览历史中前进至多 x 步且 steps > x ，那么你只前进 x 步。请返回前进 至多 steps步以后的 url 。
 */
class BrowserHistory {

    List<String> history = new ArrayList<>();
    int cur;
    public BrowserHistory(String homepage) {
        history.add(homepage);
        cur = 0;
    }

    public void visit(String url) {
        //注意
        history = history.subList(0, cur + 1);//删除前进记录
        history.add(url);
        cur = history.size() - 1;
    }

    public String back(int steps) {
        if (cur - steps <= 0) {
            cur = 0;
            return history.get(0);
        } else {
            cur = cur - steps;
            return history.get(cur);
        }
    }
    public String forward(int steps) {
        if (cur + steps >= history.size() - 1) {
            cur = history.size() - 1;
            return history.get(cur);
        } else {
            cur = cur + steps;
            return history.get(cur);
        }
    }

}
}
