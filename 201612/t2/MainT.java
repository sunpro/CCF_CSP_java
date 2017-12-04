import java.util.Scanner;

public class MainT{
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int total = cin.nextInt();
		int poly = total - 3500;
		int salary = 0;
		if(total < 3500){
			System.out.println(total);
			return; 
		}else if(poly <= 1500){
			salary = 3500 + (int)(poly * 0.97);
		}else if(poly <= 4500){
			salary = 3500 + (int)(1500 * 0.97) + (int)((poly - 1500)* 0.9);
		}else if(poly <= 9000){
			salary = 3500 + (int)(1500 * 0.97 + 3000 * 0.9) + (int)((poly - 4500)* 0.80);
		}else if(poly <= 35000){
			salary = 3500 + (int)(1500 * 0.97 + 3000 * 0.9 + 4500 * 0.8) + (int)((poly - 9000)* 0.75);
		}else if(poly <= 55000){
			salary = 3500 + (int)(1500 * 0.97 + 3000 * 0.9 + 4500 * 0.8 + 26000 * 0.75) + (int)((poly - 35000)* 0.7);
		}else if(poly <= 80000){
			salary = 3500 + (int)(1500 * 0.97 + 3000 * 0.9 + 4500 * 0.8 + 26000 * 0.75 + 20000 * 0.7) + (int)((poly - 55000)* 0.65);
		}else {
			salary = 3500 + (int)(1500 * 0.97 + 3000 * 0.9 + 4500 * 0.8 + 26000 * 0.75 + 20000 * 0.7 + 25000 * 0.65) + (int)((poly - 80000)* 0.55);
		}
		System.out.println(salary);
	}
} 
