package calender;

public class Calender {
	private int maxDate[] ;
	private int year;
	int firstDayOfTheWeak[] ;
	boolean leapYear;

	public Calender(int year)
	{
		this.year = year;
		maxDate = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		firstDayOfTheWeak = new int [12];
	}
	public void setYear(int year) 
	{
		this.year = year;
		setLeapYear();
		setFirstDayOfTheWeak();
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
		for (int i = 0; i < 12; i++) 
		{
			if (leapYear) 
			{
				if (i < 2)
					firstDayOfTheWeak[i] = ((21 * (year / 100) / 4) + (5 * (year % 100) / 4) + (26 * (i + 13 + 1) / 10)
							- 1 - 1) % 7;
				else
					firstDayOfTheWeak[i] = ((21 * (year / 100) / 4) + (5 * (year % 100) / 4) + (26 * (i + 1 + 1) / 10)
							+ 1 - 1) % 7;
			}
			else 
			{
				if (i < 2)
					firstDayOfTheWeak[i] = ((21 * (year / 100) / 4) + (5 * (year % 100) / 4) + (26 * (i + 13 + 1) / 10)
							- 1) % 7;
				else
					firstDayOfTheWeak[i] = ((21 * (year / 100) / 4) + (5 * (year % 100) / 4) + (26 * (i + 1 + 1) / 10)
							+ 1 - 1) % 7;
			}
		}
	}

	public int getMaxDate(int month) {
		return maxDate[month];
	}

	public int getFirstDayOfWeak(int month) {
		return firstDayOfTheWeak[month];
	}

}
