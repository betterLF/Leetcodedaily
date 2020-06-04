package String;

/**
 * @authtor liFei
 * @date 2020/6/2-7:24
 */
public class Solution171 {
    /*
    给定一个Excel表格中的列名称，返回其相应的列序号。
     */
    public int titleToNumber(String s) {
             char []c=s.toCharArray();
             int sum=0;
             for(char cur:c){
                 sum=sum*26+(cur-'A'+1);
             }
             return sum;
    }
}
