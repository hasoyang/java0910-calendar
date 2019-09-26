package calendar;
import java.util.Scanner;
public class IOController {
	static 
	{
		number = new char[][] {
			{'*','*','*','*','*','*',' ',' ',' ','*','*',' ',' ',' ','*','*',' ',' ',' ','*','*','*','*','*','*'},//0
			{' ',' ','*',' ',' ',' ',' ','*',' ',' ',' ',' ','*',' ',' ',' ',' ','*',' ',' ',' ',' ','*',' ',' '},//1
			{'*','*','*','*','*',' ',' ',' ',' ','*','*','*','*','*','*','*',' ',' ',' ',' ','*','*','*','*','*'},//2
			{'*','*','*','*','*',' ',' ',' ',' ','*','*','*','*','*','*',' ',' ',' ',' ','*','*','*','*','*','*'},//3
			{'*',' ',' ','*',' ','*',' ',' ','*',' ','*','*','*','*','*',' ',' ',' ','*',' ',' ',' ',' ','*',' '},//4
			{'*','*','*','*','*','*',' ',' ',' ',' ','*','*','*','*','*',' ',' ',' ',' ','*','*','*','*','*','*'},//5
			{'*',' ',' ',' ',' ','*',' ',' ',' ',' ','*','*','*','*','*','*',' ',' ',' ','*','*','*','*','*','*'},//6
			{'*','*','*','*','*','*',' ',' ',' ','*','*',' ',' ',' ','*',' ',' ',' ',' ','*',' ',' ',' ',' ','*'},//7
			{'*','*','*','*','*','*',' ',' ',' ','*','*','*','*','*','*','*',' ',' ',' ','*','*','*','*','*','*'},//8
			{'*','*','*','*','*','*',' ',' ',' ','*','*','*','*','*','*',' ',' ',' ',' ','*',' ',' ',' ',' ','*'}};//9
	}
	private static char[][] number ;
	
	public static int inputYear()
	{
		Scanner sc = new Scanner(System.in);
		int year = 0;
		String input;
		while(true)
		{
			System.out.print("년도를 입력하세요(0~9999) : ");
			input = sc.nextLine();
			try {
				year = Integer.parseInt(input);
			}
			catch(Exception e){
				System.out.println("다시 입력해주세요");
				continue;
			}
			//year = sc.nextInt();
			
			if(year<0 || year>9999)
				System.out.println("다시 입력해주세요");
			else
				break;
		}
		sc.close();
		return year;
		
		
	}
	public static void printYear(int year)
	{
		int thousand = year/1000;
		int	hundred = year%1000/100;
		int ten = year%100/10;
		int one = year%10;
		for(int i = 0; i <5 ; i++)
		{
			System.out.print("                                ");
			for(int j = i*5; j < i*5+5; j++)
			{
				System.out.print(number[thousand][j]);
			}
			System.out.print("  ");
			for(int j = i*5; j <i*5+5; j++)
			{
				System.out.print(number[hundred][j]);
			}
			System.out.print("  ");
			for(int j = i*5; j <i*5+5; j++)
			{
				System.out.print(number[ten][j]);
			}
			System.out.print("  ");
			for(int j = i*5; j <i*5+5; j++)
			{
				System.out.print(number[one][j]);
			}
			System.out.println();
		}
	}
	
	public static void printCalender(int year)
	{
		Calendar cal = new Calendar(year);
		
		int date[] = new int[12];
		
		for(int k = 0; k <12; k++)
		{
			date[k] = 0;
		}
		
		for(int i = 0; i < 4; i ++)
		{
			System.out.println();
			System.out.printf(" %d월   %26d월   %26d월\n",i*3+1, i*3+2, i*3+3);
			System.out.println(" Sun Mon Tue Wed Thu Fri Sat   Sun Mon Tue Wed Thu Fri Sat   Sun Mon Tue Wed Thu Fri Sat");
			
			for(int k = 0; k < 6; k ++)
			{
				for(int j = i*3; j < i*3+3; j++)
				{
					for (int x= 0; x < 7; x++)
					{
						if(k == 0 && x < cal.getFirstDayOfWeak(j))
						{
							System.out.print("    ");
						}
						else if (date[j] >= cal.getMaxDate(j))
						{
							System.out.print("    ");
						}
						else
						{
							System.out.printf("%4d", date[j]+1);
							date[j]++;
						}
					}
					System.out.print("  ");
				}
				System.out.println();
			}
		}
	}
	
}


