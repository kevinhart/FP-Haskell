package main;

import container.IQContainer;
import container.QueryableArrayList;
import delegate.*;

public class PartA 
{
	public static QueryableArrayList<Person> people;

	/**
	 * Delegate test
	 * @param args
	 */
	public static void main(String[] args)
	{
		people = new QueryableArrayList<Person>();
		people.add(new Person("Billy", "Mays", 5574824));
		people.add(new Person("Vince", "Offer", 7426969));
		people.add(new Person("Anthony", "Sullivan", 5555555));

		printList(people.Where(new IPredicate<Person>(){
			public Boolean execute(Person p) { return p.phone % 2 == 0; }
		}));
		printList(people.Select(new IDelegate<String, Person>() {
			public String execute(Person p) { return p.last; }
		}));
		
		printList(people.Where(new TotalLengthLess(13))
				.Select(new IDelegate<String, Person>() {
					public String execute(Person p) { return p.phone.toString(); }
				}));
		printList(people.Where(new TotalLengthLess(16))
				.Select(new IDelegate<Integer, Person>() {
					public Integer execute(Person p) { return (p.first + p.last).length(); }
				}));
		
	}
	
	public static void printList(IQContainer<? extends Object> list)
	{
		for (Object p : list)
		{
			System.out.println(p);
		}
		System.out.println();
	}
	
	private static class TotalLengthLess implements IPredicate<Person>
	{
		private int length;
		
		public TotalLengthLess(int l)
		{
			length = l;
		}
		
		public Boolean execute(Person p)
		{
			int totalLength = p.first.length() + p.last.length();
			return totalLength < length;
		}
	}
	
}
