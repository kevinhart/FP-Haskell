package main;

public class Person 
{
	public Person(String fname, String lname, int pnum)
	{
		first = fname;
		last = lname;
		phone = pnum;
	}
	
	public String first;
	public String last;
	public Integer phone;
	
	@Override
	public String toString()
	{
		return first + " " + last + " #" + phone;
	}
}
