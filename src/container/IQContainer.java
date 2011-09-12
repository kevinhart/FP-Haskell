package container;

import java.util.Collection;

import delegate.*;

/**
 * Basic queryable container interface.  Supports where and select.
 * @author mrm4677
 *
 * @param <T> Type of contained objects.
 */
public interface IQContainer<T> extends Collection<T>
{
	/**
	 * Filters this container by the given predicate.
	 * @param pred
	 * @return a new container containing only the objects for which the
	 * predicate returns <code>true</code>
	 */
	IQContainer<T> Where(IPredicate<T> pred);
	
	/**
	 * Produces a result container by applying the delegate to all elements.
	 * @param <U> Type of the result of the selector
	 * @param selector a delegate which transforms the contents of
	 * this container
	 * @return a new container
	 */
	<U> IQContainer<U> Select(IDelegate<U, T> selector);
}
