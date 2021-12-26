package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {

	/*
	 * @ExceptionHandler(Exception.class) public String catcher(Exception ex, Model
	 * model) { model.addAttribute("ex",ex); return "error"; }
	 */
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model model) {
//	  model.addAttribute("ex",ex);
	  return "error"; 
	  }

	
	@RequestMapping("/ex")
	//리턴이 void인 경우 매핑된 url.jsp로 요청이 가게되어 404에러가 발생함
	//따라서 만들어놓은 error.jsp를 사용할 경우 리턴값을 String으로 바꾸고 해당 jsp파일 이름으로 리턴해야함
	public String main() throws Exception {
			throw new Exception("예외가 발생했습니다.");
		}

	@RequestMapping("/ex2")
	public String main2() throws NullPointerException {
			throw new NullPointerException("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex3")
	public String main3() throws Exception{
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
	
}
