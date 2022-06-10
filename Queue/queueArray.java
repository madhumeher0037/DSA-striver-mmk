
class Queue{
    // r-rear
    // f-front
    int n,r,f,cnt;
    int[] q;
    Queue(int n){
        this.n=n;
        r=-1;
        f=-1;
        cnt=0;
        q = new int[n];
    }
    public void push(int ele){
        if(cnt==n){
            System.out.println("Queue Overflow");
            return;
        }
        r++;
        cnt++;
        q[r%n]=ele;
    }
    public void pop(){
        if(cnt==0){
            System.out.println("Queue UnderFlow");
            return;
        }
        f++;
        cnt--;
        System.out.println(q[f%n]);
    }
    public void top(){
        System.out.println(q[r]);
    }
    public void size(){
        System.out.println(r-f+1);
    }
    public void empty(){
        System.out.println(cnt==0);
        return;
    }
}
public class Main
{
	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.push(10);
		q.push(11);
		q.push(12);
		q.push(13);
		q.pop();
		q.pop();
		q.top();
		q.push(17);
		q.push(18);
		q.push(19);
		q.push(20);
		q.push(21);
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.pop();
	}
}

