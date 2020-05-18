package Competition;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/5/17-10:24
 */
public class zhousai189 {
    /*
给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
      int ans=0;
        for (int i = 0; i <startTime.length ; i++) {
            if(startTime[i]<=queryTime&&endTime[i]>=queryTime){
                ans++;
            }
        }
        return ans;
    }

    /*
「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
句子的首字母大写
text 中的每个单词都用单个空格分隔。
请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
请同样按上述格式返回新的句子。
     */
    public String arrangeWords(String text) {
          String []temp=text.split(" ");
        StringBuilder ans1=new StringBuilder();
        char a1[]=temp[0].toCharArray();
        ans1.append((char) (a1[0]+32));
        for (int i=1;i<a1.length;i++){
            ans1.append(a1[i]);
        }
        temp[0]=ans1.toString();
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        StringBuilder ans=new StringBuilder();
        char a[]=temp[0].toCharArray();
        ans.append((char) (a[0]-32));
        for (int i=1;i<a.length;i++){
            ans.append(a[i]);
        }
        ans.append(" ");
        for (int i=1;i<temp.length;i++){
            ans.append(temp[i]).append(" ");
        }
        return ans.deleteCharAt(ans.length()-1).toString();
    }
    /*
给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        for (int i = 0; i <favoriteCompanies.size() ; i++) {
            judge(favoriteCompanies,i,temp);
        }
        for (int i=0;i<temp.size();i++){
            if(temp.get(i)!=-1){
                ans.add(i);
            }
        }
        return ans;
    }
    private void judge(List<List<String>> f,int index,ArrayList<Integer> temp){
        temp.add(index);
        for (int i = 0; i <temp.size()-1 ; i++) {
            if(temp.get(i)!=-1){
                if(f.get(index).size()==f.get(temp.get(i)).size()){
                    continue;
                }
                if(f.get(index).containsAll(f.get(temp.get(i)))){
                    temp.set(i,-1);
                }else if(f.get(temp.get(i)).containsAll(f.get(index))){
                    temp.set(temp.size()-1,-1);
                    break;
                }

            }
        }
    }
/*
墙壁上挂着一个圆形的飞镖靶。现在请你蒙着眼睛向靶上投掷飞镖。
投掷到墙上的飞镖用二维平面上的点坐标数组表示。飞镖靶的半径为 r 。
请返回能够落在 任意 半径为 r 的圆形靶内或靶上的最大飞镖数。
 */
public int numPoints(int[][] points, int r) {
    int minX=65535;
    int minY=65535;
    int maxX=-65535;
    int maxY=-65535;
           for (int i=0;i<points.length;i++){
               maxX=Math.max(maxX,points[i][0]);
               maxY=Math.max(maxY,points[i][1]);
               minX=Math.min(minX,points[i][0]);
               minY=Math.min(minY,points[i][1]);
           }
           int max=0;
           for (int i=minX;i<=maxX;i++){
               for (int j=minY;j<=maxY;j++){
                   max=Math.max(max,getNumber(points,i,j,r));
                   if(max==points.length){
                       return max;
                   }
               }
           }
           return max;
}
private int getNumber(int [][]points,int i,int j,int r){
    int ans=0;
    for (int k = 0; k <points.length ; k++) {
        if(((points[k][0]-i)*(points[k][0]-i)+(points[k][1]-j)*(points[k][1]-j))<=r*r){
            ans++;
        }
    }
    return ans;
}
}
