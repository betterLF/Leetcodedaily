import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class zhousai183 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum[] = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        List<Integer> res = new LinkedList<>();
        res.add(nums[len - 1]);
        if (len == 1) {
            return res;
        }
        int count = nums[len - 1];
        int m = len - 2;
        int n = len - 2;
        while (count <= sum[m]) {
            res.add(nums[n]);
            count += nums[n];
            if (m == 0) {
                break;
            }
            n--;
            m--;
        }
        return res;

    }
    public List<Integer> minSubsequence2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        int save = 0;
        List<Integer> ans = new ArrayList();
        for(int i = nums.length - 1; i >= 0 && save * 2 <= sum; i--){//如果save*2>sum,说明sum-save<save
            ans.add(nums[i]);
            save += nums[i];
        }
        return ans;
    }

    /*
给你一个以二进制形式表示的数字 s 。
请你返回按下述规则将其减少到 1 所需要的步骤数：  如果当前数字为偶数，则将其除以 2 。
如果当前数字为奇数，则将其加上 1 。
题目保证你总是可以按上述规则将测试用例变为 1 。
     */
    public  int numSteps(String s) {
        int len = s.length();
        int count = 0;
        String ss = s;
        StringBuilder ssss = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            ssss.append('0');
        }
        ssss.append('1');
        String cc = ssss.toString();
        while (!ss.equals(cc)) {
            if (ss.charAt(ss.length() - 1) != '1') {
                ss = "0" + ss.substring(0, ss.length() - 1);
                count++;
            } else {
                ss = ss.substring(0, ss.length() - 1) + "0";
                int count2 = ss.length() - 2;
                while (ss.charAt(count2) == '1') {
                    ss = ss.substring(0, count2) + "0" + ss.substring(count2 + 1, ss.length());
                    count2--;
                    if (count2 == -1) {
                        break;
                    }
                }
                if (count2 == -1) {
                    ss = "1" + ss.substring(0, ss.length());
                    cc = "0" + cc;
                } else {
                    ss = ss.substring(0, count2) + "1" + ss.substring(count2 + 1, ss.length());
                }
                count++;
            }
            System.out.println(ss);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(100,100,100));//"ccabbaccabba"
    }

        public static String longestDiverseString(int a, int b, int c)
        {
            if((a-3)/2>=(b+c)){
                a=(b+c)*2+2;
            }else if((b-3)/2>=(a+c)){
                b=(a+c)*2+2;
            }else if((c-3)/2>=(a+b)){
                c=(a+b)*2+2;
            }
            char m[]={'a','b','c'};
            int n[]={a,b,c};
            StringBuilder res=new StringBuilder();
            if(a<=1&&b<=1&&c<=1){
                while (a!=0){
                    res.append('a');
                    a--;
                }
                while (c!=0){
                    res.append('c');
                    c--;
                }
                while (b!=0){
                    res.append('b');
                    b--;
                }
                return res.toString();
            }
            int sum=a+b+c;
            while(sum>=0){
                if(n[getMin(n)]!=0){
                    int max=getMax(n),min=getMin(n);
                    if(max==min){
                        for(int i=0;i<3;i++){
                            if(i!=max){
                                min=i;
                                break;
                            }
                        }
                    }
                    res.append(m[max]).append(m[max]).append(m[min]);
                    sum-=3;
                    n[max]-=2;
                    n[min]-=1;
                }else {
                    int max = getMax(n), mid = getMid(n);
                    System.out.println(max+","+mid);
                    if(max==mid){
                        for(int i=0;i<3;i++){
                            if(i!=max&&i!=getMin(n)){
                                mid=i;
                                break;
                            }
                        }
                    }
                    System.out.println(max+","+mid);
                    if (n[max] - n[mid] <= 2) {
                        while (n[mid] >= 1) {
                            res.append(m[max]).append(m[mid]);
                            n[mid]-=1;
                            n[max]-=1;
                        }
                        if(n[mid]==1){
                            res.append(m[mid]);
                        }
                        while(n[max]!=0){
                            res.append(m[max]);
                            n[max]--;
                        }
                        break;
                    }else{
                        res.append(m[max]).append(m[max]).append(m[mid]);
                        n[max]-=2;
                        n[mid]-=1;
                        sum-=3;
                    }
                }
            }
            return  res.toString();
        }
        private static int getMax(int n[]){
        if(n[0]>=n[1]&&n[0]>=n[2]){
            return 0;
        }else if(n[1]>=n[0]&&n[1]>=n[2]){
            return 1;
        }else {
            return 2;
        }
    }
        private static int getMin(int n[]){
        if(n[0]<=n[1]&&n[0]<=n[2]){
            return 0;
        }else if(n[1]<=n[0]&&n[1]<=n[2]){
            return 1;
        }else {
            return 2;
        }
    }
        private static int getMid(int n[]){
        if((n[1]<=n[0]&&n[1]>=n[2])||(n[1]>=n[0]&&n[1]<=n[2])){
            return 1;
        }else if((n[0]<=n[1]&&n[0]>=n[2])||(n[0]>=n[1]&&n[0]<=n[2])){
            return 0;
        }else{
            return 2;
        }
    }
}
