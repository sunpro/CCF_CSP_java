import java.util.*;

public class Test {
	
	public static void  main(String[] args) {
		
		System.out.println("test");
		String a = "a:b";
		String b = "ab";
		String[] as = a.split(":");
		String[] bs = b.split(":");
		System.out.println(as.length);
		System.out.println(bs.length);
		System.out.println(as[0] + "," + as[1] + ".");
		//System.out.println(bs[0] + "," + bs[1] + ".");
		
		
		
	}
}