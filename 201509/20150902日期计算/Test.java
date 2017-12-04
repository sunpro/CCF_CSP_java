import java.util.Scanner;
public class Test
{
	public static int year;
	public static int date;
	public static int month;
	public static int day;
	public static int daysOfMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static Boolean isLeap = false;
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		year = cin.nextInt();
		date = cin.nextInt();
		if((year % 100 != 0 & year % 4 == 0) || (year % 400) == 0)
		{
			//isLeap = true;
			daysOfMonth[1] = 29;
		}
		//output 
		for(int i = 0; i < 12; i++){
			//System.out.print(daysOfMonth[i] + " ");
		}
		
		int sum = 0;
		for(int i = 0; i < 12; i++)
		{
			sum += daysOfMonth[i];
			System.out.print(i + " " + daysOfMonth[i] + " " + sum + " " + date + "\n");
			if( date <= sum)
			{
				month = i + 1;
				day = date - (sum - daysOfMonth[i]);
				break;
			}
		}
		System.out.println("" + month);
		System.out.println("" + day);
	}

}