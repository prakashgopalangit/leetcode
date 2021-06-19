package com.prakash.leetcode.NewStart.Trie;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReplaceWordsWithTrie {

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("gymth","qglnp","hmgs","rsz","upq","aq","relo","hz","i","atwlc","d","cxax","ymy","hfvr","x","qzgxa","abdgp","dwksr","p","yf","qao","von","bpji","mzxky","tuabq","yquz","j","dzpju","hadfd","svux","rmyku","ae","cr","bowu","slak","s","qvlg","geuw","qx","t","vzix","ycl","xoeyd","cq","jhjm","lt","uye","hwe","rtidu","ksy","dnl","knlsv","yv","ndga","ounoa","kah","dlruh","wbg","vfzt","unnh","kpd","uutv","vxz","lwmh","skyw","f","tktpf","botu","rrs","zdlr","papga","xeyn","z","tqjh","ivzh","b","k","woyl","ixas","tiyd","g","lcq","ta","xd","ztg","oxk","ax","hgqm","dx","zri","heeq","m","q","ub","xxo");
        //List<String> dict = Arrays.asList("cat","bat","rat");
        String sentence = "snhaafs hprzyepsgezd ntc ktogne kluwleaobb nwjatqwpx tzobvpylft s jzrlxuzsw fkkjvorqnhpeoikjepmm rxerxpfjssfvtzvunri rpnaizunsjlppuzppf udoqhtcpcv rtegaohvotz eovfuvymmzywjoytegf cztodouflfgc qtom vlyyboks izzhgin rtnrxmm ovtgafmvzu xxeabovlxmy zrqzsexkerfjiqkyjou ygelavmpdncapreadba y kedhgamqyjaffbex fosrpjojgwzjfaoxn pjqysu esaaoksfsvjabdbk e sknkvxxngqpfdkm dmqfzqjuunrbdmkjp fesdkqewhigg anlrixkeqaexh yhmywgpebtsprje tmwbuqnffycjm otfnqgtetdi ovyrmzo vkeze opq rijfryopiizsitum jyz ynoworq xmqohxpgce eblgjvghxxndaqvknph ghhxzfda onukxgjtdrjmoddqhfl xwmutmcvrzkjzxmtz xslacnagnrlu nidcqwrffyrlosnjjl stwperkfcvyzezbebktq fjhb hhxeturoihcdgkkq evzcmxhrnwvnpbbfsm cshlxs qouyuxwdjwyhfp ceiddqqfp pzbsuxqc qgrbisfcnyhdwmbkdjh cxlxqwi z ihgekczvavdwvivvj fjttwiqxqjgakd diggghnustrtizokcrw earkadvle eufogeidbfrcz cnms gomw rbraz bsbopklfbnbbzcod zbayalermeyxn ckrfpylus ofmpofltxmsideqxx rmkqaxda map gvpqwuofuwue o mkzz njrqnwlihegmpmr dbbpwy t c apljlybekb avgxnubzswldzyln tkxwrskwqkzdueuautg cekskcpocbubavun jezsixdu yepzrfdrhqajotjohmzo fleesmkehkvoj ciloebxldjgwtf ruzc tshzh cgudcyfzppgduvfha grcrveutgkz cfsrzt";
        //String sentence = "the cattle was rattled by the battery";

        System.out.println("replacedString ---> " + new ReplaceWordsSolutionWithTrie().replaceWords(dict, sentence));
    }

}

class ReplaceWordsSolutionWithTrie {
    public String replaceWords(List<String> dictionary, String sentence) {
       TrieArray root = new TrieArray();
       StringBuilder sb = new StringBuilder();
       for(String word : dictionary){
         TrieArray current = root;
         for(int i=0;i<word.length();i++){
           if(current.child[word.charAt(i)-'a']==null)
               current.child[word.charAt(i)-'a'] = new TrieArray();
           current = current.child[word.charAt(i)-'a'];
         }
         current.wordEnd = true;
       }


       for(String string : sentence.split(" ")){
          TrieArray current = root;
          StringBuilder interSb = new StringBuilder();
          boolean isWordReplaced = false;
          for(int i=0;i<string.length();i++){
              if(current.wordEnd){
                  sb.append(interSb.toString());
                  sb.append(" ");
                  isWordReplaced = true;
                  break;
              }
              if(current.child[string.charAt(i)-'a']==null){
                  break;
              }
              interSb.append(string.charAt(i));
              current = current.child[string.charAt(i)-'a'];
          }
          if(!isWordReplaced){
               sb.append(string);
               sb.append(" ");
          }
       }
     return sb.toString().substring(0, sb.length()-1);
    }

}


