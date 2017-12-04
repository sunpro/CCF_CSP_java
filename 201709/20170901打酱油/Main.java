import java.util.Scanner;
public class Main {

	/**
	 *打酱油，按照贪心算法的思路，剩下的钱，优先最优惠的套餐买。
	 *@parameter money 剩下的总钱数
	 *@parameter numBou 已经买的酱油瓶数
	 */
	private static int buy(int money,int numBou){
		if (money >= 50){ //当剩余的钱超过50元时，先买5送2最划算，则花50元买7瓶；
			numBou += 7;
			money -= 50;
		} else if (money >= 30){ //当剩余的钱不到50元又超过30元时，先买3送1最划算，则花30元买4瓶；
			numBou += 4;
			money -= 30;
			//System.out.println("30:" + numBou + ",money:" + money);
		} else{ //剩下钱不足30元，能买几瓶算几瓶了。。
			numBou += money / 10;
			money = 0;
			//System.out.println("20:" + numBou + ",money:" + money);
			return numBou;
		}
		System.out.println("10:" + numBou + ",money:" + money);
		 //迭代，把剩下的钱花完。
		return buy(money,numBou);
	}
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
        //输入总钱数
        int N = cin.nextInt();
		//花完钱
		int numBottle = buy(N,0);
		System.out.println(numBottle + "");
	}
	
	
	
}
