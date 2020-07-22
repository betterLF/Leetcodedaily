package String;

/**
 * @authtor liFei
 * @date 2020/7/19-6:35
 */
public class Solution443 {
    /*
    给定一组字符，使用原地算法将其压缩。
压缩后的长度必须始终小于或等于原数组长度。
数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
在完成原地修改输入数组后，返回数组的新长度
     */
    public int compress(char[] chars) {
          int nowIndex=1;
          int curCount=1;
          char pre=chars[0];
        for (int i = 1; i <chars.length ; i++) {
              if(chars[i]!=pre){
                  if(curCount!=1) {
                      String cur = Integer.toString(curCount);
                      for (int j = 0; j < cur.length(); j++) {
                          chars[nowIndex + j] = cur.charAt(j);
                      }
                      nowIndex += cur.length();
                  }
                  chars[nowIndex]=chars[i];
                  curCount=1;
                  pre=chars[i];
                  nowIndex++;
              }else {
                  curCount++;
              }
        }
        if(curCount!=1) {
            String cur = Integer.toString(curCount);
            for (int j = 0; j < cur.length(); j++) {
                chars[nowIndex + j] = cur.charAt(j);
            }
            nowIndex += cur.length();
            return nowIndex;
        }
        return nowIndex;
    }
}
