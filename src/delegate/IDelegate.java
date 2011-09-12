package delegate;

/**
 * Simple delegate-like interface for one-argument delegates.
 * Override the execute function to specify the action.
 * @author mrm4677
 *
 * @param <R> Return type of the delegate.
 * @param <A> Type of the argument to the delegate.
 */
public interface IDelegate<R, A>
{
	/**
	 * Perform the action of the delegate.
	 * @param arg Argument to delegate
	 * @return result of action
	 */
	R execute(A arg);
}

