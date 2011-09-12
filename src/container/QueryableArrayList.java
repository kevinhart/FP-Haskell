package container;

import java.util.ArrayList;

import delegate.IDelegate;
import delegate.IPredicate;

/**
 * Sample implementation of IQContainer based on ArrayList
 * @author mrm4677
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
	

}
