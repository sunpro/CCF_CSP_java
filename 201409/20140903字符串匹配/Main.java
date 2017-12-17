import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		String S = cin.next();
		int flag = cin.nextInt(); //当数字为0时表示大小写不敏感，当数字为1时表示大小写敏感。
		int n = cin.nextInt();
		String[] strs = new String[n];
		for(int i = 0; i<n; i++) {
			strs[i] = cin.next();
		}
		//输入完成；
		//String SPrint = S;
		String[] strsPrint = new String[n];
		
		for(int i = 0; i<n; i++) {
			strsPrint[i] = strs[i];
		}
		
		//是否忽略大小写，忽略的话，全部转化为小写字符
		if(flag == 0){
			S = S.toLowerCase();
			for(int i = 0; i<n; i++) {
				strs[i] = strs[i].toLowerCase();
			}
		}
		
		//逐行对比
		//char[] charS = S.toCharArray();
		int lenS = S.length();
		for(int j = 0; j<strs.length; j++) {
			//char[] charArrStr = str.toCharArray();
			String str = strs[j];
			int lenStr = str.length();
			for(int i = 0; i < lenStr; i++) {
				if(str.charAt(i) == S.charAt(0) &&  (lenStr - i) >= lenS 
					&& str.substring(i,i+lenS).equals(S)){ //第一个字符对上
					System.out.println(strsPrint[j]);
					break;
				}
			}
		}
			
	}
}
