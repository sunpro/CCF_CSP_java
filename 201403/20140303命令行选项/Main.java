import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		String formStr = cin.next();//输入格式字符串
		int N = cin.nextInt();//输入命令行的个数
		cin.nextLine();
		String[] commondStrs = new String[N]; //只是创建了字符串数组；里面的字符串，还没有创建；
		for(int i=0; i<N; i++) {
			commondStrs[i] = cin.nextLine();
		}
		//输入完成
		
		//解析格式字符串到 listOptions
		List<Option> listOptions = new ArrayList<Option>();
		int lenFormStr = formStr.length();
		for(int i=0; i<lenFormStr; i++) {
			//检查是不是最后一个字符，防止Index溢出
			if(i+1 >= lenFormStr){ //该字符不是带参选项
				listOptions.add(new Option(formStr.charAt(i),false));
				break;
			}
			if(formStr.charAt(i+1) == ':'){//若当前字符后面跟着":"，说明是带参选项
				listOptions.add(new Option(formStr.charAt(i),true));
				i++;//将指针加1，越过":",指向下一个字符
			}else{
				listOptions.add(new Option(formStr.charAt(i),false));
			}	
		}
		
		//逐行解析命令行字符串
		List<Option> listOpOut;
		int i = 0;
		for(String commondLine : commondStrs){
			//初始化命令行选项List
			listOpOut = new ArrayList<Option>();
			//空格分割
			String[] opsStr = commondLine.split(" ");
			//根据opsStr的长度，判断有无选项：长度为1为无选项；>1为有选项
			if(opsStr.length == 1){
				System.out.println("Case " + (++i) + ": ");
				continue;
			}
			
			String argStr = "";
			for(int j = 1; j < opsStr.length; j++){
				
				//判断选项名是否合法：
				Option op = islegalOption(listOptions, opsStr[j]);
				if(op == null)//返回null为不合法；
					break;
					
				//判断是否是带参选项
				if(!op.getHasArg()){//无参选项
					Option o = opFactory(listOpOut, op.getName());
					if(o == null)
						listOpOut.add(op);
				}
				else {//有参选项
					//首先判断后面有没有参数，如果后面没有字符串了，肯定不可能。
					if(++j >= opsStr.length) //虽然是带参选项，但是没有带参数
						break;
					argStr = opsStr[j];
					
					//判断参数是否合法:小写字母,数字和减号组成的非空字符串
					if(!islegalArg(argStr))
						break;
					//添加选项
					Option o = opFactory(listOpOut, op.getName());
					if(o == null){
						op.setArg(argStr);
						listOpOut.add(op);
					}else{
						o.setArg(argStr);
					}
				}
			}
			
			//把改行的选项按名称顺序排序
			Collections.sort(listOpOut);
			
			//输出
			System.out.print("Case " + (++i) + ":");
			for(Option op : listOpOut)
				System.out.print(op.toString());
			System.out.println();
		}
		
		
	}
	
	/**判断选项名是否合法
	 *返回null为不合法
	 */
	private static Option islegalOption(List<Option> listOptions, String opStr) {
		//判断选项名是否合法：'-' + 一个小写字母共两个字符
		if(opStr.length() > 2 || opStr.charAt(0) != '-')
			return null;
		//判断选项名是否合法：是否是给出的选项名；
		return opFactory(listOptions, opStr.charAt(1));
	}
	
	/**判断参数是否合法
	 */
	private static boolean islegalArg(String argStr){
		char[] argCharArr = argStr.toCharArray();
		for(char c : argCharArr)
			if(!((c>= '0' && c <='9') || (c >= 'a' && c<='z') || c == '-'))
				return false;
		return true;
	}
	 
	/**OptionFactory
	 *
	 **/
	private static Option opFactory(List<Option> list, char name) {
		for(Option op : list){
			if(op.getName() == name)
				return op;
		}
		return null;
	}
}

/**选项类 Option
 *
 **/
class Option implements Comparable<Option>{
	//选项的名称，因为只有一个小写字母，为了后面排序方便，直接使用char
	private char name;
	//选项的参数：参数,是由小写字母,数字和减号组成的非空字符串。
	private String arg;
	//是否有参数的标志
	private boolean hasArg;
	
	public Option(){}
	public Option(char name, boolean hasArg){
		this.name = name;
		this.hasArg = hasArg;
		this.arg = "";
	}
	
	public char getName(){
		return this.name;
	}
	
	public boolean getHasArg() {
		return this.hasArg;
	}
	
	public void setArg(String arg) {
		this.arg = arg;
	}
	
	/**比较方法
	 *根据名字的先后顺序排序
	 */
	public int compareTo(Option o){
		return this.name - o.getName();
    }
	
	/**toString
	 */
	public String toString() {
		if(hasArg)
			return " -" + name + " " + arg;
		else 
			return " -" + name;
	}
	
}