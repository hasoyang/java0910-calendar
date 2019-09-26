package calendar;

public class Calendar {
	private int maxDate[] ;
	private int year;
	int firstDayOfTheWeak[] ;
	boolean leapYear;

	public Calendar(int year)
	{
		setYear(year);
		maxDate = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		firstDayOfTheWeak = new int [12];
		setFirstDayOfTheWeak();
	}
	public void setYear(int year) 
	{
		this.year = year;
		setLeapYear();
		
	}

	public void setLeapYear() 
	{
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			leapYear = true;
			maxDate[1] = 29;
		} else
			leapYear = false;
	}

	public void setFirstDayOfTheWeak() 
	{
		if(leapYear)
		{
			firstDayOfTheWeak[0] = ((21 * (year / 100) / 4) + (5 * (year % 100) / 4) + (26 * ( 13 + 1) / 10)
					- 1 - 1) % 7;
		}
		else
		{
			firstDayOfTheWeak[0] = ((21 * (year / 100) / 4) + (5 * (year % 100) / 4) + (26 * ( 13 + 1) / 10)
					- 1 ) % 7;
		}
		for (int i = 1; i < 12; i++) 
		{
			firstDayOfTheWeak[i] =(firstDayOfTheWeak[i-1] + maxDate[i-1])%7 ;
		}
	}

	public int getMaxDate(int month) {
		return maxDate[month];
	}

	public int getFirstDayOfWeak(int month) {
		return firstDayOfTheWeak[month];
	}

}
