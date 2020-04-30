package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/28-8:02
 */
public class Solution811 {
    /*
    一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，
    最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，
    也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
     */
    public static void main(String[] args) {
//        String[]c={"9001 discuss.leetcode.com"};
//         subdomainVisits(c);
        String t[]={"408 zfz.network","1789 zqy.ca","622 cwn.net","6629 vdu.bfo.team","817 htq.co","3496 ytn.com","6122 nqk.srp.org","4296 jre.us","8176 gqs.ca","7292 zbl.ksc.net","4126 lir.ajl.team","84 lmm.network","622 wmt.cwn.net","2572 qay.network","7089 ske.yls.com","2979 bhp.org","2740 xhe.org","4439 gtu.us","1110 kdd.znq.us","3314 hkt.net","5041 cdf.hwu.us","4198 okv.co","6920 tlc.dfa.us","654 yjt.co","5016 zwv.gqi.co","59671 team","5705 mqa.wsv.net","9103 vbo.org","2406 hkb.ocf.co","7292 ksc.net","8928 arz.org","8342 srp.team","2447 ksc.com","32 ulz.com","3855 yjt.network","9530 omu.network","2329 vva.qay.network","2531 ser.com","1781 lbk.ksc.co","7476 cze.yvr.net","1873 gjf.ca","3950 xuf.network","1789 xcf.zqy.ca","3055 jkx.com","81314 network","1137 qzi.co","3262 mor.ixi.us","7344 czb.com","3090 yjt.us","6890 bfo.network","3875 ato.network","68516 net","9374 jep.ato.co","9523 cgl.network","7464 jpd.fff.co","2715 okv.us","3528 arz.us","9374 ato.co","7042 btv.com","64390 org","2862 sci.net","9259 bfo.net","9172 zfz.net","3055 fdy.jkx.com","2160 hsj.epf.org","5907 zfz.us","7392 uyy.net","9897 lra.uyy.org","58413 com","2406 ocf.co","6129 hkt.com","3377 jkx.network","12367 bfo.team","59758 co","36170 ca","2160 epf.org","4602 weq.buf.team","6920 dfa.us","1879 lmm.ca","3314 ytd.hkt.net","2862 coh.sci.net","2913 ret.ych.ca","817 sgp.htq.co","9531 hoh.co","3609 bhp.team","8274 ulz.co","9846 fuw.org","1501 ara.ca","2913 ych.ca","5738 lar.bfo.team","8557 lfn.net","3449 tfm.us","654 yls.yjt.co","1781 ksc.co","3215 hoh.network","2777 mkw.co","9897 uyy.org","767 irh.epf.us","2444 gxz.team","4806 xss.dfa.co","9372 hci.jia.network","9581 gqi.team","5016 gqi.co","4975 okv.com","4296 xtb.jre.us","5705 wsv.net","9372 jia.network","8544 bhp.com","1873 kse.gjf.ca","7464 fff.co","3624 epf.network","9219 tfm.ca","1387 hju.gbq.org","4806 dfa.co","3262 ixi.us","7193 fzx.ca","2965 gxj.org","8557 uai.lfn.net","51516 us","8176 ujm.gqs.ca","4602 buf.team","4126 ajl.team","1110 znq.us","2444 vks.gxz.team","6865 thk.net","1523 suq.bhp.co","3111 gdw.team","4521 weh.bfo.us","7476 yvr.net","8167 jre.team","5041 hwu.us","4521 bfo.us","3322 xhe.team","2777 nak.mkw.co","8263 cwn.org","4681 lwf.ytn.network","654 yaw.lmm.ca","8167 ahm.jre.team","3215 bll.hoh.network","4681 ytn.network","767 epf.us","6122 srp.org","3528 jyx.arz.us","408 tdt.zfz.network","8390 zqk.network","9523 wyv.cgl.network","3624 vmv.epf.network","3090 ycc.yjt.us","8544 xrj.bhp.com","1523 bhp.co","4198 xfs.okv.co","7968 gjf.network","3875 brk.ato.network","1387 gbq.org","2471 czb.us","1627 bhp.ca","1137 ujs.qzi.co","5729 srp.com","7089 yls.com","7193 xth.fzx.ca","2715 ubt.okv.us","2531 mce.ser.com"};

        String s[]={"1137 qzi.co","654 yls.yjt.co","9581 gqi.team","3262 ixi.us","1137 ujs.qzi.co","8390 zqk.network","2447 ksc.com","2862 coh.sci.net","5705 wsv.net","9374 jep.ato.co","622 cwn.net","3855 yjt.network","3322 xhe.team","817 htq.co","1110 znq.us","3262 mor.ixi.us","7089 ske.yls.com","5705 mqa.wsv.net","1781 ksc.co","2444 vks.gxz.team","4681 lwf.ytn.network","3950 xuf.network","7968 gjf.network","7292 ksc.net","3875 ato.network","4126 lir.ajl.team","3496 ytn.com","9219 tfm.ca","5729 srp.com","654 yjt.co","4198 xfs.okv.co","9103 vbo.org","1789 zqy.ca","6920 tlc.dfa.us","1873 kse.gjf.ca","6890 bfo.network","2160 hsj.epf.org","2160 epf.org","408 zfz.network","2979 bhp.org","4296 xtb.jre.us","5738 lar.bfo.team","4198 okv.co","1501 ara.ca","3528 arz.us","7464 jpd.fff.co","8928 arz.org","8263 cwn.org","3215 bll.hoh.network","6122 srp.org","4975 okv.com","8167 jre.team","9372 jia.network","3624 vmv.epf.network","3377 jkx.network","4296 jre.us","1781 lbk.ksc.co","5041 cdf.hwu.us","2965 gxj.org","7042 btv.com","36170 ca","1523 suq.bhp.co","6865 thk.net","2777 nak.mkw.co","3215 hoh.network","8557 uai.lfn.net","59671 team","59758 co","6629 vdu.bfo.team","3090 yjt.us","7344 czb.com","4806 xss.dfa.co","7464 fff.co","2862 sci.net","6129 hkt.com","2471 czb.us","7476 cze.yvr.net","2715 okv.us","6122 nqk.srp.org","84 lmm.network","9846 fuw.org","3528 jyx.arz.us","3609 bhp.team","5041 hwu.us","9897 lra.uyy.org","4439 gtu.us","58413 com","32 ulz.com","1789 xcf.zqy.ca","1387 hju.gbq.org","9372 hci.jia.network","8176 ujm.gqs.ca","1873 gjf.ca","3314 ytd.hkt.net","8176 gqs.ca","7193 fzx.ca","5016 zwv.gqi.co","2715 ubt.okv.us","3314 hkt.net","9530 omu.network","68516 net","4602 weq.buf.team","51516 us","1110 kdd.znq.us","6920 dfa.us","2913 ret.ych.ca","8544 bhp.com","8274 ulz.co","408 tdt.zfz.network","3624 epf.network","7476 yvr.net","8342 srp.team","8557 lfn.net","8544 xrj.bhp.com","2913 ych.ca","9897 uyy.org","4126 ajl.team","9259 bfo.net","2329 vva.qay.network","5907 zfz.us","4602 buf.team","2406 ocf.co","3111 gdw.team","1387 gbq.org","4521 bfo.us","1627 bhp.ca","2531 mce.ser.com","3055 fdy.jkx.com","81314 network","817 sgp.htq.co","5016 gqi.co","2531 ser.com","4521 weh.bfo.us","622 wmt.cwn.net","12367 bfo.team","1523 bhp.co","2406 hkb.ocf.co","7089 yls.com","2572 qay.network","2740 xhe.org","767 epf.us","767 irh.epf.us","64390 org","9374 ato.co","9172 zfz.net","3875 brk.ato.network","4681 ytn.network","7193 xth.fzx.ca","2444 gxz.team","3449 tfm.us","7292 zbl.ksc.net","8167 ahm.jre.team","654 yaw.lmm.ca","4806 dfa.co","3055 jkx.com","7392 uyy.net","9523 wyv.cgl.network","2777 mkw.co","9523 cgl.network","3090 ycc.yjt.us","1225 lmm.ca","9531 hoh.co"};
        HashSet<String> a=new HashSet<>();
        for (int i = 0; i <t.length ; i++) {
            a.add(t[i]);
        }
        for (int i = 0; i <s.length ; i++) {
            if(!a.contains(s[i])){
                System.out.println(s[i]);
            }
        }
    }
    public static List<String> subdomainVisits(String[] cpdomains) {
          List<String> ans=new ArrayList<>();
        HashMap<String,Integer> cur=new HashMap<>();
        for (int i=0;i<cpdomains.length;i++){
            String curr[]=cpdomains[i].split(" ");
            Integer ss=Integer.parseInt(curr[0]);
            cur.put(curr[1],cur.getOrDefault(curr[1],0)+ss);
            String curr2[]=curr[1].split("\\.");
           if(curr2.length==3){
               String temp=curr2[1]+"."+curr2[2];
               String temp2=curr2[2];
               cur.put(temp,cur.getOrDefault(temp,0)+ss);
               cur.put(temp2,cur.getOrDefault(temp2,0)+ss);
           }else if(curr2.length==2){
               String temp2=curr2[1];
               cur.put(temp2,cur.getOrDefault(temp2,0)+ss);
           }
        }
        for (String key:cur.keySet()){
            String t=""+cur.get(key)+" "+key;
            ans.add(t);
        }
        return ans;
    }
}
