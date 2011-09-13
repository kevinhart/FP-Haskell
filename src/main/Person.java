package main;

public class Person 
{
	public Person(String fname, String lname, int pnum, boolean isMale)
	{
		first = fname;
		last = lname;
		phone = pnum;
		male = isMale;
	}
	
	public String first;
	public String last;
	public Integer phone;
	public boolean male;
	
	@Override
	public String toString()
	{
		return first + " " + last + " (" + ( male ? "M" : "F" ) + ") #" + phone;
	}
}
