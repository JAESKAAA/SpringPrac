package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	//설정파일로 뺐음
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm";
	}

//	@RequestMapping(value="/register/save", method=Re	questMethod.POST)
	@PostMapping("/register/save") // 스프링 4.3버전 부터 추가되어 버전 확인이 필요함!! 현재 3.1.1버전이라 버전업그레이드 필요!
	public String save(User user, Model model) throws Exception {
		
		//1. 유효성 검사
		if(!isValid(user)) {
//			String msg = "id를 잘못 입력 하셨습니다."; // 이렇게 보내면 url에 인코딩된 한글값이 들어가지 못해 한글이 전부 깨지게 됨 
			String msg = URLEncoder.encode("id를 잘못 입력 하셨습니다.","utf-8"); // 이렇게 인코딩 처리를 해줘야 정상적으로 url에 유효값이 들어감
//			return "redirect:/register/add?msg="+msg; //URL재작성 (rewriting)
			
			//하기와 같이 모델에 담아줄 수도 있음
			
			model.addAttribute("msg",msg);
//			return "redirect:/register/add";
			return "forward:/register/add";
		}
		
		//2. DB에 데이터 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
	
	
}
