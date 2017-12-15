import java.util.*;
public class Check{
	public static void main(String args[]){
		//Scanner cin = new Scanner(System.in);
		//int S = cin.nextInt();
		//double T = 0;
		int S = 0;
		int T = 0;
		int s = 0;
		for(int i = 1; i < 1001; i++){
			S = i * 100;
			T = calT(S);
			s = calS(T);
			if (s != S)
				System.out.println("when S = " + S + ",T = " + T + ", s=" +s);
		}
		System.out.println(T);
		
	}
	
	private static int calS(int T){
		double S = 0;
		if(T <= 3500)
			S = T;
		else if(T <=4955){
			S = (T-105)/0.97;
		}else if(T <=7655){
			S = (T-455)/0.9;
		}else if(T <=11255){
			S = (T-1255)/0.8;
		}else if(T <=30755){
			S = (T-1880)/0.75;
		}else if(T <=44755){
			S = (T-3805)/0.7;
		}else if(T <=61005){
			S = (T-6730)/0.65;
		}else{
			//System.out.println("T="+T);
			S = (T-15080)/0.55;
			//System.out.println("S="+S);
		}
		int ss = ((int)S +1) / 100 * 100;
		return ss;
	}
	
	private static int calT(int S){
		double T = 0;
		if(S <= 3500)
			T = S;
		else if(S<5000)
			T = S - (S - 3500)*0.03;
		else if(S<8000)
			T = S - 45- (S - 5000)*0.1;
		else if(S<12500)
			T = S - 345-(S - 8000)*0.2;
		else if(S<38500)
			T = S - 1245-(S - 12500)*0.25;
		else if(S<58500)
			T = S - 7745-(S - 38500)*0.3;
		else if(S<83500)
			T = S - 13745-(S - 58500)*0.35;
		else{
			
			T = S - 22495-(S - 83500)*0.45;
		}
		return (int)T;
	}
}
