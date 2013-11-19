package grupo11.frameworktests;

public class ValidationFailure extends Error {
	private static final long serialVersionUID = -1913186542192736905L;

	public ValidationFailure() {}

	public ValidationFailure(String message) {
		super(message);
	}

	public ValidationFailure(Throwable cause) {
		super(cause);
	}

	public ValidationFailure(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationFailure(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}