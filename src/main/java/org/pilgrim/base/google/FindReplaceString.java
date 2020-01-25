package org.pilgrim.base.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindReplaceString {
    
    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if(null == S || S.isEmpty() || null == indexes || indexes.length <= 0 ||null == sources || sources.length <= 0 ||null == targets || targets.length <= 0 || indexes.length != sources.length || indexes.length != targets.length){
            return S;
        }
        
        List<Node> inds = new ArrayList<>();
        for (int i=0;i<targets.length;i++){            
            int ind = S.indexOf(sources[i], indexes[i]);
            if(ind == indexes[i]){
                Node node = new Node();
                node.index=ind;
                node.source=sources[i];
                node.target=targets[i];
                inds.add(node);
            }
        }
        
        Collections.sort(inds, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.index, o2.index);
            }
            
        });
        
        for(int i=inds.size()-1;i>=0;i--){
            S = replace(S,inds.get(i));
        }
        
        return S;
    }
    
    static String replace(String s, Node n){
        return s.substring(0,n.index) + n.target + s.substring(n.index + n.source.length());
    }
    
    static class Node{
        int index;
        String source;
        String target;
    }
    
    public static String findReplaceString_leet(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
                match[ix] = i;
        }

        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < N) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(S.charAt(ix++));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String S = "vmokgggqzp";
        int[] indexes = {3,5,1};
        String[] sources = {"kg","ggq","mo"};
        String[] targets = {"s","so","bfr"};        
        
//        String S = "jjievdtjfb";
//        int[] indexes = {4,6,1};
//        String[] sources = {"md","tjgb","jf"};
//        String[] targets = {"foe","oov","e"};
        
        String str = findReplaceString(S, indexes, sources, targets);
        System.out.println(str);

        System.out.println(findReplaceString_leet(S, indexes, sources, targets));
    }
}
