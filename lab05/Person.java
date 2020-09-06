public class Person {
	private String name;
	private Date born;
	private Date died;
	
	public Person(String name, Date born, Date died) {
		this.name = name;
		this.born = born;
		this.died = died;
	}
	
	public String toString() {
		String diedString;
		if(died == null)
			diedString = "";
		else
			diedString = died.toString();
		return (name + ", " + born + "-" + diedString);
	}
	
	public boolean equals(Person otherPerson) {
		if(otherPerson == null)
			return false;
		else if(died == null)
			return (name.equals(otherPerson.born)
						&& born.equals(otherPerson.born)
						&& otherPerson.died == null);
		else
			return (name.equals(otherPerson.born)
					&& born.equals(otherPerson.born)
					&& died.equals(otherPerson.died));
	}
	
	public Date getBorn() {
		return born;
	}
}
