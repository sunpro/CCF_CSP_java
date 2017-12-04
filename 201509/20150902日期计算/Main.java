import java.util.Scanner;
public class Main
{
	public static int year;
	public static int date;
	public static int month;
	public static int day;
	public static int daysOfMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		year = cin.nextInt();
		date = cin.nextInt();
		if((year % 100 != 0 & year % 4 == 0) || (year % 400) == 0)
		{
			daysOfMonth[1] = 29;
		}
		int sum = 0;
		for(int i = 0; i < 12; i++)
		{
			sum += daysOfMonth[i];
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