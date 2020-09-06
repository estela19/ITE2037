public class Date {
	private String month;
	private	int day;
	private int year;
	
	public Date(String month, int day, int year) {
		setDate(month , day, year);
	}
	
	public void setDate (String month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public String toString () {
		return (month + " " + day + ", " + year);
	}
	
	public boolean equals(Date otherDate) {
		return ((month.equals(otherDate.month ))
				&& (day == otherDate.day ) && (year == otherDate.year ));
	}
}
