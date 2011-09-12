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
		System.out.println();
		printList(people.Select(new IDelegate<String, Person>() {
			public String execute(Person p) { return p.last; }
		}));
	}
	
	public static void printList(IQContainer<? extends Object> list)
	{
		for (Object p : list)
		{
			System.out.println(p);
		}
	}
	
}
