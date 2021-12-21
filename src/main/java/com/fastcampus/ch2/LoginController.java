package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping ("/login")
	public String loginForm() {
		return "loginForm"; 
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception {
		
		System.out.println("매개변수 체크 : id = "+id+" pwd = "+pwd+" rememberId = "+rememberId );
		
		//1. 아이디와 패스워드 확인
		if(!loginCheck(id, pwd)) {
			
			//2-1. 아이디 패스워드가 일치하지 않으면 loginForm으로 이동
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.","utf-8");
			
			//redirect의 경우 get요청으로 감
			return "redirect:/login/login?msg="+msg;
		}
		//2-2 일치하는 경우 rememberId 값에 따라 쿠키 생성 및 삭제
		
		if(rememberId) {
			// rememberId가 참이므로 쿠키 생성
			Cookie cookie = new Cookie("id",id); 
			//2-3 응답에 쿠키 저장
			response.addCookie(cookie);
			
		}else {
			// rememberId가 참이 아니므로 쿠키를 삭제해줘야함
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		//2-4 홈으로 이동
		return "redirect:/";
		
		
	}

	private boolean loginCheck(String id, String pwd) {
		//하기와 같이 코딩하면 매개변수의 null체크를 생략 가능함
		//id.equals("asdf") 일때 id 값이 널이면 에러가 발생하므로 !! 
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
