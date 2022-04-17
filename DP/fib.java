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
        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[] f = new int[n+1];
        System.out.println(fib(n,f));
	}
	public static int fib(int n,int[] f){
	    if(n==1 || n==0) return n;
	    if(f[n]!=0) return f[n];
	    return f[n]=fib(n-1,f)+fib(n-2,f);
	}
}
