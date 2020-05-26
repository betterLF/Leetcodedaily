package Competition;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/5/24-10:30
 */
public class zhousai190 {
    /*
    给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
如果 searchWord 不是任何单词的前缀，则返回 -1 。
字符串 S 的 「前缀」是 S 的任何前导连续子字符串。
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        String[] c = sentence.split(" ");
        for (int i = 0; i < c.length; i++) {
            if (contain(searchWord, c[i])) {
                ans = i;
                return ans;
            }
        }
        return ans;
    }

    private boolean contain(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /*
    给你字符串 s 和整数 k 。
请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
英文中的 元音字母 为（a, e, i, o, u）。
     */
    public int maxVowels(String s, int k) {
        int[] ans = new int[s.length()];
        char[] c = s.toCharArray();
        if (isRight(c[0])) {
            ans[0] = 1;
        }
        for (int i = 1; i < c.length; i++) {
            if (isRight(c[i])) {
                ans[i] = ans[i - 1] + 1;
            } else {
                ans[i] = ans[i - 1];
            }
        }
        int max = ans[k - 1];
        int count = 0;
        for (int i = k; i < c.length; i++) {
            max = Math.max(max, ans[i] - ans[count]);
            count++;
        }
        return max;
    }

    private boolean isRight(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    /*
    给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，
    当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
    请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
    */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            temp.put(i, 0);
        }
        int[] ans = {0};
        bianli(root, ans, temp);
        return ans[0];
    }

    private void bianli(TreeNode root, int[] ans, HashMap<Integer, Integer> temp) {
        int c = temp.get(root.val);
        temp.put(root.val, c + 1);
        if (root.left == null && root.right == null) {
            if (isRight(temp)) {
                ans[0]++;
            }
            temp.put(root.val, c);
            return;
        }
        if (root.left != null) {
            bianli(root.left, ans, temp);
        }
        if (root.right != null) {
            bianli(root.right, ans, temp);
        }
        temp.put(root.val, c);

    }

    private boolean isRight(HashMap<Integer, Integer> temp) {
        int k = 0;
        for (Integer key : temp.keySet()) {
            if (temp.get(key) % 2 == 1) {
                k++;
            }
            if (k > 1) {
                return false;
            }
        }
        return true;
    }

    /*
    给你两个数组 nums1 和 nums2 。
请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，
但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
     */
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i] * nums2[j]);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }
}
