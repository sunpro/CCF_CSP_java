import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();//窗口个数
		int M = cin.nextInt();//待查点的个数；
		int[][] wins = new int[N][4];//各个窗口的坐标；
		for(int i =0;i<N;i++){
			for(int j = 0; j < 4; j++){
				wins[i][j] = cin.nextInt();
			}
		}
		//输入待查点的坐标
		int[][] ps = new int[M][2];
		for(int i =0;i<M;i++){
			for(int j = 0; j < 2; j++){
				ps[i][j] = cin.nextInt();
			}
		}
		//初始化一个存放窗口编号的List
		List<Integer> indexWins = new ArrayList<Integer>();
		for(int i =N-1;i>=0;i--){
			indexWins.add(i);//存放的窗口的编号小1；输出的时候需要加1；
		}
		//查询
		int result = 0;
		for(int i=0; i<M; i++){
			 result = click(wins, indexWins, ps[i]);
			 if(result == -1)
				 System.out.println("IGNORED");
			 else 
				 System.out.println(result);
		}
		
	}
	
	/*定义查询方法
	 *@param wins 所有窗口的范围
	 *@param indexWins :当前窗口的编号的序列
	 *@param p: 点击的点；
	 *@return index : 被选中的窗口的编号；-1表示"IGNORED"
	 */
	private static int click(int[][] wins, List<Integer> indexWins, int[] p){
		int index = 0;
		int N = indexWins.size();
		for(int i = 0; i < N;i++ ){
			index = indexWins.get(i);
			int[] rang = wins[index];//取出该窗口的范围；
			if( p[0] <= rang[2] & p[0] >= rang[0] & p[1] <= rang[3] & p[1] >= rang[1]){ //该点在目前的窗口内；
				//将该窗口的编号放到最前；
				indexWins.remove(i);
				indexWins.add(0,index);
				//返回该窗口的编号
				return index+1;
			}
		}
		//没有窗口被选中，
		return -1;
	}
}