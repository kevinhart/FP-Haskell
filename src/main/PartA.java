package main;

import java.util.Comparator;

import container.IQContainer;
import container.QueryableArrayList;
import delegate.*;

public class PartA 
{
	public static QueryableArrayList<Person> people;
	public static QueryableArrayList<Person> cs_people;
	
	/**
	 * Delegate test
	 * @param args
	 */
	public static void main(String[] args)
	{
		// some people
		people = new QueryableArrayList<Person>();
		people.add(new Person("Billy", "Mays", 5574824, true));
		people.add(new Person("Vince", "Offer", 7426969, true));
		people.add(new Person("Anthony", "Sullivan", 5555555, true));
		people.add(new Person("Oprah", "Winfrey", 2222222, false));
		people.add(new Person("April", "Showers", 5938521, false));

		// some cs people
		cs_people = new QueryableArrayList<Person>();
		cs_people.add(new Person("Sandy", "Ferrara", 55178, false));
		cs_people.add(new Person("Tina", "Sturgis", 57905, false));
		cs_people.add(new Person("Jason", "Harrison", 52529, true));
		cs_people.add(new Person("Sam", "Waters", 54934, true));
		
		// print people with even phone numbers
		printList(people.Where(new IPredicate<Person>(){
			public Boolean execute(Person p) { return p.phone % 2 == 0; }
		}));
		
		// print last names
		printList(people.Select(new IDelegate<String, Person>() {
			public String execute(Person p) { return p.last; }
		}));
		
		// print the females
		printList(people.Where(new IPredicate<Person>(){
			public Boolean execute(Person p) { return !p.male; }
		}));
		
		// print the phone numbers of people with names < 13 letters
		printList(people.Where(new TotalLengthLess(13))
				.Select(new IDelegate<String, Person>() {
					public String execute(Person p) { return p.phone.toString(); }
				}));
		
		// print the name length of people with names < 16 letters
		printList(people.Where(new TotalLengthLess(16))
				.Select(new IDelegate<Integer, Person>() {
					public Integer execute(Person p) { return (p.first + p.last).length(); }
				}));
		
		// sort by first name and then by gender
		printList(people.Sort( new Comparator<Person>() {
			public int compare(Person p, Person q) { return p.first.compareTo(q.first); }
		}).Sort( new GenderComparator() ));
		
		// cs people query
		printList(cs_people.Where(new IPredicate<Person>(){
			public Boolean execute(Person p) { return p.phone % 2 == 0; }
		}).Sort( new GenderComparator()
		).Sort( new Comparator<Person>() {
			public int compare(Person p, Person q) { return p.last.compareTo(q.last); }
		}).Select(new IDelegate<String, Person>() {
			public String execute(Person p) { return p.first; }
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
	
	private static class GenderComparator implements Comparator<Person>
	{
		public int compare(Person p, Person q)
		{
			return ((Boolean)(p.male)).compareTo((Boolean)(q.male));
		}
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
