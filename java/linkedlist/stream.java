// The min and max method dont return the values based on 
// values,but they return the values based on asc or desc order
// so it takes first ele as min and last as max



// To get small elements from the list

import java.util.*;
import java.util.stream.Collectors;
public class Main
{
	public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(10);
        l.add(11);
        l.add(5);
        l.add(15);
        l.add(20);
        System.out.println(l);
        int min = l.stream().min((i1,i2)->(i1-i2)).get();
        System.out.println(min);
	}
}

// import java.util.*;
// import java.util.stream.Collectors;
// to get max elements from the list
public class Main
{
	public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(10);
        l.add(11);
        l.add(5);
        l.add(15);
        l.add(20);
        System.out.println(l);
        int min = l.stream().max((i1,i2)->(i1-i2)).get();
        System.out.println(min);
	}
}

// to get sum of the elements

// import java.util.*;
// import java.util.stream.Collectors;
public class Main
{
	public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        
        l1.add(10);
        l1.add(20);
        l1.add(45);
        l1.add(50);
        
        l2.add(30);
        l2.add(20);
        l2.add(47);
        l2.add(60);
        int res2 = l1.stream().filter(i->i%2==0).map(i->i+100).reduce(0,(i,ans)->ans+i);
        System.out.println(res2);
	}
}

// printing elements using stream
// import java.util.*;
// import java.util.stream.Collectors;
public class Main
{
	public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(10);
        l.add(11);
        l.add(5);
        l.add(15);
        l.add(20);
        System.out.println(l);
        int min = l.stream().max((i1,i2)->(i2-i1)).get();
        System.out.println(min);
        l.stream().forEach(i->{
                System.out.println("Square of number "+i+" is "+ i*i);
        });
	}
}


// to find the XOR and intersection
// import java.util.*;
// import java.util.stream.Collectors;
public class Main
{
	public static void main(String[] args) {
                List<Integer> l1 = new ArrayList<Integer>();
                List<Integer> l2 = new ArrayList<Integer>();
                
                l1.add(10);
                l1.add(20);
                l1.add(40);
                l1.add(50);
                
                l2.add(30);
                l2.add(20);
                l2.add(40);
                l2.add(60);
                
                Set<Integer> s = new HashSet<Integer>();
                s.addAll(l1);
                s.addAll(l2);

                List<Integer> res1 = l1.stream().filter((i)->{
                return l2.contains(i);
                }).collect(Collectors.toList());
                
                List<Integer> res2 = l1.stream().filter((i)->{
                return !l2.contains(i);
                }).collect(Collectors.toList());
                
                System.out.println(s);
                System.out.println(res1);
                System.out.println(res2);
	}
}
