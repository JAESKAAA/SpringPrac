package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //처리해줄 메서드가없어서 기존 500코드가 나오는데, ResponseStatus로 응답코드를 변경해 400에러가 표출되게 된다.
class MyException extends RuntimeException{
	
	MyException(String msg){
		super(msg);
	}
	MyException(){
		this("");
	}
}

@Controller
public class ExceptionController2 {

	//내부에 ExceptionHandler가 선언되어 있지 않아 에러처리가 정상적으로 수행되지않는다.
	//전역으로 처리할 경우 GlobalCatcher 클래스 참고
	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
			throw new MyException("예외가 엄청 발생했습니다.");
	}
	
	@RequestMapping("/ex5")
	public String main3() throws Exception{
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
	
}
