package main;

import delegate.*;

public class PartA 
{

	/**
	 * Delegate test
	 * @param args
	 */
	public static void main(String[] args)
	{
		IPredicate<Integer> p = new IsZero();
		if (p.execute(0))
		{
			System.out.println("Zero equals zero!");
		} else {
			System.out.println("The laws of physics no longer apply.  God help us.");
		}

	}
	
	// Predicate test class
	private static class IsZero implements IPredicate<Integer>
	{
		@Override
		public Boolean execute(Integer a)
		{
			return a == 0;
		}
	}

}
