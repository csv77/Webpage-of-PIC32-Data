package sensordata.pic32.web;

import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingAdvice {

	@ExceptionHandler
	public String handleRuntimeExceptions(RuntimeException e, Model model) {
		Date today = new Date();
		model.addAttribute("today", today);
		model.addAttribute("error", e.toString());
		return "error";
	}
}