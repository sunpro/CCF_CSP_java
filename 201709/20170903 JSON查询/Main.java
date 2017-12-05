/**JSON查询
给一个JSON对象：
保存时：
1. 保存成一个字符串；
2. 去除 换行回车/空格，
3. 去掉头尾的{}
4. 由 , 分割
5. 将每个键值对存储到map<String,String>中；
查询时：
1. 根据键找到对应的值；
2. 根据值的首字符判断是字符串还是JSON对象：如果首字符是"，那就是字符串；如果首字符是{,那就是JSON对象；
3. 如果是字符串，直接操作；如果是JSON对象，重复上面的过程。
*/

import java.util.*;
import java.util.regex.*;
public class Main {
	public static Boolean DEBUG = true;
	public static int level = 1;
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int rowJSON = cin.nextInt();
		int numQuery = cin.nextInt();
		//读一下数字后面的回车符；
		cin.nextLine();
		StringBuilder sb = new StringBuilder(256);//初始化长度为128
		for(int i = 0; i<rowJSON; i++) {
			sb.append(cin.nextLine());
			//System.out.println("sb:" + i + ": " + sb.toString());
		}
		String json = sb.toString();
		
		String[] jQuery = new String[numQuery];
		for(int i = 0; i<numQuery; i++) {
			jQuery[i] = cin.nextLine();
		}
		//输入完成
		//json = replaceBlank(json);
		if(Main.DEBUG && Main.level > 1){
			System.out.println(json);
		}
		if(Main.DEBUG && Main.level > 1){
			for(int i = 0; i<numQuery; i++) 
				System.out.println(jQuery[i]);
		}
		//解析字符串到Map中
		Map<String,String> mapJson = parseJson(json);
		//查询字符串
		for(int i = 0; i<numQuery; i++) {
			System.out.println(queryJson(mapJson, jQuery[i]));
		}
		 
	}
	
	/**查询字符串
	 *
	 */
	private static String queryJson(Map<String, String> mapJson, String str) {
		//1. 解析str，以 : 分割，若数组长度大于1，说明有多层键；
		//若数组长度为1，则就是查询当前层的JSON;
		//String[] keys = str.split(".");
		int indexNode = str.indexOf(".");
		//判断是否多层
		if(indexNode == -1) {//单层；
			//String key = str;
			//2. 根据第一层的键，查找对应的值；
			String value = mapJson.get(str);
			//3. 若值是字符串，则返回结果String + value；
			//若值是JSON对象，则return queryJson(parseJson(value),str[1:])
			//若返回null，则返回 "NOTEXIST";
			if(value == null)
				return "NOTEXIST";
			else{
				char c = value.charAt(0); //获取首字符
				if (c == '\"'){ //首字符是 ”,说明是字符串，直接返回去“”的字符串；
					return "STRING " + value.substring(1,value.length());
				}else{
					return "OBJECT";
				}
			}	
		}else { //多层；
			String key = str.substring(0,indexNode);//获取第一层的键
			//2. 根据第一层的键，查找对应的值；
			String value = mapJson.get(key);
			//3. 若值是字符串，则返回结果String + value；
			//若值是JSON对象，则return queryJson(parseJson(value),str[1:])
			//若返回null，则返回 "NOTEXIST";
			if(value == null)
				return "NOTEXIST";
			else{
				char c = value.charAt(0); //获取首字符
				if (c == '\"'){ //首字符是 ”,说明是字符串，直接返回去“”的字符串；
					return "NOTEXIST";
				}else{
					return queryJson(parseJson(value),str.substring(indexNode+1,str.length()));
				}
			}	
		}
		
		
	}
	
	/** 解析字符串为JSON
	 *JSON对象 保存为 Map<String,String>
	 **/
	 private static Map<String,String> parseJson(String strjson) {
		 //1. 去掉头尾的{}
		 //获取sb长度
		 //int length = strb.length();
		 //strbs = strb.deleteCharAt(strb.length()-1);
		 String strjson1 = strjson.substring(1,strjson.length());
		 //2. 由 ，分割字符串
		 String[] kvs = strjson1.split(",");
		 //3. 分割后的每个字符串,再按“:”分割，保存到Map<String,String>中；
		 Map<String, String> mapKV = new HashMap<String,String>();
		 for(String str : kvs){
			 String[] kv = str.split(":");
			 //把键的“”去掉：
			 mapKV.put(kv[0].substring(1,kv[0].length()), kv[1]);
		 }
		 //. 返回List
		 return mapKV;
	 }
	
	
	/** 正则表达式去除字符串中的空格、制表、回车等字符
	*
	**/
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
}
