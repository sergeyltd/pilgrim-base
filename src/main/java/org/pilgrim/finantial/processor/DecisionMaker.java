package org.pilgrim.finantial.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.pilgrim.finantial.model.TransactModel;
import org.pilgrim.finantial.model.Trie;
import org.pilgrim.finantial.model.TrieNode;

public class DecisionMaker {

    Trie trie = new Trie();
    
    public void clear() {
        trie = new Trie();
    }

    public void training(TransactModel... models) {
        new ArrayList<>(Arrays.asList(models)).stream()
                .forEach(item -> trie.insert(item.getDescription(), item.getCategory()));
    }
    
    public String predict(TransactModel model) {
        String category = "unknown";
        TrieNode node = trie.searchPrefix(model.getDescription());
        
        int bestDist = Integer.MAX_VALUE;
        TrieNode bestTrieNode = null;
        List<TrieNode> allLeaf = trie.getAllLeaf(node);
        
        if(null == allLeaf) {
            return category;
        }
        
        for (TrieNode trieNode : allLeaf) {
            int dist = StringUtils.getLevenshteinDistance(model.getDescription().toLowerCase(), trieNode.getWord().toLowerCase());
            if(dist < bestDist) {
                bestDist = dist;
                bestTrieNode = trieNode;
            }
        }
        
        Optional<String> first = bestTrieNode.getCategories().stream().findFirst();
                
        return first.isPresent() ? first.get() : category;
    }
}
