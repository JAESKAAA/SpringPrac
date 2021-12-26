package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCatcher {

	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex",ex);
		return "error";
	}
//	@ExceptionHandler(Exception.class)
//	public String catcher3(Exception ex, Model model) {
//		model.addAttribute("ex",ex);
//		return "error";
//	}
	
}
