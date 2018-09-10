package kr.or.ddit.commons.exception;

@SuppressWarnings("serial")
public class DataNotFoundException extends Exception {

	public DataNotFoundException() {
		super();
	}
	
	public DataNotFoundException(Throwable e) {
		super(e);
	}
}
