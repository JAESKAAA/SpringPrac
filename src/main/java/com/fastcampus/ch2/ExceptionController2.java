package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {

	//내부에 ExceptionHandler가 선언되어 있지 않아 에러처리가 정상적으로 수행되지않는다.
	//전역으로 처리할 경우 GlobalCatcher 클래스 참고
	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
			throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex5")
	public String main3() throws Exception{
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
	
}
