package Array;

/**
 * @authtor liFei
 * @date 2020/5/5-7:50
 */
public class Solution1610ms {
    /*

给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]，实现一个方法以计算生存人数最多的年份。
你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。如果一个人在某一年的任意时期都处于生存状态，
那么他们应该被纳入那一年的统计中。例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。
如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
     */
    public int maxAliveYear(int[] birth, int[] death) {
              int change[]=new int[102];
              int len=birth.length;
        for (int i = 0; i <len ; i++) {
            change[birth[i]-1900]++;
            change[death[i]+1-1900]--;
        }
        int sum=0;
        int max=-1;
        int count=0;
        for (int i=0;i<102;i++){
            sum+=change[i];
            if(sum>max){
                count=i;
                max=sum;
            }
        }
        return count+1900;
    }
}
