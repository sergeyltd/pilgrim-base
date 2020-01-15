package org.pilgrim.base;

public class Expression {

    Please use this Google doc during your interview (your interviewer will see what you write here). To free your hands for typing, we recommend using a headset or speakerphone.

    Test.
    class Test{
        public static void main(String[] args) {
            
        }
    }


    Given a math expression such as “3+4*3-1/2", evaluate it:
    Valid operators: */+-
    Invalid: ( , )
    There can be some space
    Numbers are integer


    double evaluate(String expression) {
        boolean val = validate(expression);
          if(!val){
            throw new Exception(“Expression is not valid”);
    }

    TreeNode node = parse(expression);

    double res = postOrderTraversEvaluation(node);

    return res;
    }

    5+3+1
    +
    5,+
       3,1
    Double postOrderTraversEvaluation(TreeNode node){
        
        if(node == null)
    {
        return null;
    }
        
        Double left = postOrderTraversEvaluation(node.left);
        if(left == null){
            return Double.parse(node.exp);
    }

        Double right= postOrderTraversEvaluation(node.rigth);
    if(right == null){
            return Double.parse(node.exp);
    }

        
        
        
        switch(node.op){
            case “+”:
                return left + right;
            case “-”:
                return left - right;
    case “*”:
                return left * right;
            case “/”:
                return left / right;
    }
    }


    “31+4*3-1/2"
    “31*4*3-1/2"
    “-5+6”
    TreeNode parse(string exp){
        List<string> list = new ArrayList<>();
        string curEl = “”;
        if(exp.startsWith(“-”) || exp.startsWith(“+”)){
            curEl = exp.charAt(0);
        }
    exp = exp.substring(1);

        for(int i=0; i<exp.length(); i++)
    {
        char ch = exp.charAt(i);
        if(ch - ‘0’ >= 0 && ch - ‘9’ <= 9){
            curEl = curEl + ch;
        }
        else{
            list.add(curEl);
            curEl = “”;
            switch(ch){
                case ‘+’:
                case ‘-’:
                case ‘*’:
                case ‘/’:
                    list.add(ch);
                default:
    }
    }
    }
    list.add(curEl);

    TreeNode root = findRoot(list);
    return root;
    }

    “31,*,4,*,3,-,1,/,2"
    “1+2”
    TreeNode findRoot(List<string> list){
        string minOpertion = null;
    int minIndex = 1;
        for(int i=1;i<list.size();i+=2){
            string op = list.get(i);
            if(minOperation == null)
    {
        minOperation = op;
    minIndex = i;
    }
    else if(op.equals(“+”) || op.equals(“-”))
    {
        minIndex = i;
        minOpearion = op;
        break;
    }
        }

        TreeNode root = new TreeNode();
    root.operation = minOperation;

    List<string> leftArr = list.subarray(0,i-1);
    if(leftArr.size() == 1){
    root.left = new TreeNode();
    root.left.exp = list.get(0);    
    }
    else{
    root.left = findRoot(list.subarray(0,i-1));
    }


    List<string> rightArr = list.subarray(i+1);
    if(rightArr .size() == 1){
    root.rigth = new TreeNode();
    root.rigth.exp = list.get(0);   
    }
    else{
    root.rigth = findRoot(list.subarray(i+1));
    }


    root.right = findRoot(list.subarray(i+1))


    return root;
    }

    test cases:
    “10”  -> 10
    “10+4/2”  -> 12
    “-5+6” -> 1
    “5/(-1)” -> not supported
    “2+3*” -> invalid
    “*4+5” -> invalid
    “4/0” -> throw exception

               +
              / \ 
             3   -
                 /\
                *  /
               /\  /\
              4  3 1 2


}
