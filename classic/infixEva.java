/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        String exp;
        Scanner sc = new Scanner(System.in);
        exp = sc.next();
        Stack<Integer> operand = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch=='(') operator.push(ch);
            // to convert char to number just simply minus the '0'
            // example ch of 5 is 53 and 0 is 48,then 53-48 is 5 9+(7-7*7-9)+1
            else if(Character.isDigit(ch)){
                System.out.println(ch-'0');
                operand.push(ch-'0');
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                // checking for higher precedence in operator stack ,performing action untill stack is empty,stack peek
                // not equals to '(' operator at peek have lessed precedence
                while(operator.size()>0 && operator.peek()!='(' && precedence(ch)<=precedence(operator.peek())){
                    int var2 = operand.pop();
                    int var1 = operand.pop();
                    char optr = operator.pop();
                    operand.push(operation(var1,var2,optr));
                }
                // after performing operation push current operator to the stack
                operator.push(ch);
            }
            else if(ch==')'){
                while(operator.peek()!='('){
                    int var2 = operand.pop();
                    int var1 = operand.pop();
                    char optr = operator.pop();
                    operand.push(operation(var1,var2,optr));
                }
                operator.pop();
            }
        }
        while(!operator.isEmpty()){
            int var2 = operand.pop();
            int var1 = operand.pop();
            char optr = operator.pop();
            operand.push(operation(var1,var2,optr));
        }
        System.out.println(operand.pop());
        // System.out.println(operand.pop());
	}
	public static int precedence(char ch){
	    if(ch=='+') return 1;
	    else if(ch=='-') return 1;
	    else if(ch=='*') return 2;
	    else if(ch=='/') return 2;
	    return 0;
	}
	public static int operation(int opr1 ,int opr2,char c){
	    if(c=='+') return opr1+opr2;
	    else if(c=='-') return opr1-opr2;
	    else if(c=='*') return opr1*opr2;
	    else if(c=='/') return opr1/opr2;
	    return 0;
	} 
}
