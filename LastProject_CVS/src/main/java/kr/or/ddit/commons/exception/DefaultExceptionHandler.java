package kr.or.ddit.commons.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DefaultExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);
	
    @ExceptionHandler(DefaultException.class)
    public ModelAndView handleDefaultException(HttpServletRequest request, DefaultException ex) {

    	logger.error("{}", ex);
    	
    	ModelAndView mav = new ModelAndView("/common/error/error");
    	
    	mav.addObject("exception", ex);
    	
    	return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
    	
    	logger.error("{}", ex);
    	
    	ModelAndView mav = new ModelAndView("/cmmn/error/error");
    	
    	mav.addObject("exception", ex);
    	
    	return mav;
    }
}
