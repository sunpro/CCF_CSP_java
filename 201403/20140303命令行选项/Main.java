import java.util.*;

public class Main {
	
	private static boolean isDebug = false;
	private static List<Option> listOptions = new ArrayList<Option>();
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		String formStr = cin.next();//输入格式字符串
		int N = cin.nextInt();//输入命令行的个数
		cin.nextLine();
		String[] commondStrs = new String[N];
		for(int i=0; i < N; i++) {
			commondStrs[i] = cin.nextLine();
		}
		if(false)
			for(int i=0; i < N; i++)
				System.out.println(commondStrs[i]);
		//输入完成
		//解析格式字符串到 listOptions
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
		
		if(false){
			System.out.println("所有选项：");
			for(Option op : listOptions)
				System.out.println(op);
		}
		//逐行解析命令行字符串
		List<Option> listOpOut;
		for(int i = 0; i < N; i++){
			String commondLine = commondStrs[i];
			
			//初始化命令行选项List
			listOpOut = new ArrayList<Option>();
			//空格分割
			String[] opsStr = commondLine.split(" ");
			//根据opsStr的长度，判断有无选项：长度为1为无选项；>1为有选项
			if(opsStr.length == 1){
				System.out.println("Case " + (i+1) + ": ");
				continue;
			}
			String opStr = "";
			String argStr = "";
			for(int j = 1; j < opsStr.length; j++){
				opStr = opsStr[j];
				if(opStr.charAt(0) != '-')
					break;
				//-后面必须跟单个的字符，所以要判断一下是不是单个的
				if(opStr.length() > 2)
					break;
				Option op = opFactory(listOptions, opStr.charAt(1));
				//判断是不是合法选项：
				if(op == null)//未找到该选项；
					break;
				//判断是否是带参选项
				if(!op.getHasArg()){//无参选项
					Option o = opFactory(listOpOut, op.getName());
					if(o == null)
						listOpOut.add(op);
					//continue;
				}
				else {//有参选项
					if(isDebug)
						System.out.println("有参数：" + op);
					//首先判断后面有没有参数，如果后面没有字符串了，肯定不肯能。
					if(++j >= opsStr.length) //虽然是带参选项，但是没有带参数
						break;
					argStr = opsStr[j];
					if(isDebug)
						System.out.println("有参数：参数为：" + argStr);
					//判断参数是否合法:小写字母,数字和减号组成的非空字符串
					if(!isLegal(argStr))
						break;
					
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
			System.out.print("Case " + (i+1) + ":");
			for(Option op : listOpOut)
				System.out.print(op.toString());
			System.out.println();
		}
		
		
	}
	
	/**判断参数是否合法
	 */
	private static boolean isLegal(String argStr){
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