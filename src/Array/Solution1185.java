package Array;

/**
 * @authtor liFei
 * @date 2020/5/11-8:08
 */
public class Solution1185 {
    /*
    给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
输入为三个整数：day、month 和 year，分别表示日、月、年。
您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
     */
    public String dayOfTheWeek(int day, int month, int year) {
      int m[]={31,28,31,30,31,30,31,31,30,31,30,31};
      String ans[]={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
      //1971年1月1号周五
        int count=(year-1971)*365;//不考虑闰年的年差距时间
        if(year%4!=0){//如果不是闰年
            if(year>1971) {//把闰年算上去
                count += (year - 1972) / 4 + 1;
            }
            for (int i=1;i<month;i++){//算月份
                count+=m[i-1];
            }
            count+=day;//算天数
        }else if(year>1971&&year%4==0){
            count+=(year-1972)/4;
            for (int i=1;i<month;i++){
                count+=m[i-1];
            }
            if(month>2){//如果过了二月，就加一
                count+=1;
            }
            count+=day;
        }
        int temp=(count-1)%7;
        return ans[(5+temp)%7];
    }
}
