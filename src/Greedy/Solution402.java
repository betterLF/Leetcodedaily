package Greedy;

/**
 * @authtor liFei
 * @date 2020/7/21-20:00
 */
public class Solution402 {
    /*
给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
注意:
num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。
     */
//    public int index;
//    public String removeKdigits(String num, int k) {
//        index = 0;
//        if(num.length()==k){
//            return "0";
//        }
//        ArrayList<Character> c = new ArrayList<>();
//        int len = num.length();
//        for (int i = 0; i < len - k; i++) {
//            c.add(num.charAt(i));
//        }
//        for (int i = len - k; i < len; i++) {
//            greedy(c, num.charAt(i));
//        }
//        StringBuilder ans = new StringBuilder();
//        boolean flag=false;
//        for (Character cur : c) {
//            if (cur != '0'||flag) {
//                ans.append(cur);
//                flag=true;
//            }
//        }
//        if(ans.length()==0){
//            return "0";
//        }
//        return ans.toString();
//    }
//    private void greedy(ArrayList<Character> arr,Character curNum){
//        for (int i = index; i <arr.size()-1 ; i++) {
//            if(arr.get(i)>arr.get(i+1)){
//                  arr.remove(i);
//                  arr.add(curNum);
//                  index=i==0?0:i-1;
//                  return;
//            }
//        }
//      if(arr.get(arr.size()-1)>curNum) {
//      arr.remove(arr.size()-1);
//      arr.add(curNum);
//      }
//
//        }
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        int len=num.length();
       char []c=new char[len];
       int r=0;
       for (char cur: num.toCharArray()){
           while (r>0&&k>0&&c[r-1]>cur){//删掉前面一个数
               k--;
               r--;
           }
           c[r]=cur;
           r++;
       }
       while (k>0&&r>0){
           k--;
           r--;
       }
        // 移除头部零
        int l = 0; // 此时才需要 left 指针
        while (l < r && c[l] == '0') l++;
        if (l == r) return "0";
        return new String(c, l, r - l);
    }
}
