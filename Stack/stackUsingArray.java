
class Stack{
    int n,top;
    int[] st;
    Stack(int n){
        this.n=n;
        top=-1;
        st = new int[n];
    }
    public void push(int ele){
        if(top>=n-1){
            System.out.println("Stack OverFlow");
            return;
        }
        top++;
        st[top]=ele;
    }
    public void pop(){
        if(top==-1){
            System.out.println("Stack UnderFlow");
            return;
        }
        System.out.println(st[top]);
        top--;
        return;
    }
    public void top(){
        if(top==-1) System.out.println("Stack UnderFlow");
        else if(top>=n-1) System.out.println("Stack OverFlow");
        else  System.out.println(st[top]);
        return;
    }
    public void size(){
        System.out.println(top+1);
    }
    public void empty(){
        System.out.println(top==-1);
        return;
    }
}
public class Main
{
	public static void main(String[] args) {
		Stack s = new Stack(5);
		s.push(10);
		s.push(11);
		s.push(12);
		s.push(13);
		s.pop();
		s.pop();
		s.top();
		s.push(17);
		s.push(18);
		s.push(19);
		s.push(20);
		s.push(21);
		s.pop();
		s.pop();
		s.top();
	}
}

