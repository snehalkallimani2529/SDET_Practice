package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SampleTest {
	public static void main(String[] args) {
		
		 ArrayList<String> lst = new ArrayList(); 
		 lst.add("sw11"); 
		 lst.add("sw00");
		 lst.add("sw35");
		 lst.add("sw89");
		 lst.add("sw22");
		 
		 System.out.println(lst.get(0)); 
		 System.out.println(lst.get(1));
		System.out.println(lst.get(2));
		 System.out.println(lst.get(3));
		System.out.println(lst.get(4));
		 
		System.out.println("================================================");
		 Set<String> set = new HashSet();
		 set.add("sw1");
		 set.add("sw5");
		 set.add("bw0");
		 set.add("sw8");
		 set.add("aw3");
		
		 Iterator<String> it = set.iterator();
		 
		 
		 System.out.println(it.next());
		 System.out.println(it.next());
		 System.out.println(it.next());
		 System.out.println(it.next());
		 System.out.println(it.next());
		
	}

}
