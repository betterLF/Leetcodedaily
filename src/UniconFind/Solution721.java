package UniconFind;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/9/21-17:22
 */
public class Solution721 {
    /*
给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，
即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
     */
    int []father;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        father=new int[accounts.size()];
        TreeMap<String,Integer> map=new TreeMap<>();
        for (int i = 0; i <father.length ; i++) {
            father[i]=i;
        }
        int id=0;
        for (List<String> account:accounts){
            String n="";
            for (String email:account){
                if(n.equals("")){
                    n=email;
                    continue;
                }
                if(map.containsKey(email)){
                    union(map.get(email),id);
                }else {
                    map.put(email,id);
                }
            }
            id++;
        }
        List<List<String>> ans=new ArrayList<>();
        HashMap<Integer,List<String>> n=new HashMap<>();
        for(String key:map.keySet()){
            int idd=map.get(key);
            int ff=find(idd);
            if(n.containsKey(ff)){
                n.get(ff).add(key);
            }else {
                List<String> cur=new ArrayList<>();
                cur.add(key);
                n.put(ff,cur);
            }
        }
        for (Integer key:n.keySet()){
            List<String> cur=new ArrayList<>();
            cur.add(accounts.get(key).get(0));
            for (String e:n.get(key)){
                cur.add(e);
            }
            ans.add(cur);
        }
        return ans;
    }
    public int find(int x){
        if(x!=father[x]){
            x=find(father[x]);
        }
        return x;
    }
    public void union(int x,int y){
        int new_x=find(x);
        int new_y=find(y);
        father[new_x]=new_y;
    }
}
