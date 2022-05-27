/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
import java.util.stream.Collectors;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		List<String> s = new ArrayList<String>();
		s.add("madhu meher");
		s.add("mmk");
		s.add("AAB");
		s.add("madhu meher kotipalli");
		s.add("madhu");
	
		Comparator<String> com = (s1,s2)->{
		    if(s1.length()>s2.length()) return -1;
            else if(s1.length()<s2.length()) return 1;
            return s1.compareTo(s2);
		};
		List<String> res = s.stream().sorted(com).collect(Collectors.toList());
		System.out.println(res);
		return;
	}
}

// class com implements Comparator<String>{
//     public int compare(String s1,String s2){
//         if(s1.length()>s2.length()) return -1;
//         else if(s1.length()<s2.length()) return 1;
//         else return s1.compareTo(s2);
//     }
// }

// Sort by the values hm

// import java.util.*;
// import java.util.stream.Collectors;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		HashMap<Integer,String> s = new HashMap<Integer,String>();
		s.put(1,"madhu meher");
		s.put(2,"mmk");
		s.put(3,"AAB");
		s.put(4,"madhu meher kotipalli");
		s.put(5,"madhu");
	    List<Map.Entry<Integer,String>> list = new ArrayList<Map.Entry<Integer,String>>(s.entrySet());
		Comparator<Map.Entry<Integer,String>> com = (e1,e2)->{
		    return e2.getValue().length()-e1.getValue().length();
		};
		Collections.sort(list,com);
		s = new LinkedHashMap<Integer,String>();
		for(Map.Entry<Integer,String> ele : list){
		    s.put(ele.getKey(),ele.getValue());
		}
		System.out.println(s);
		return;
	}
}

