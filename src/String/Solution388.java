package String;

/**
 * @authtor liFei
 * @date 2020/7/15-16:38
 */
public class Solution388 {
    /*
假设我们以下述方式将我们的文件系统抽象成一个字符串:
字符串 "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 表示:
dir
    subdir1
    subdir2
        file.ext
目录 dir 包含一个空的子目录 subdir1 和一个包含一个文件 file.ext 的子目录 subdir2 。
字符串 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 表示:
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
目录 dir 包含两个子目录 subdir1 和 subdir2。 subdir1 包含一个文件 file1.ext 和一个空的二级子目录
subsubdir1。subdir2 包含一个二级子目录 subsubdir2 ，其中包含一个文件 file2.ext。
我们致力于寻找我们文件系统中文件的最长 (按字符的数量统计) 绝对路径。例如，在上述的第二个例子中，
最长路径为 "dir/subdir2/subsubdir2/file2.ext"，其长度为 32 (不包含双引号)。
给定一个以上述格式表示文件系统的字符串，返回文件系统中文件的最长绝对路径的长度。 如果系统中没有文件，返回 0。
     */
    public int lengthLongestPath(String input) {
          int res=0;//代表当前层的长度
          int max=0;//代表当前最大值
          int k=0;//代表当前深度
          int mark=0;//代表当前是否出现点
          int []depth=new int[100];
          depth[0]=-1;
          for (char c:input.toCharArray()){
              if(c=='\n'){
                  depth[k+1]=res+1+depth[k];//1代表与前一层连接的/
                if(mark>0) {
                    max = Math.max(max, depth[k + 1]);
                }
                   k=0;//当前深度重新回到0
                   mark=0;//当前未出现点
                   res=0;//当前层长度重置为0
              }else if(c=='\t'){//深度++;
                  k++;
              }else{
                  if(c=='.'){//标记当前为文件
                      mark=1;
                  }
                  res++;
              }
          }
          if(mark>0){
              max = Math.max(max, res+1+depth[k]);
          }
          return max;
    }
}
