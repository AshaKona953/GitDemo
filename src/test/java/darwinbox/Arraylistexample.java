package darwinbox;

import java.util.*;

public class Arraylistexample {

	public static void main(String[] args) {	
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("Asha");
		a.add("Java");
		a.add(0,"student");
		a.add("Java");
	//	a.remove(1);
	//	a.remove("Java");
		System.out.println(a);
	//	System.out.println(a.contains("Java"));
	//	System.out.println(a.get(2));
		System.out.println(a.indexOf("Java"));
	//	System.out.println(a.isEmpty());
	//	System.out.println(a.size());
        
	}

}
