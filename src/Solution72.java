import java.util.Arrays;

public class Solution72
{
    public int minDistance(String word1, String word2) {
                String min=word1.length()>word2.length()?word2:word1;
                String max=word1.length()>word2.length()?word1:word2;
                char[]m=min.toCharArray();
                   int count=0;
                   boolean flag=true;
                   if(min.length()==max.length()){
                       flag=false;
                   }
                   for(int i=0;i<m.length;i++){
                       int count2=i;
                       int count3=0;
                       for(int j=0;j<max.length();j++){
                           if(max.charAt(j)==m[count2]){
                               count3++;
                               count2++;
                               if(count2==m.length){
                                   break;
                               }
                           }
                       }
                     count=Math.max(count,count3);
                }
                   int c=count;
                   int t=0;
                   if(flag==false){
                       for(int i=0;i<m.length;i++){
                           if(m[i]==max.charAt(i)){
                              c--;
                           }
                       }
                       if(c!=0){
                           return max.length()-count+1;
                       }
                   }
                   return max.length()-count;
    }
}
