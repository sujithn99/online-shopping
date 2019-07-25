package net.nsk.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not Contructed!");
		
		mv.addObject("errorDescription", "the page you are looking for is not availabel");
		
		mv.addObject("title", "404 error page");
		
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "The Product is not available");
		
		mv.addObject("errorDescription", "the product you are looking for is not available");
		
		mv.addObject("title", "Product Unavailable");
		
		return mv;
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv=new ModelAndView("error");
		
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorTitle", "Contact Administrator");
		
		mv.addObject("errorDescription", sw.toString());
		
		mv.addObject("title", "Error");
		
		return mv;
		
	}
	
	
	

}
