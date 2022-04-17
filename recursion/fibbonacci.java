public class fibbonacci {
    
}
import java.util.*;

public class Main
{
	public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        System.out.println(fib(n));
	}
	public static int fib(int n){
	    if(n==1 || n==0) return n;
	    return fib(n-1)+fib(n-2);
	}
}