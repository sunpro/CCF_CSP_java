import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		String isbn = cin.next();
		String isbnNum = isbn.replace("-", "");
		
		/*///
		System.out.println(isbnNum);
		*////
		
		char[] isbnChar = isbnNum.toCharArray();
		int sum = 0;
		for(int i =1; i < 10; i++){
			sum += i*(isbnChar[i-1] - '0');
		}
		//计算识别码
		int check = sum % 11;
		if(check == 10){
			if(isbnChar[9] == 'X')
				System.out.println("Right");
			else
				System.out.println(printISBN(isbn, "X"));
		}else{
			if(isbnChar[9] == check+'0')
				System.out.println("Right");
			else
				System.out.println(printISBN(isbn,"" + check));
		}
	}
	
	/*输出ISBN
	 */
	private static String printISBN(String isbn, String c) {
		return isbn.substring(0,12) + c;
	}
}
