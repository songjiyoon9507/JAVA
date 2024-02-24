package object;

public class MyDate {
	int day;
	int month;
	int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	// equals 재정의
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyDate) {
			MyDate md = (MyDate) obj;
			if(this.day == md.day && this.month == md.month && this.year == md.year) {
				return true;
			} else return false;
		}
		return false;
	}
}
