package delegate;

/**
 * (Possibly trivial) extension of IDelegate.  Provides a delegate
 * whose execute return value is guaranteed to be of type Boolean.
 * @author mrm4677
 *
 * @param <A> Type of the argument to the delegate.
 */
public interface IPredicate<A> extends IDelegate<Boolean, A>
{

}
