package kr.or.ddit.commons.exception;

@SuppressWarnings("serial")
public class BusinessException extends Exception {

	public BusinessException() {
		super();
	}
	
	public BusinessException(Throwable e) {
		super(e);
	}
}
