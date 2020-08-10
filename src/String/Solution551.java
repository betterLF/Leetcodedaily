package String;

/**
 * @authtor liFei
 * @date 2020/8/8-7:29
 */
public class Solution551 {
    /*
    给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
'A' : Absent，缺勤
'L' : Late，迟到
'P' : Present，到场
如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
你需要根据这个学生的出勤记录判断他是否会被奖赏。
     */
    public boolean checkRecord(String s) {
         int count_A=0;
         int count_L=0;
         for(char cur:s.toCharArray()){
             if(cur=='A'){
                 count_A++;
                 count_L=0;
                 if(count_A>=2){
                     return false;
                 }
             }else if(cur=='L'){
                 count_L++;
                 if(count_L>=3){
                     return false;
                 }
             }else{
                 count_L=0;
             }

         }
         return true;
    }
}
