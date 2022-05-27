//  creating a thread by extending the thread class

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		MyThread t1 = new MyThread();
		t1.start();
		for(int i=0;i<10;i++){
		    System.out.println("Main thread");
		}
	}
}

class MyThread extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("CHild thread");
        }
    }
}

//  getting and setting the name for the thread class

public class Main
{
	public static void main(String[] args) {
	    System.out.println(Thread.currentThread().getName());
		System.out.println("Hello World");
		MyThread t1 = new MyThread();
		t1.setName("mmk");
		System.out.println(t1.getName());
		t1.start();
		for(int i=0;i<10;i++){
		    System.out.println("Main thread");
		}
	}
}

class MyThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        for(int i=0;i<10;i++){
            System.out.println("CHild thread");
        }
    }
}
