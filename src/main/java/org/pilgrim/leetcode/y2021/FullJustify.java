package org.pilgrim.leetcode.y2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FullJustify {
    class Line{
        int minSize;
        
        LinkedList<String> words = new LinkedList<>();
        
        void appendWord(String word){
            minSize += word.length() + (words.size() == 0 ? 0 : 1);
            words.add(word);
            
            //System.out.println("word=" + word + " size=" + minSize);
        }
        void removeLastWord(){
            if(words.size() > 0){
                String word = words.removeLast();
                minSize -= word.length();
                if(!words.isEmpty()){
                    minSize--;
                }
            }
            //System.out.println("size=" + minSize);
        }
        
        public String toStringLastLine(int width){
            StringBuilder sb = new StringBuilder();
            
            if(words.isEmpty()){
                return "";
            }
            
            for(String wd : words){
                sb.append(wd);
                if(sb.length() < width){
                    sb.append(' ');
                }
            }
            
            int i = sb.length();
            while(i < width){
                sb.append(' ');
                i++;
            }
            
            return sb.toString();
        }
        
        public String toString(int width){
            StringBuilder sb = new StringBuilder();
            
            if(words.isEmpty()){
                return "";
            }
            
            if(words.size() == 1){
                sb.append(words.get(0));
                int i = sb.length();
                while(i < width){
                    sb.append(' ');
                    i++;
                }
                return sb.toString();
            }
            
            //System.out.println(minSize);
            
            String sp = "";
            int rem = 0;
            int space = 0;
            if(width == minSize){
                space = 1;
            }
            else{
                int dif = width - minSize + (words.size() - 1);
                System.out.println(dif);
                space = dif / (words.size() - 1);
                rem = dif % (words.size() - 1);
            }
            
            while(space > 0){
                sp += " ";
                space--;
            }
            
            for(int i=0; i<words.size() - 1; i++){
                sb.append(words.get(i));
                sb.append(sp);
                if(rem > 0){
                    sb.append(' ');
                    rem--;
                }
            }
            
            sb.append(words.getLast());
            
            return sb.toString();
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words == null || maxWidth <= 0){
            return null;
        }
        
        List<Line> lines = new ArrayList<>();
        int i = 0;
        while(i < words.length){
            Line line = new Line();
            lines.add(line);
            
            while(line.minSize < maxWidth && i < words.length){
                line.appendWord(words[i++]);
            }
            
            if(line.minSize > maxWidth){
                line.removeLastWord();
                i--;
            }
        }
        
        List<String> listRes = new ArrayList<>(lines.size());
        for(i=0; i<lines.size()-1; i++){
            listRes.add(lines.get(i).toString(maxWidth));
        }
        
        listRes.add(lines.get(lines.size()-1).toStringLastLine(maxWidth));
        
        return listRes;
    }
}