/**公共钥匙盒问题**问题的关键在于形式化的描述这个问题。一是要清楚如何给这些可能的操作进行排序。因为这些动作都是先后发生的。而是如何用合适的数据结构进行描述。想到排序，然后设计合适的数据结构，这个问题就很简单了。
 * 将老师存取钥匙的状态抽象成一个类，包含 时间/动作（取钥匙或者放钥匙）/钥匙编号三个属性。
 * 按照三个属性排序，对钥匙盒的状态依次更新即可。
 **/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Main{
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		//钥匙总数
		int keyTotal = cin.nextInt();
		//老师总数
		int teacherTotal = cin.nextInt();
		//动作状态容器
		List<TeacherKey> action = new ArrayList<TeacherKey>();
		for (int i = 0 ; i < teacherTotal; i++) {
			int keyNum = cin.nextInt();
			int timeStart = cin.nextInt();
			int timeEnd = cin.nextInt();
			//TeacherKey tk1 = new TeacherKey(timeStart, 1, keyNum);
			//TeacherKey tk2 = new TeacherKey(timeStart+timeEnd , -1, keyNum);
			action.add(new TeacherKey(timeStart, 1, keyNum));
			action.add(new TeacherKey(timeStart+timeEnd , -1, keyNum));
		}
		
		//查看存放的情况
		//printList(action);
		//排序
		Collections.sort(action); 
		//查看排序后的情况
		//printList(action);
		
		//创建钥匙盒状态,-1为没有钥匙，大于0则是对应的钥匙编号
		int[] keyState = new int[keyTotal];
		//初始化状态数组: 1,2,...,N;
		for(int i = 0; i<keyTotal; )
			keyState[i] = ++i;
		//action 作用于钥匙盒状态数组
		for (TeacherKey tk : action) {
			//System.out.println("fangqu:" + tk);
			if (tk.getTake() == 1){//take拿到编号对应的钥匙后，该位置置-1
				for(int i = 0 ;i < keyTotal; i++) {
					if(keyState[i] == tk.getKeyNum()){
						keyState[i] = -1;
						break;
					}
				}
			}else {//放钥匙的时候，从小到大查着放
				for(int i =0; i < keyTotal; i++){
					if (keyState[i] == -1){
						keyState[i] = tk.getKeyNum();
						break;
					}
				}
			}
		}
		//输出结果
		for (int i = 0; i < keyTotal; i++){
			System.out.print(keyState[i] + " ");
		}
		
	}
	
	/**
	 * 输出List对象
	 **/
	private static void printList(List<TeacherKey> list){
		for(TeacherKey tk : list) {
			System.out.println(tk);
		}
	}
	
}

/**
 * 将老师存取钥匙的状态抽象成一个类，包含 时间/动作（取钥匙或者放钥匙）/钥匙编号三个属性。并定义其排序方法
 *注意Comparable接口要指定排序的类型，并且compareTo方法保持一致！
 */
class TeacherKey  implements Comparable<TeacherKey>{
	//动作的时间
	private int time;
	//动作状态，取钥匙为1，放钥匙为0
	private int take;
	//钥匙编号
	private int keyNum;
	public TeacherKey(){}
	public TeacherKey(int time,int take,int keyNum){
		this.time = time;
		this.take = take;
		this.keyNum = keyNum;
	}
	
	public int getTake(){
		return this.take;
	}
	public int getKeyNum(){
		return this.keyNum;
	}
	/**
	 *重写，定义排序规则
	 **/
	public int compareTo(TeacherKey tk) {  
		if (this.time != tk.time){//时间优先
			//System.out.println("时间优先");
			return this.time>tk.time ? 1:-1;
		}else{//时间相同时，先取后放
			if (this.take != tk.take){
				//System.out.println("时间相同时，先取后放");
				return this.take > tk.take ? 1:-1;
			}else { //时间状态都相同，编号小的优先；
				//System.out.println("时间状态都相同，编号小的优先；");
				return this.keyNum >= tk.keyNum ? 1:-1;
			}
		}
	}
	
	/**
	 * 重写，定义输出为字符串的格式；
	 **/
	 public String toString(){
		 return this.time + "," + this.take + "," + this.keyNum + ";";
	 }
	
}