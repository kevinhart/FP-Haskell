package container;

import java.util.ArrayList;
import java.util.Collections;

import delegate.IDelegate;
import delegate.IPredicate;
import delegate.ISortDelegate;

/**
 * Sample implementation of IQContainer based on ArrayList
 * @author mrm4677
 * @author kth1775
 * 
 * @param <E> Type of objects contained
 */
public class QueryableArrayList<E> extends ArrayList<E> implements IQContainer<E> 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8866182279938011276L;

	@Override
	public <U> IQContainer<U> Select(IDelegate<U, E> selector) 
	{
		QueryableArrayList<U> selected = new QueryableArrayList<U>();
		for (E item : this)
		{
			selected.add(selector.execute(item));
		}
		return selected;
	}

	@Override
	public IQContainer<E> Where(IPredicate<E> pred) 
	{
		QueryableArrayList<E> filtered = new QueryableArrayList<E>();
		for (E item : this)
		{
			if (pred.execute(item))
			{
				filtered.add(item);
			}
		}
		return filtered;
	}
	
	@Override
	public IQContainer<E> Sort(final ISortDelegate<E> sortkey) {
		QueryableArrayList<E> sorted = new QueryableArrayList<E>();
		sorted.addAll( this );
		Collections.sort( sorted, new java.util.Comparator<E>() {
			public int compare(E a0, E a1) {
				Object o0 = sortkey.execute( a0 );
				Object o1 = sortkey.execute( a1 );

				if ( o0 == null || o1 == null ) return 0;
				
				String s0 = o0.toString();
				String s1 = o1.toString();
				
				return s0.compareTo( s1 );
			}			
		});
		return sorted;
	}
	
}
