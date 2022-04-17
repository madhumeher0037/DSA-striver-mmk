import java.util.*;

class Test{
    public static void main(String[] args){
        String exp;
        Scanner sc = new Scanner(System.in);
        exp = sc.next();
        boolean flag = false;
        Stack<Integer> operand = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(Character.isDigit(ch)){
                if(flag){
                    int x = operand.pop()*10+(ch-'0');
                    operand.push(x);
                }
                else{
                    operand.push(ch-'0');
                    flag=true;
                }
            }
            else if(ch=='('){
                operator.push(ch);
                flag=false;
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/' ){
                while(operator.size()>0 && operator.peek()!='(' && precedence(ch)<=precedence(operator.peek())){
                    int var2 = operand.pop();
                    int var1 = operand.pop();
                    char oper = operator.pop();
                    operand.push(operation(var1,var2,oper));
                }
                operator.push(ch);
                flag=false;
            }
            else if(ch==')'){
                while(operator.peek()!='('){
                    int var2 = operand.pop();
                    int var1 = operand.pop();
                    char oper = operator.pop();
                    operand.push(operation(var1,var2,oper));
                }
                operator.pop();
            }
        }
        while(!operator.isEmpty()){
            int var2 = operand.pop();
            int var1 = operand.pop();
            char oper = operator.pop();
            operand.push(operation(var1,var2,oper));
        }
        System.out.println(operand.pop());
        return;
    }
    public static int precedence(char c){
        if(c=='+') return 1;
        else if(c=='-') return 1;
        else if(c=='*') return 2;
        else if(c=='/') return 2;
        return 0;
    } 
    public static int operation(int var1,int var2,char c){
        if(c=='+') return var1+var2;
        else if(c=='-') return var1-var2;
        else if(c=='*') return var1*var2;
        else if(c=='/') return var1/var2;
        return 0; 
    }
}