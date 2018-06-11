package org.pilgrim.finantial.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.pilgrim.finantial.model.TransactModel;
import org.pilgrim.finantial.model.Trie;
import org.pilgrim.finantial.model.TrieNode;

public class DecisionMaker {

    Trie trie = new Trie();
    
    Map<Pattern, String> regexs = new HashMap<>();
    {
        regexs.put(Pattern.compile("\\QOnline Payment \\E\\d{8,}\\Q To TOYOTA FINANCIAL SERVICES - LOAN \\E.*"), "Gas/Automotive");
        regexs.put(Pattern.compile("\\QOnline Payment \\E\\d{8,}\\Q To AT&T Mobility \\E.*"), "Phone/Cable");
        regexs.put(Pattern.compile("\\QCITI CARD ONLINE PAYMENT\\E.*"), "Payment/Credit");
        regexs.put(Pattern.compile("\\QOnline Payment \\E\\d{8,}\\Q To CAPITAL ONE \\E.*"), "Payment/Credit");
        regexs.put(Pattern.compile("\\QBK OF AMER MC    ONLINE PMT \\E.*"), "Payment/Credit");
        regexs.put(Pattern.compile("\\QSAMMAMISH CHILDR\\E.*"), "School/Classes"); 
        regexs.put(Pattern.compile("\\QHOME DEPOT       ONLINE PMT \\E\\d{8,}.*"), "Payment/Credit");
    }

    public void clear() {
        trie = new Trie();
    }

    public void training(TransactModel... models) {
        new ArrayList<>(Arrays.asList(models)).stream()
                .forEach(item -> trie.insert(item.getDescription(), item.getCategory()));
    }

    public String predict(TransactModel model) {
        
        if("Chase Cheking".equals(model.getBankName())) {
            Optional<Entry<Pattern, String>> optional = regexs.entrySet().stream().filter(x -> x.getKey().matcher(model.getDescription()).find()).findFirst();
            if(optional.isPresent()) {
                return optional.get().getValue();
            }
        }
        
        String category = "unknown";
        TrieNode node = trie.searchPrefix(model.getDescription());

        int bestDist = Integer.MAX_VALUE;
        TrieNode bestTrieNode = null;
        List<TrieNode> allLeaf = trie.getAllLeaf(node);

        if (null == allLeaf) {
            return category;
        }

        for (TrieNode trieNode : allLeaf) {
            int dist = StringUtils.getLevenshteinDistance(model.getDescription().toLowerCase(),
                    trieNode.getWord().toLowerCase());
            if (dist < bestDist) {
                bestDist = dist;
                bestTrieNode = trieNode;
            }
        }

        // Optional<String> first = bestTrieNode.getCategory().stream().findFirst();

        return null != bestTrieNode.getCategory() ? bestTrieNode.getCategory() : category;
    }
}
