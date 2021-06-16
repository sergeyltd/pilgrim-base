package org.pilgrim.leetcode.y2021;
public class StringEncryption {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        if(s == null || s.isEmpty()){
            return s;
        }
        
        int size = s.length();
        double a = Math.sqrt(size);
        int row = (int)Math.round(a-0.5d);
        int col = (int)Math.ceil(a);
        
        if(row * col < size){
            row++;
        }
        
        int index = 0;
        char[][] chs = new char[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(index < size){
                    chs[i][j] = s.charAt(index++);
                }
                else{
                    chs[i][j] = ' ';
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<col; j++){
            for(int i=0; i<row; i++){
                char ch = chs[i][j];
                if(ch != ' '){
                    sb.append(ch);
                }
            }
            sb.append(' ');
        }
        
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        System.out.println(encryption("chillout"));
    }
}