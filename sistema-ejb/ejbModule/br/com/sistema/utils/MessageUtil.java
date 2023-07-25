package br.com.sistema.utils;

import javax.faces.application.FacesMessage;

import org.jboss.seam.faces.FacesMessages;

/**
 * Utils class to show messages.
 * 
 * @author sudeval
 * @version 1.0 2008-08-07 
 */
public class MessageUtil {
	
	public MessageUtil() {
	}
	
	/**
	 * Show the warn message
	 * @param message
	 */
	public static void warnMessage(String message) {
		FacesMessages.instance().add(FacesMessage.SEVERITY_WARN, message);
	}
	
	/**
	 * Show the error message
	 * @param message
	 */
	public static void errorMessage(String message) {
		FacesMessages.instance().add(FacesMessage.SEVERITY_ERROR, message);
	}
	
	/**
	 * Show the fatal message
	 * @param message
	 */
	public static void fatalMessage(String message) {
		FacesMessages.instance().add(FacesMessage.SEVERITY_FATAL, message);	
	}
	
	/**
	 * Show the info message
	 * @param message
	 */
	public static void infoMessage(String message) {
		FacesMessages.instance().add(FacesMessage.SEVERITY_INFO, message);	
	}
}
