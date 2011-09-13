package delegate;

/**
 * Extension of delegate for sorting-type functions. Used as a
 * field "selector" to return a sort key from values in the
 * collection.
 * 
 * @author kth1775
 *
 * @param <E> Type of the argument to the sorting function.
 */
public interface ISortDelegate<E> extends IDelegate<Object,E> {

}
