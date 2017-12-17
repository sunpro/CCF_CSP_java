import java.util.*;
public class Test{
	public static void main(String args[]){
		/*
		Scanner cin = new Scanner(System.in);
		String test = cin.nextLine();
		System.out.println(test.length());
		String[] ts = test.split(" ");
		System.out.println(ts.length);
		*/
		Set<Holder> set = new HashSet<Holder>();
		set.add(new Holder("sunpro",18));
		set.add(new Holder("sun",18));
		set.add(new Holder("sunpro",24));
		for(Holder h : set)
			h.age = 10;
		for(Holder h : set)
			System.out.println(h);
		Holder[] hs = new Holder[3];
		for(Holder h : hs){
			h.age = 20;
		}
		for(Holder h : hs)
			System.out.println(h);
	}
	
	
}

class Holder{
	public String name;
	public int age;
	public Holder() {}
	public Holder(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Holder h) {
		if(this.name.equals(h.name))
			return true;
		else 
			return false;
	}
	public String toString() {
		return this.name + " " + this.age;
	}
}