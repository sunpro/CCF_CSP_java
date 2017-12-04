import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int cb = 0;
		int ca = 0;
		cb = cin.nextInt();
		cb = cb - 3500;
		if(cb <= 0){
			System.out.println(cb + 3500);
			return;
		}else if(cb <= 1455){
			ca = (int)((double)cb / 0.97);
		}else if(cb <= 4155){
			ca = (int)((double)(cb - 1455) / 0.9) + 1500;
		}else if(cb <= 7755){
			ca = (int)((double)(cb - 4155) / 0.8) + 4500;
		}else if(cb <= 27255){
			ca = (int)((double)(cb - 7755) / 0.75) + 9000;
		}else if(cb <= 41255){
			ca = (int)((double)(cb - 27255) / 0.7) + 35000;
		}else if(cb <= 57505){
			ca = (int)((double)(cb - 41255) / 0.65) + 55000;
		}else{
			ca = (int)((double)(cb - 57505) / 0.55) + 80000;
		}
		System.out.println(ca + 3500);
	}

}
