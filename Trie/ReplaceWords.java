package com.prakash.leetcode.NewStart.Trie;

import java.sql.SQLOutput;
import java.util.*;

public class ReplaceWords {


    public static void main(String[] args) {
        List<String> dict = Arrays.asList("gymth","qglnp","hmgs","rsz","upq","aq","relo","hz","i","atwlc","d","cxax","ymy","hfvr","x","qzgxa","abdgp","dwksr","p","yf","qao","von","bpji","mzxky","tuabq","yquz","j","dzpju","hadfd","svux","rmyku","ae","cr","bowu","slak","s","qvlg","geuw","qx","t","vzix","ycl","xoeyd","cq","jhjm","lt","uye","hwe","rtidu","ksy","dnl","knlsv","yv","ndga","ounoa","kah","dlruh","wbg","vfzt","unnh","kpd","uutv","vxz","lwmh","skyw","f","tktpf","botu","rrs","zdlr","papga","xeyn","z","tqjh","ivzh","b","k","woyl","ixas","tiyd","g","lcq","ta","xd","ztg","oxk","ax","hgqm","dx","zri","heeq","m","q","ub","xxo");
        String sentence = "snhaafs hprzyepsgezd ntc ktogne kluwleaobb nwjatqwpx tzobvpylft s jzrlxuzsw fkkjvorqnhpeoikjepmm rxerxpfjssfvtzvunri rpnaizunsjlppuzppf udoqhtcpcv rtegaohvotz eovfuvymmzywjoytegf cztodouflfgc qtom vlyyboks izzhgin rtnrxmm ovtgafmvzu xxeabovlxmy zrqzsexkerfjiqkyjou ygelavmpdncapreadba y kedhgamqyjaffbex fosrpjojgwzjfaoxn pjqysu esaaoksfsvjabdbk e sknkvxxngqpfdkm dmqfzqjuunrbdmkjp fesdkqewhigg anlrixkeqaexh yhmywgpebtsprje tmwbuqnffycjm otfnqgtetdi ovyrmzo vkeze opq rijfryopiizsitum jyz ynoworq xmqohxpgce eblgjvghxxndaqvknph ghhxzfda onukxgjtdrjmoddqhfl xwmutmcvrzkjzxmtz xslacnagnrlu nidcqwrffyrlosnjjl stwperkfcvyzezbebktq fjhb hhxeturoihcdgkkq evzcmxhrnwvnpbbfsm cshlxs qouyuxwdjwyhfp ceiddqqfp pzbsuxqc qgrbisfcnyhdwmbkdjh cxlxqwi z ihgekczvavdwvivvj fjttwiqxqjgakd diggghnustrtizokcrw earkadvle eufogeidbfrcz cnms gomw rbraz bsbopklfbnbbzcod zbayalermeyxn ckrfpylus ofmpofltxmsideqxx rmkqaxda map gvpqwuofuwue o mkzz njrqnwlihegmpmr dbbpwy t c apljlybekb avgxnubzswldzyln tkxwrskwqkzdueuautg cekskcpocbubavun jezsixdu yepzrfdrhqajotjohmzo fleesmkehkvoj ciloebxldjgwtf ruzc tshzh cgudcyfzppgduvfha grcrveutgkz cfsrzt";

        System.out.println("replacedString ---> " + new ReplaceWordsSolution().replaceWords(dict, sentence));
    }

}

class ReplaceWordsSolution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Map<Character, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(String str : dictionary){
            List<String> list = map.getOrDefault(str.charAt(0), new ArrayList());
            list.add(str);
            map.put(str.charAt(0), list);
        }
        for(Map.Entry<Character, List<String>> entry : map.entrySet()){
            System.out.println("entry.getKey() ---> " + entry.getKey());
            System.out.println("entry.getValue() ---> " + entry.getValue());
        }

        for(String s : sentence.split(" ")){
            boolean isWordReplaced = false;
            if(map.containsKey(s.charAt(0))){
                List<String> sortList = map.get(s.charAt(0));
                Collections.sort(sortList);
                for(String mapString : sortList) {
                    if (s.startsWith(mapString)) {
                        sb.append(mapString);
                        sb.append(" ");
                        isWordReplaced = true;
                        break;
                    }
                }
            }
            if(!isWordReplaced){
                sb.append(s);
                sb.append(" ");
            }
        }
        return sb.toString().substring(0, sb.length()-1);
    }
}
