package com.ssafy.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller // 이렇게 Controller라는 annotation을 등록하면 xml 파일에서 scan하기 때문에 자동으로 Bean 등록이 된다.
public class ControllerParameter {
	
	// @RequestMapping(value="요청", method=RequestMethod.GET) 해서도 받을 수 있지만 
	// 편리하게 GET 요청을 받을 수 있는 @GetMapping annotation이 있다.
	@GetMapping("/test1")
	public String test1() { // 반환 타입 String이면 반환하는 값이 viewName이 된다.
		return "test1"; // View Resolver를 통해서 prefix + test1.jsp로 이동한다.
	}
	
	// prefix + test2.jsp로 이동하고 싶은데 데이터도 같이 보내고 싶다.
	// 사실 반환 타입을 ModelAndView로 바꾸면 되지만 그치만 싫어!!! 다른 방법도 보고 싶어!!
	@GetMapping("/test2-1")
	public String test2_1(Model model) {
		// parameter로 model을 넣어주면 메서드가 실행될 때 model을 사용할 수 있게 Spring이 알아서 넘겨준다.
		// model은 바구니이므로 아무거나 다 담을 수 있다.
		model.addAttribute("msg", "model data입니다.");
		
		return "test2"; // View Resolver를 통해서 prefix + test2.jsp로 이동
	}
	
	@GetMapping("/test2-2")
	public String test2_2(Map<String, Object> model) {
		model.put("msg", "map data입니다.");
		
		return "test2"; // View Resolver를 통해서 prefix + test2.jsp로 이동
	}
	
	// 파라미터 값을 가지고 오고 싶다.
	@GetMapping("/test3")
	public String test3(Model model, HttpServletRequest request) {
		// url에 query string으로 받은 id값을 가져와서
		String id = request.getParameter("id");
		
		// model에 그 id값을 저장
		model.addAttribute("id", id); 
		return "test3";
	}
	
	// 파라미터 값을 가지고 오고 싶다.
	// 근데 request.getParameter 이렇게 말고 annotation으로도 가져올 수 있어!!
	// @RequestParam 해서 값을 가져와서 바로 parameter에 담아!! 기본값도 줄 수 있어... key 이름도 무조건 id로만 해야하는 것도 아니야
	@GetMapping("/test3-1")
	public String test3_1(Model model, @RequestParam(value="myid", defaultValue="ssafy") String id, @RequestParam("pw") String pw) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "test3";
	}
	
	
}
